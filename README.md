## HOW TO FLASH BILLY

Your machine should be a Raspberry PI (any model), we do not support other boards for now (and we won't, HA !)

# Dependencies

Yocto has some dependancies, refer to that page to install them :

    http://www.yoctoproject.org/docs/2.1/mega-manual/mega-manual.html#packages

# Creating your workdir

First of all, you should select a folder where you'll do everything, where you must have, at least, 2GB of free disk space to compile. Make sure you have an SSH key correctly entered in your github account, or you won't be able to clone that repo.

Then execute those lines in the folder you've chosen :

    git clone git://git.yoctoproject.org/poky -b krogoth
    cd poky
    git clone git://git.openembedded.org/meta-openembedded -b krogoth
    git clone git://git.yoctoproject.org/meta-raspberrypi
    git clone git@github.com:TechTheBilly/meta-intech-cosmo.git

This will simply clone all the files you need to perform the compilation. If the last one failed, just change the address with the HTTPS one you can find on our main page.

# Preparing to compile

Make sure you are inside the poky folder, then execute this :

    source oe-init-build-env

It will configure your environment for bitbake, create a build folder with default parameters and cd in it.

Now you need to replace bblayers.conf and local.conf inside the conf folder (poky/build(you should be here)/conf/) with the ones available in meta-intech-cosmo, you can do that with those lines (make sure you are in the build folder !) :

    cp ../meta-intech-cosmo/build_conf/bblayers.conf conf/
    cp ../meta-intech-cosmo/build_conf/local.conf conf/

# (Optional) Change the default board

This configuration is by default for the Rapsberry PI 3, so if you want to change that you need to edit the file conf/local.conf and find

    MACHINE ?= "raspberrypi3"

and change "raspberrypi3" by "raspberrypi" for Ver.1, "raspberrypi2" for Ver.2, "raspberrypi0" for Raspberry PI Zero

# Compiling !

While inside the build dir, execute this command :

    bitbake intech-cosmo-os-image

This will launch the compilation, it can be quite long for the first time. (~1H on an AMD eight-core)

If everything went fine, it should end with :

    NOTE: Tasks Summary: Attempted XXXX tasks of which YYYY didn't need to be rerun and all succeeded.
    
If it failed, please recheck all the steps and contact us if you can't find the cause.

# Flashing !

You should have an image inside build/tmp/deploy/images/\*your\_raspberry\_model\*/ it ends with .rpi-sdimg

Copy that file somewhere you want (or don't move it, for what I care...) and plug a SD-CARD inside your computer (we will detroy everything on it). 

Your must find your device name inside /dev/ and I said the device, not the partition(s) ! Exemple : for me it's /dev/mmcblk0

Now execute this command (replace \*your_image\* and \*your\_SD\_device\* ofc):

    sudo dd if=*your_image*.rpi-sdimg of=*your_SD_device* bs=1M
    
Now you can unplug the SD and start your Raspberry PI with it, have fun !
