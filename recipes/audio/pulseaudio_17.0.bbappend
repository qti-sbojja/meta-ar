inherit useradd
FILESEXTRAPATHS:prepend := "${THISDIR}:"
SRC_URI += "file://pulseaudio/system.pa \
            file://pulseaudio/pulseaudio.service \
            file://pulseaudio/0001-Support-for-compress-offload-playback-usecase.patch \
            file://pulseaudio/0002-Propagate-port-change-events-to-all-devices.patch \
            file://pulseaudio/0003-libpulse-Initialize-channel-map-for-7-8-channel-audi.patch \
            file://pulseaudio/0004-pulsecore-Update-desired-sample-spec-for-requested-c.patch \
           "

do_compile:prepend() {
    mkdir -p ${S}/libltdl
    cp ${STAGING_LIBDIR}/libltdl* ${S}/libltdl
}

do_install:append:qcom() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/pulseaudio/pulseaudio.service ${D}${systemd_system_unitdir}
    install -d ${D}${systemd_system_unitdir}/multi-user.target.wants/
    # enable the service for multi-user.target
    ln -sf ${systemd_system_unitdir}/pulseaudio.service \
           ${D}${systemd_system_unitdir}/multi-user.target.wants/pulseaudio.service
    install -d ${D}${sysconfdir}/pulse/
    install -m 0644 ${UNPACKDIR}/pulseaudio/system.pa ${D}${sysconfdir}/pulse/system.pa
    install -m 0775 -g pulse -d ${D}${sysconfdir}/acdbdata/delta

    for i in $(find ${S}/src/pulsecore/ -type d -printf "pulsecore/%P\n"); do
        [ -n "$(ls ${S}/src/${i}/*.h 2>/dev/null)" ] || continue
        install -d ${D}${includedir}/${i}
        install -m 0644 ${S}/src/${i}/*.h ${D}${includedir}/${i}/
    done
}

USERADD_PACKAGES = "${PN}-server"
GROUPADD_PARAM:pulseaudio-server = "-g 5020 pulse"
USERADD_PARAM:pulseaudio-server = "--system --home /var/run/pulse \
                              --no-create-home --shell /bin/false \
                              --groups audio,pulse,input,plugdev,kmem --gid pulse pulse"

SYSTEMD_PACKAGES = "${PN}-server"

PACKAGES =+ "libpulsecore-dev"
FILES_libpulsecore-dev = "${includedir}/pulsecore/*"

# Explicitly create this directory for the volatile bind mount to work
FILES:${PN}-server += "/var/lib/pulse"
FILES:${PN} = "${datadir}/* ${libdir}/* ${sysconfdir}/* ${bindir}/* ${base_libdir}/* ${prefix}/libexec/"
