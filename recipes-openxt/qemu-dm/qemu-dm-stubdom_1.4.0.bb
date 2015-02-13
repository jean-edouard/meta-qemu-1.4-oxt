require qemu-dm.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/qemu-dm-1.4.0:"

SRC_URI += " \
            file://0001-static-fix.patch;patch=1 \
            file://0002-ioreq-server-upstream.patch;patch=1 \
            file://0003-ioreq-server.patch;patch=1 \
            file://0004-logging-syslog.patch;patch=1 \
            file://0005-bridge-helper-syslog.patch;patch=1 \
            file://0006-dmbus.patch;patch=1 \
            file://0007-pci-reserve-igd-slot.patch;patch=1 \
            file://0008-switcher.patch;patch=1 \
            file://0009-acpi.patch;patch=1 \
            file://0010-xc-emulated-nic-link-state-propagation.patch;patch=1 \
            file://0011-battery.patch;patch=1 \
            file://0012-audio-alsa.patch;patch=1 \
            file://0013-xenmou.patch;patch=1 \
            file://0014-audio-alsa-stub.patch;patch=1 \
            file://0015-atapi-pass-through.patch;patch=1 \
            file://0016-vbe-xt-extensions.patch;patch=1 \
            file://0017-vga-spinlock.patch;patch=1 \
            file://0018-vga-shadow-bda.patch;patch=1 \
            file://0019-surfman-dcl.patch;patch=1 \
            file://0020-audio-policy.patch;patch=1 \
            file://0021-fix-surfman-coherency.patch;patch=1 \
            file://0022-change-default-pixelformat.patch;patch=1 \
            file://qemu-ifup-stubdom \
            "

SRC_URI[tarball.md5sum] = "78f13b774814b6b7ebcaf4f9b9204318"
SRC_URI[tarball.sha256sum] = "066297ed77408fb7588889c271a85cf3c259ad55c939315988e6062d7708eda8"

EXTRA_OECONF += "--enable-debug --disable-strip --audio-drv-list=xen_alsa"

do_install_append(){
    install -m 0755 -d ${D}${sysconfdir}/qemu
    install -m 0755 ${WORKDIR}/qemu-ifup-stubdom ${D}${sysconfdir}/qemu/qemu-ifup
}

PR = "${INC_PR}.2"
