DESCRIPTION = "Motor Daemon" 
SECTION = "examples" 
LICENSE = "CLOSED" 
PR = "r40"


SRC_URI = "git://github.com/discord-intech/MotorDaemon.git;protocol=https"
SRCREV="${AUTOREV}"


FILES_SOLIBSDEV = ""
FILES_${PN} += "${base_libdir}/*.so"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

do_install() {
    install -d ${D}${bindir}
    install -m 0755 MotorDaemon ${D}${bindir}
}
