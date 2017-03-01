
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
        file://dts.patch \
"

KERNEL_DEVICETREE += " \
	am33xx_pwm-00A0.dtb \
	BB-PWM0-00A0.dtb \
        BB-PWM1-00A0.dtb \
        BB-PWM2-00A0.dtb \
"
