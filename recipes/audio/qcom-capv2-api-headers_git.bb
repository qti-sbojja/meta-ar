inherit autotools pkgconfig

DESCRIPTION = "capi-v2 headers installation"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM += "file://capi_v2.h;beginline=30;endline=31;md5=487b3d43dd9a9b4377358ffdee8823c1"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/mm-audio-headers.git;protocol=ssh;branch=main"

S = "${UNPACKDIR}/git/capiv2_api"

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
