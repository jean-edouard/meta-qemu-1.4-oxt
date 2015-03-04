FILESEXTRAPATHS := "${THISDIR}/files:"

SRC_URI += " \
  file://send_wakeup_rpc_to_qemu.patch;patch=1 \
"

INC_PR="r500"
PR = "${INC_PR}.10"
