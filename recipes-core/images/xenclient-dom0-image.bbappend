PRINC := "${@int(PRINC) + 500}"

IMAGE_INSTALL += " qemu-dm "

PACKAGE_REMOVE += " ioemu "
