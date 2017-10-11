FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://arch-perl-fix.patch \
"
