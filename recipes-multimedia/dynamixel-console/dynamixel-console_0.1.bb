DESCRIPTION = "Dynamixel Console" 
SECTION = "examples" 
LICENSE = "CLOSED" 
PR = "r0" 

DEPENDS = "ardyno"

SRC_URI = "git://github.com/TechTheBilly/ardyno-cosmo-console.git;protocol=https"
SRCREV="${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

do_install() {
    install -d ${D}${bindir}
    install -m 0755 DynamixelInterface ${D}${bindir}
}
