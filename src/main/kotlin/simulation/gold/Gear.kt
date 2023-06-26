package gold

import java.util.Collections


//10101111 1번 바퀴
//01111101
//11001110
//00000010 4번 바퀴
//2 돌리는 횟수
//3 -1 3번 바퀴 반시계
//1 1 1번 바퀴 시계
//fun main(){
//    val br = System.`in`.bufferedReader()
//    val gears = mutableListOf<MutableList<Int>>()
//    repeat(4){
//        gears.add(br.readLine().map { it.digitToInt() }.toMutableList())
//    }
//    val rotateCnt = br.readLine().toInt()
//    repeat(rotateCnt){
//        val (targetGear,rotateDir) = br.readLine().split(" ").map { it.toInt() }
//        var leftMove = targetGear -1
//        var rightMove = targetGear -1
//        var leftRotateDir = rotateDir
//        var rightRotateDir = rotateDir
//
//        val tempGears = gears.map { it.toMutableList() }
//        Collections.rotate(gears[targetGear-1],rotateDir)
//
//        while (leftMove>0){
//            if (tempGears[leftMove][6] != tempGears[leftMove-1][2]) {
//                leftRotateDir = if (leftRotateDir==1) -1 else 1
//                Collections.rotate(gears[leftMove-1],leftRotateDir)
//                leftMove--
//            } else break
//        }
//        while (rightMove<3){
//            if (tempGears[rightMove][2] != tempGears[rightMove+1][6]){
//                rightRotateDir = if (rightRotateDir==1) -1 else 1
//                Collections.rotate(gears[rightMove+1],rightRotateDir)
//                rightMove++
//            } else break
//        }
//    }
//    var addNum = 1
//    var answer = 0
//    gears.forEach{
//        if (it[0] == 1) answer+=addNum
//        addNum *=2
//    }
//    println(answer)
//}

//10101111 1번 바퀴
//01111101
//11001110
//00000010 4번 바퀴
//2 돌리는 횟수
//3 -1 3번 바퀴 반시계
//1 1 1번 바퀴 시계

fun main(){
    Gear().solution()
}
class Gear {
    lateinit var gears:Array<List<Int>>
    var gearsNum = 0
    var direction = 0
    fun solution(){
        val br = System.`in`.bufferedReader()
        this.gears = Array(4){br.readLine().map { it.digitToInt() }}
        val cnt = br.readLine().toInt()
        var answer = 0
        var addSum = 1
        repeat(cnt){
            val (num,dir) = br.readLine().split(" ").map { it.toInt() }
            rotate(num-1,dir)
        }
        gears.forEach {
            if (it[0] == 1) answer +=addSum
            addSum *=2
        }
        println(answer)
    }
    fun rotate(gearNum:Int,direction:Int){
        var moveLeftGear = gearNum
        var moveRightGear = gearNum
        var curDirection = direction
        val tempGears = gears.map { it.toList() }
        Collections.rotate(gears[gearNum],curDirection)
        while (moveLeftGear >0){
            if (tempGears[moveLeftGear-1][2] != tempGears[moveLeftGear][6]){
               curDirection =  if(curDirection ==1 ) -1 else 1
               Collections.rotate(gears[moveLeftGear-1],curDirection)
                moveLeftGear--
            }else break
        }
        curDirection = direction
        while (moveRightGear < 3){
            if (tempGears[moveRightGear][2] != tempGears[moveRightGear+1][6]){
                curDirection =  if(curDirection ==1 ) -1 else 1
                Collections.rotate(gears[moveRightGear+1],curDirection)
                moveRightGear++
            }else break
        }
    }
}