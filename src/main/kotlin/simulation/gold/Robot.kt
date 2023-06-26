package gold

import java.util.Collections
import kotlin.system.measureNanoTime
//
//fun main(){
//    val br = System.`in`.bufferedReader()
//    val (n,k)= br.readLine().split(" ").map { it.toInt() }
//    val nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()
//    val elapsed: Long = measureNanoTime {
//        Robot().solution(n,k,nums)
//    }
//    println(elapsed)
//}
//
//class Robot() {
//    var n = 0
//    var k = 0
//    val nums = mutableListOf<IntArray>()
//
//    fun solution(n:Int,k:Int,nums:IntArray){
//        this.n = n
//        this.k = k
//        nums.forEachIndexed{ idx,num ->
//            this.nums.add(intArrayOf(idx,num,0))
//        }
//        var answer = 0
//        while (true){
//            answer++
//            rotate()
//            moveRobot()
//            putOnRobot()
//            if(this.nums.filter { it[1] ==0 }.size ==k) break
//        }
//        println(answer)
//
//    }
//    fun rotate(){
//        Collections.rotate(nums,1)
//        outRobot()
//
//    }
//    fun putOnRobot(){
//        if (nums[0][1] > 0 && nums[0][2] != 1) {
//            nums[0][2] = 1
//            nums[0][1]--
//        }
//    }
//    fun outRobot(){
//        if (nums[n-1][2] !=0){
//            nums[n-1][2] = 0
//        }
//    }
//    fun moveRobot(){
//       for (idx in n-1 downTo 0){
//           if (nums[idx][2] ==1 && nums[idx+1][2] == 0 && nums[idx+1][1]>0) {
//               nums[idx][2] = 0
//               nums[idx+1][1]--
//               nums[idx+1][2] = 1
//               if (n-2==idx) outRobot()
//           }
//       }
//    }
//}

import java.util.*

//fun main() {
//    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
//
//    val belts = mutableListOf(1)
//    belts.addAll(readLine()!!.split(" ").map { it.toInt() })
//
//    val isRobot = MutableList(belts.size) { false }
//    val robots = mutableListOf<Int>()
//
//    fun rotate() {
//        val n = belts.removeLast()
//        belts.add(1, n)
//
//        val newRobots = mutableListOf<Int>()
//        isRobot.fill(false)
//
//        for (beltIndex in robots) {
//            val nextBeltIndex = beltIndex + 1
//            if (nextBeltIndex < N) {
//                newRobots.add(nextBeltIndex)
//                isRobot[nextBeltIndex] = true
//            }
//        }
//
//        robots.clear()
//        robots.addAll(newRobots)
//    }
//
//    fun moveRobots() {
//        val newRobots = mutableListOf<Int>()
//
//        for (beltIndex in robots) {
//            val nextIndex = beltIndex + 1
//            if (isRobot[nextIndex] || belts[nextIndex] < 1) {
//                newRobots.add(beltIndex)
//            } else {
//                belts[nextIndex] -= 1
//                isRobot[beltIndex] = false
//                if (nextIndex != N) {
//                    newRobots.add(nextIndex)
//                    isRobot[nextIndex] = true
//                }
//            }
//        }
//
//        robots.clear()
//        robots.addAll(newRobots)
//    }
//
//    fun insertRobot() {
//        if (belts[1] != 0) {
//            robots.add(1)
//            belts[1] -= 1
//            isRobot[1] = true
//        }
//    }
//
//    fun isFinish(): Boolean {
//        return belts.count { it == 0 } >= K
//    }
//    val elapsed: Long = measureNanoTime {
//        var cnt = 0
//        while (!isFinish()) {
//            cnt += 1
//            rotate()
//            moveRobots()
//            insertRobot()
//        }
//        println(cnt)
//    }
//    println(elapsed)
//
//}

//3 2 n k
//1 2 1 2 1 2 2n
fun main(){
    Robot().solution()

}

class Robot{
    var n = 0
    var k = 0
    var zeroCnt = 0
    lateinit var belt:MutableList<Int>
    lateinit var beltState : MutableList<Boolean>
    fun solution(){
        val br = System.`in`.bufferedReader()
        val(n,k) = br.readLine().split(" ").map { it.toInt() }
        this.n = n
        this.k = k
        belt = br.readLine().split(" ").map { it.toInt() }.toMutableList()
        beltState = MutableList(n) {false}
        var stop = false
        var cnt = 0
        while(zeroCnt < k){
            moveBelt()
            outRobot()
            robotMove()
            outRobot()
            inRobot()
            cnt++
        }
        println(cnt)
    }

    fun moveBelt(){
        Collections.rotate(belt,1)
        Collections.rotate(beltState,1)
    }

    fun robotMove(){
        for(i in n-2 downTo 0){
            if (beltState[i] && belt[i+1] >0 && !beltState[i+1]) {
                beltState[i] = false
                belt[i+1]--
                if (belt[i+1] == 0) zeroCnt++
                beltState[i+1] = true
            }
        }
    }
    fun inRobot(){
        if (belt[0] > 0) {
            beltState[0] = true
            belt[0]--
            if (belt[0]==0) zeroCnt++
        }
    }
    fun outRobot(){
        if (beltState[n-1]) beltState[n-1] = false
    }


}
