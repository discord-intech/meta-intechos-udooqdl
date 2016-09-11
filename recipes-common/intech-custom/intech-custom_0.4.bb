DESCRIPTION = "Custom messages for INTech CosmOS"
AUTHOR = "Discord"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

S = "${WORKDIR}"

PACKAGES = "${PN}"

SRC_URI=" \
	file://COPYING \
	file://motd \
	file://sshd_config \
	file://S20wlan \
	file://interfaces \
"

FILES_${PN} += "/etc/motd"

USER="root"

do_install() {
	install -d ${D}/etc/
        install -d ${D}/etc/network/
        install -d ${D}/etc/rc5.d/
	install -d ${D}/etc/ssh/
	install -m 0522 ${S}/sshd_config ${D}/etc/ssh/sshd_config
	install -m 0522 ${S}/motd ${D}/etc/motd
        install -m 0522 ${S}/interfaces ${D}/etc/network/interfaces
        install -m 0777 ${S}/S20wlan ${D}/etc/rc5.d/S20wlan
}
