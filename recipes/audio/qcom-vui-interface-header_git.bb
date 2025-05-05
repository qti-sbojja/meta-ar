inherit autotools pkgconfig

DESCRIPTION = "vui-interface header"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM += "file://VoiceUIInterface.h;beginline=9;endline=11;md5=6e81219b9da09d37472d59042b06a623"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/arpal-lx.git;protocol=ssh;branch=main"

S = "${UNPACKDIR}/git/plugins/vui_interface/api/vui-interface"

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
