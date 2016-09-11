FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://wpa-intech \
"


do_install_append() {
        install -m 600 ${WORKDIR}/wpa-intech ${D}${sysconfdir}/wpa_supplicant.conf
}

