DESCRIPTION		= "INTech CosmOS Image"
SUMMARY 		= ""
SECTION 		= "image"
AUTHOR 			= "Julian DESVIGNES (discord) <julian.desvignes@telecom-sudparis.eu>"
RECIPE_MAINTAINER 	= "Julian DESVIGNES (discord) <julian.desvignes@telecom-sudparis.eu>"

PV = "V1.0"
PR = "r0"

include recipes-core/images/rpi-basic-image.bb

IMAGE_FEATURES += " \
	ssh-server-openssh \
"

NETWORKPKGS ?= " \
	wpa-supplicant \
"

JAVA ?= " \
	openjre-8 \
	rxtx \
"

INTECHPKGS ?= " \
	intech-custom \
	ardyno \
	dynamixel-console \
"

IMAGE_INSTALL += " \
    	${NETWORKPKGS} \
	${INTECHPKGS} \
	${JAVA} \
"

IMAGE_INSTALL_append_raspberrypi3 ?= " \
	linux-firmware-brcm43430 \
"

IMAGE_DEV_MANAGER   	    = "udev"
IMAGE_LOGIN_MANAGER 	    = "busybox shadow"
IMAGE_INIT_MANAGER  	    = "systemd"
EXTRA_USERS_PARAMS 	    = "usermod -P intech root;"

