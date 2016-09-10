do_compile() {
    export CROSS_COMPILE=1
    export NATIVE_CC="gcc"
    export BUILD_OPT=1

    export FREEBL_NO_DEPEND=1
    export FREEBL_LOWHASH=1

    export LIBDIR=${libdir}
    export MOZILLA_CLIENT=1
    export NS_USE_GCC=1
    export NSS_USE_SYSTEM_SQLITE=1
    export NSS_ENABLE_ECC=1

    export OS_RELEASE=3.4
    export OS_TARGET=Linux
    export OS_ARCH=Linux

    if [ "${TARGET_ARCH}" = "powerpc" ]; then
        OS_TEST=ppc
    elif [ "${TARGET_ARCH}" = "powerpc64" ]; then
        OS_TEST=ppc64
    elif [ "${TARGET_ARCH}" = "mips" -o "${TARGET_ARCH}" = "mipsel" -o "${TARGET_ARCH}" = "mips64" -o "${TARGET_ARCH}" = "mips64el" ]; then
        OS_TEST=mips
    else
        OS_TEST="${TARGET_ARCH}"
    fi

    if [ "${SITEINFO_BITS}" = "64" ]; then
        export USE_64=1
    elif [ "${TARGET_ARCH}" = "x86_64" -a "${SITEINFO_BITS}" = "32" ]; then
        export USE_X32=1
    fi

    export NSS_DISABLE_GTESTS=1

    # We can modify CC in the environment, but if we set it via an
    # argument to make, nsinstall, a host program, will also build with it!
    #
    export CC="${CC} -g -w"
    make -C ./nss CCC="${CXX} -g -w" \
        OS_TEST=${OS_TEST} \
        RPATH="${RPATH}"
}
