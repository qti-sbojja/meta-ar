SUMMARY = "AGM for AROSP"

LICENSE = "BSD-3-Clause & LGPL-2.1-only"
LIC_FILES_CHKSUM += "file://service/src/agm.c;beginline=30;endline=31;md5=c83ea7207cf32b515967896ac7a5f0bc \
                     file://service/inc/public/agm/agm_api.h;beginline=31;endline=32;md5=a9dbeefccf4ce4cbca8bec9b1d848da3"

inherit autotools pkgconfig

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/agm.git;protocol=ssh;branch=main"

S = "${UNPACKDIR}/git"

DEPENDS = "glib-2.0 qcom-kvh2xml tinyalsa tinycompress qcom-args expat"
EXTRA_OECONF += "--with-glib --with-syslog --with-no-ipc"
SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"
