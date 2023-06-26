package bronze


fun main() {
    val br = System.`in`.bufferedReader()
    val (bulbCount, commandCount) = br.readLine().split(" ").map { it.toInt() }
    val bulbsState = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val commandedBulbs = CommandBulb(bulbsState)
    for (i in 1..commandCount) {
        val (command, startIdx, endIdx) = br.readLine().split(" ").map { it.toInt() }
        when (command) {
            1 -> commandedBulbs.changeTargetBulb(startIdx, endIdx)
            2 -> commandedBulbs.stateReversChangeBulbs(startIdx, endIdx)
            3 -> commandedBulbs.turnOffBulbs(startIdx, endIdx)
            4 -> commandedBulbs.turnOnBulbs(startIdx, endIdx)
        }
    }
    println(commandedBulbs.commandedBulbs)
}

class CommandBulb(private val bulbs: MutableList<Int>) {

    val commandedBulbs = bulbs

    fun changeTargetBulb(index: Int, changeNumber: Int) {
        commandedBulbs[index-1] = changeNumber
    }

    fun stateReversChangeBulbs(startIdx: Int, endIdx: Int) {
        for (i in startIdx - 1 until endIdx) if (commandedBulbs[i] == 1) commandedBulbs[i] = 0 else commandedBulbs[i] =
            1
    }

    fun turnOffBulbs(startIdx: Int, endIdx: Int) {
        for (i in startIdx - 1 until endIdx) commandedBulbs[i] = 0
    }

    fun turnOnBulbs(startIdx: Int, endIdx: Int) {
        for (i in startIdx - 1 until endIdx) commandedBulbs[i] = 1
    }

}
