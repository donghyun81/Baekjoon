package silver

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (trainCount, commandCount) = br.readLine().split(" ").map { it.toInt() }
    val trains = Array(trainCount){Train()}
    val resultTrains = mutableListOf<MutableList<Boolean>>()

    repeat(commandCount){
        val command = br.readLine().split(" ").map { it.toInt() }
        if (command.size==3) trains[command[1]-1].play1(command[0],command[2])
        if (command.size==2) trains[command[1]-1].play2(command[0])
    }
    for (i in trains) resultTrains.add(i.getTrainState())
    for(i in resultTrains.distinct()) println(i)
    print(resultTrains.distinct().size)

}

class Train() {
    private val trainState = MutableList<Boolean>(20) { false }
    fun getTrainState() = trainState

    fun play1(number:Int,seatNumber:Int){
        when(number){
            1 -> firstCommand(seatNumber)
            2 -> secondCommand(seatNumber)
        }
    }

    fun play2(number:Int){
        when(number){
            3 -> thirdCommand()
            4 -> forthCommand()
        }
    }

    fun firstCommand(seatNumber: Int) {
        trainState[seatNumber-1] = true
    }

    fun secondCommand(seatNumber: Int) {
        trainState[seatNumber-1] = false
    }
    fun thirdCommand() {
        Collections.rotate(trainState,1)
        trainState[0] =false
    }
    fun forthCommand() {
        Collections.rotate(trainState,-1)
        trainState[19] = false
    }
}
