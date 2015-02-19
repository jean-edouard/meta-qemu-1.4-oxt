require qemu-dm.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/qemu-dm-1.4.0:"

SRC_URI += "file://static-fix.patch;patch=1 \
            file://ioreq-server-upstream.patch;patch=1 \
            file://ioreq-server.patch;patch=1 \
            file://logging-syslog.patch;patch=1 \
            file://bridge-helper-syslog.patch;patch=1 \
            file://dmbus.patch;patch=1 \
            file://pci-reserve-igd-slot.patch;patch=1 \
            file://switcher.patch;patch=1 \
            file://acpi.patch;patch=1 \
            file://xc-emulated-nic-link-state-propagation.patch;patch=1 \
            file://battery.patch;patch=1 \
            file://audio-alsa.patch;patch=1 \
            file://xenmou.patch;patch=1 \
            file://audio-alsa-stub.patch;patch=1 \
            file://atapi-pass-through.patch;patch=1 \
            file://vbe-xt-extensions.patch;patch=1 \
            file://vga-spinlock.patch;patch=1 \
            file://vga-shadow-bda.patch;patch=1 \
            file://surfman-dcl.patch;patch=1 \
            file://audio-policy.patch;patch=1 \
            file://qemu-ifup-stubdom \
            file://fix-surfman-coherency.patch;patch=1 \
            file://change-default-pixelformat.patch;patch=1 \
            file://xen_pci_subsystem_id.patch;patch=1 \
            "

SRC_URI[tarball.md5sum] = "78f13b774814b6b7ebcaf4f9b9204318"
SRC_URI[tarball.sha256sum] = "066297ed77408fb7588889c271a85cf3c259ad55c939315988e6062d7708eda8"

EXTRA_OECONF += "--enable-debug --disable-strip --audio-drv-list=xen_alsa"

do_install_append(){
    install -m 0755 -d ${D}${sysconfdir}/qemu
    install -m 0755 ${WORKDIR}/qemu-ifup-stubdom ${D}${sysconfdir}/qemu/qemu-ifup
}

PR = "${INC_PR}.2"
