DESCRIPTION = "Ardyno-cosmo : A Dynamixel device library" 
SECTION = "library"
LICENSE = "CLOSED" 
PR = "r1" 

FILES_${PN} += "${libdir}/*.so"

FILES_SOLIBSDEV = ""

SRC_URI = "git://github.com/TechTheBilly/ardyno-cosmo.git;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

do_install_append() {
	install -d ${D}${includedir}
	install -m 0644 ${S}/include/Dynamixel.h ${D}${includedir}
        install -m 0644 ${S}/include/DynamixelInterface.h ${D}${includedir}
        install -m 0644 ${S}/include/DynamixelMotor.h ${D}${includedir}
        install -m 0644 ${S}/include/SerialInterface.hpp ${D}${includedir}
}

