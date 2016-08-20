DESCRIPTION		= "INTech Cosmo OS Image"
SUMMARY 		= ""
SECTION 		= "image"
AUTHOR 			= "Julian DESVIGNES (discord) <julian.desvignes@telecom-sudparis.eu>"
RECIPE_MAINTAINER 	= "Julian DESVIGNES (discord) <julian.desvignes@telecom-sudparis.eu>"

PV = "V1.0"
PR = "r0"

inherit rpi-basic-image

NETWORKPKGS ?= " \
    	networkmanager \
"

INTECHPKGS ?= " \
"

IMAGE_INSTALL += " \
    	${NETWORKPKGS} \
	${INTECHPKGS} \
"

IMAGE_DEV_MANAGER   	    = "udev"
IMAGE_LOGIN_MANAGER 	    = "busybox shadow"
IMAGE_INIT_MANAGER  	    = "systemd"
EXTRA_USERS_PARAMS 	    = "usermod -P intech root;"
