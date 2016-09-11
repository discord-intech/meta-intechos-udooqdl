DESCRIPTION = "Ardyno-cosmo : A Dynamixel device library" 
SECTION = "library"
LICENSE = "CLOSED" 
PR = "r1" 

SRC_URI = "git://github.com/TechTheBilly/ardyno-cosmo.git;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

do_install() {  
	install -d ${D}${libdir}
        install -d ${D}${includedir}
	install -m 0644 ${S}/include/Dynamixel.h ${D}${includedir}
        install -m 0644 ${S}/include/DynamixelInterface.h ${D}${includedir}
        install -m 0644 ${S}/include/DynamixelMotor.h ${D}${includedir}
        install -m 0644 ${S}/include/SerialInterface.hpp ${D}${includedir}
	install -m 0644 ${WORKDIR}/build/libardyno.so ${D}${libdir}/libardyno.so.1
}

