inherit autotools pkgconfig

DESCRIPTION = "kvh2xml header"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM += "file://kvh2xml.h;beginline=2;endline=8;md5=196c6214e746e6e8bc48391c148ac7c5"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/ar-conf.git;protocol=ssh;branch=main"

S = "${UNPACKDIR}/git/acdbdata"

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
