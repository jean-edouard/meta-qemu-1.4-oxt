FILESEXTRAPATHS := "${THISDIR}/files:"

SRC_URI += " \
  file://add_wakeup_rpc_for_qemu.patch;patch=1 \
"

INC_PR="r500"
PR = "${INC_PR}.10"
