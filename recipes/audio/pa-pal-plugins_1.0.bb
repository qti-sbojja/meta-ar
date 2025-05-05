inherit autotools pkgconfig
SUMMARY = "Pulseaudio pal plugins"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM += "file://module-pal-card/inc/pal-card.h;beginline=3;endline=4;md5=1dd4ca71ef61f580a6a5f3d113727dd9"


SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/pulseaudio-plugin.git;protocol=ssh;branch=main"

S = "${UNPACKDIR}/git/modules/pa-pal-plugins"

DEPENDS = "qcom-agm pulseaudio qcom-pal qcom-pal-headers qcom-vui-interface-header"
EXTRA_OECONF = " --with-pa_version=17.0 --without-pa-support-card-status"

PACKAGES =+ "\
             pulseaudio-module-pal-card \
             pulseaudio-module-pal-voiceui-card \
            "
FILES:pulseaudio-module-pal-card = "${libdir}/pulseaudio/modules/module-pal-card.so ${sysconfdir}/*"
FILES:pulseaudio-module-pal-voiceui-card = "${libdir}/pulseaudio/modules/module-pal-voiceui-card.so"

RDEPENDS:pulseaudio-server = " pulseaudio-module-pal-card"
RDEPENDS:pulseaudio-server = " pulseaudio-module-pal-voiceui-card"

ALLOW_EMPTY:${PN} = "1"
