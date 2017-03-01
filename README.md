# HOW TO FLASH

Your machine should be a BeagleBone Black, we do not support other boards for now (and we won't, HA !)

## Dependencies

Yocto has some dependencies, refer to that page to install them :

    http://www.yoctoproject.org/docs/2.1/mega-manual/mega-manual.html#packages

## Creating your workdir

First of all, you should select a folder where you'll do everything, where you must have, at least, 2GB of free disk space to compile. Make sure you have an SSH key correctly entered in your github account, or you won't be able to clone that repo.

Then execute those lines in the folder you've chosen :

    git clone git://git.yoctoproject.org/poky -b krogoth
    cd poky
    git clone git://git.openembedded.org/meta-openembedded -b krogoth
    git clone https://github.com/jumpnow/meta-bbb.git -b krogoth
    git clone https://github.com/meta-qt5/meta-qt5.git -b krogoth
    git clone git://git.yoctoproject.org/meta-java
    git clone https://github.com/discord-intech/meta-intechos.git

This will simply clone all the files you need to perform the compilation. If the last one failed, just change the address with the HTTPS one you can find on our main page.

## Preparing to compile

Make sure you are inside the poky folder, then execute this :

    source oe-init-build-env

It will configure your environment for bitbake, create a build folder with default parameters and cd in it.

Now you need to replace bblayers.conf and local.conf inside the conf folder (poky/build(you should be here)/conf/) with the ones available in meta-intech-cosmo, you can do that with those lines (make sure you are in the build folder !) :

    cp ../meta-intechos/build_conf/bblayers.conf conf/
    cp ../meta-intechos/build_conf/local.conf conf/

## Compiling !

While inside the build dir, execute this command :

    bitbake intechos

If you want the "dev" version with multiple dev tools like OpenJDK, GCC5 and Cmake, execute this one instead :

    bitbake intechos-dev
    
This "dev" image is a bigger than the classic one, due to these dev tools.

This will launch the compilation, it can be quite long for the first time. (~1H on an AMD eight-core)

If everything went fine, it should end with :

    NOTE: Tasks Summary: Attempted XXXX tasks of which YYYY didn't need to be rerun and all succeeded.
    
If it failed, please recheck all the steps and contact us if you can't find the cause.

## Flashing !

WIP
