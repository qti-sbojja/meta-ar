inherit autotools pkgconfig

DESCRIPTION = "Common mm-audio headers installation"

LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM += "file://PalDefs.h;beginline=30;endline=31;md5=cd3bda22acdbce80accc82bc10e1da57"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/arpal-lx.git;protocol=ssh;branch=main"

S = "${UNPACKDIR}/git/inc"

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"

