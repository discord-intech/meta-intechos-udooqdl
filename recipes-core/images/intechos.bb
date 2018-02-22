DESCRIPTION		= "INTechOS Image"
SUMMARY 		= ""
SECTION 		= "image"
AUTHOR 			= "Julian DESVIGNES (discord) <julian.desvignes@telecom-sudparis.eu>"
RECIPE_MAINTAINER 	= "Julian DESVIGNES (discord) <julian.desvignes@telecom-sudparis.eu>"

PV = "V1.0"
PR = "r0"

inherit core-image

LICENSE = "GPLv2"

IMAGE_FEATURES += " \
	ssh-server-openssh \
"
	
NETWORKPKGS ?= " \
	rtl8812au \
"

JAVA = " \
	openjre-8 \
"

GSTREAMER ?= " \
	gstreamer1.0 \
	gstreamer1.0-libav \
	gstreamer1.0-meta-base \
	gstreamer1.0-omx \
	gstreamer1.0-plugins-imx \
	imx-gst1.0-plugin \
	gstreamer1.0-plugins-bad \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-good \
"

INTECHPKGS ?= " \
	intech-custom \
	ardyno \
	dynamixel-console \
	blacklib \
	motordaemon \
	motordaemonconsole \
"

IMAGE_INSTALL += " \
	dtc \	
	htop \
	modemmanager \
	networkmanager \
	dhcpcd \
	bossac \
	openssh \
	gnupg \
	screen \
	${JAVA} \
	${INTECHPKGS} \
	${GSTREAMER} \
"

IMAGE_FEATURES += "splash ssh-server-openssh package-management"

UDOO_EXTRA_INSTALL_arm = " \
    imx-gpu-viv \
    imx-gpu-viv-demos \
    packagegroup-fsl-tools-gpu \
    i2c-tools \
    dtc \
    ${@base_conditional("ENABLE_CAN_BUS", "1", "canutils", "", d)} \
    "
UDOO_EXTRA_INSTALL_x86-64 = " \
    "

IMAGE_INSTALL += "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    ${UDOO_EXTRA_INSTALL} \
    systemd \
    resize-rootfs \
    tmux \
    mobile-broadband-provider-info \
    wvdial \
    binutils \
    minicom \
    mmc-utils \
    "


# Needed by resize-rootfs
IMAGE_DEPENDS_ext4 = "e2fsprogs-native"
IMAGE_CMD_ext4_arm_append () {
        # Label the disk rootfs
        e2label ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext4 rootfs
}


EXTRA_USERS_PARAMS = "usermod -P intech root;"

export IMAGE_BASENAME = "intechos"
