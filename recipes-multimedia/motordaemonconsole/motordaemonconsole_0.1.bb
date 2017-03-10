DESCRIPTION = "Motor Daemon Localhost Console" 
SECTION = "examples" 
LICENSE = "CLOSED" 
PR = "r3" 

DEPENDS = "motordaemon"

SRC_URI = "git://github.com/discord-intech/MotorDaemonConsole.git;protocol=https"
SRCREV="${AUTOREV}"


FILES_SOLIBSDEV = ""
FILES_${PN} += "${base_libdir}/*.so"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

do_install() {
    install -d ${D}${bindir}
    install -m 0755 MotorDaemonConsole ${D}${bindir}
}
