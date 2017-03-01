SUMMARY = "DTB overlays for Beaglebone"
HOMEPAGE = "https://github.com/beagleboard/bb.org-overlays"
SECTION = "bootloader"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=9682d76c70523c172282bb78caa39cdd"

DEPENDS = "dtc-native"

SRCREV = "961e2ee94bde68f2a5602a93419a2bb36270eea2"

SRC_URI = " \
    git://github.com/beagleboard/bb.org-overlays.git \
    file://dtc-bin.patch \
    file://dtc-pwm.patch \
    "

S = "${WORKDIR}/git"

inherit autotools-brokensep

PACKAGES = "${PN}"
FILES_${PN} += "/lib/firmware"

do_install_prepend () {
    mkdir -p ${D}/lib/firmware
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "beaglebone"
