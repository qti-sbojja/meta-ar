SUMMARY = "AROSP"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM += "file://gsl/src/gsl_common.c;beginline=8;endline=10;md5=11d3c815cc6a184e4353d57fd881075b \
                     file://gsl/inc/gsl_common.h;beginline=10;endline=12;md5=4dad47014329490ef305842c8f484b7d"

inherit autotools pkgconfig

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://git@github.com/Audioreach/args.git;protocol=ssh;branch=main"

S = "${UNPACKDIR}/git"

DEPENDS = "glib-2.0 virtual/kernel"
DEPENDS += "linux-qcom-staging"


EXTRA_OECONF += " --with-syslog --with-glib --with-dummy_diag --with-audio_dma_support --with-linuxheaderklm  ac_cv_func_strlcpy=yes"
EXTRA_OECONF += " --with-sanitized-headers=${STAGING_KERNEL_DIR}/include/uapi/sound/qcom"


SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

PACKAGECONFIG ??= "qcom"
PACKAGECONFIG[qcom] = "--with-qcom, --without-qcom"

RRECOMMENDS:${PN} = " \
   kernel-module-audio-pkt \
   kernel-module-spf-core"
