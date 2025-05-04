inherit autotools pkgconfig systemd

DESCRIPTION = "pal"
SECTION = "multimedia"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM += "file://Pal.cpp;beginline=31;endline=32;md5=c83ea7207cf32b515967896ac7a5f0bc \
                     file://inc/PalDefs.h;beginline=30;endline=31;md5=cd3bda22acdbce80accc82bc10e1da57"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/arpal-lx.git;protocol=ssh;branch=main"

S = "${UNPACKDIR}/git"

DEPENDS = "tinyalsa tinycompress qcom-agm qcom-kvh2xml qcom-audioroute qcom-pal-headers qcom-capv2-api-headers"

EXTRA_OECONF += " --with-glib --with-syslog --with-qli ac_cv_func_strlcpy=yes"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

FILES:${PN} += "${libdir}/*.so ${libdir}/pkgconfig/ ${sysconfdir}/* ${bindir}/*"
FILES:${PN}-dev = "${libdir}/*.la ${includedir}"
