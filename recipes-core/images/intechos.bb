DESCRIPTION		= "INTechOS Image"
SUMMARY 		= ""
SECTION 		= "image"
AUTHOR 			= "Julian DESVIGNES (discord) <julian.desvignes@telecom-sudparis.eu>"
RECIPE_MAINTAINER 	= "Julian DESVIGNES (discord) <julian.desvignes@telecom-sudparis.eu>"

PV = "V1.0"
PR = "r0"

include images/console-image.bb


IMAGE_FEATURES += " \
	ssh-server-openssh \
"
	
NETWORKPKGS ?= " \
	rtl8812au \
"

JAVA ?= " \
	openjre-8 \
	rxtx \
"

GSTREAMER ?= " \
	gstreamer1.0 \
	gstreamer1.0-libav \
	gstreamer1.0-meta-base \
	gstreamer1.0-omx \
	gstreamer1.0-plugins-bad \
	gstreamer1.0-plugins-base \
	gstreamer1.0-plugins-good \
"

INTECHPKGS ?= " \
	intech-custom \
	bb-org-overlays \
	ardyno \
	dynamixel-console \
	blacklib \
	motordaemon \
	motordaemonconsole \
"

IMAGE_INSTALL += " \
	dtc \	
	openssh \
	gnupg \
	screen \
	${NETWORKPKGS} \
	${INTECHPKGS} \
	${GSTREAMER} \
	${JAVA} \
"

IMAGE_INSTALL_append_raspberrypi3 ?= " \
	linux-firmware-brcm43430 \
"

IMAGE_DEV_MANAGER   	    = "udev"
IMAGE_LOGIN_MANAGER 	    = "busybox shadow"
IMAGE_INIT_MANAGER  	    = "systemd"
EXTRA_USERS_PARAMS 	    = "usermod -P intech root;"

export IMAGE_BASENAME = "intechos"
