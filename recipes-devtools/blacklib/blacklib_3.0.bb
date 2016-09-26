DESCRIPTION = "BlackLib : a BeagleBone Black C++ API"
SECTION = "library"
LICENSE = "CLOSED"
PR = "r1"

FILES_${PN} += "${libdir}/*.so"

FILES_SOLIBSDEV = ""

SRC_URI = "git://github.com/discord-intech/BlackLib.git;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git/v3_0"

inherit pkgconfig cmake

do_install_append() {
        install -d ${D}${includedir}
        install -m 0644 ${S}/include/* ${D}${includedir}
}

