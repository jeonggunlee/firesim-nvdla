//See LICENSE for license details.

package firesim.midasexamples

import chisel3._

class AssertModule extends Module {
  val io = IO(new Bundle {
    val cycleToFail  = Input(UInt(16.W))
    val a  = Input(Bool())
    val b  = Input(Bool())
  })
  val cycle = RegInit(0.U(16.W))
  cycle := cycle + 1.U

  assert(io.cycleToFail != cycle || !io.a, "A asserted")
  when (io.cycleToFail === cycle) {
    assert(!io.b, "B asserted")
  }
}

