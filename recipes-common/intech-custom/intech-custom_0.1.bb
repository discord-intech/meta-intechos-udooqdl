DESCRIPTION = "Custom messages for INTech CosmOS"
AUTHOR = "Discord"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

S = "${WORKDIR}"

PACKAGES = "${PN}"

SRC_URI=" \
	file://COPYING \
	file://motd \
"

FILES_${PN} += "/etc/motd"

USER="root"

do_install() {
	install -d ${D}/etc/
	install -m 0522 ${S}/motd ${D}/etc/motd
}
