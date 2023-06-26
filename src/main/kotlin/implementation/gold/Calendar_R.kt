package gold


//fun main(){
//    val br = System.`in`.bufferedReader()
//    val scheduleCount = br.readLine().toInt()
//    val calendar = mutableListOf<MutableList<Int>>()
//    val (startDay,endDay) = br.readLine().split(" ").map{it.toInt()}
//    repeat(scheduleCount-1){
//        val (startDay,endDay) = br.readLine().split(" ").map{it.toInt()}
//        for(i in calendar){
//            println(i.any{ (startDay..endDay).contains(it)})
//            if (i.any{ (startDay..endDay).contains(it) }) calendar.add((startDay..endDay).toMutableList())
//        }
//    }
//    println(calendar)
//}

import java.util.*

fun main() {
    val prefix = IntArray(367)
    val br = System.`in`.bufferedReader()
    repeat(br.readLine().toInt()){
        val (s,e) = br.readLine().split(" ").map { it.toInt() }
        prefix[s]++
        prefix[e+1]--
    }
    var max=0
    var pre = -1
    var answer = 0
    for (i in 1 until prefix.size){
        prefix[i] += prefix[i-1]
        max = maxOf(prefix[i],max)
        if (prefix[i] == 0){
            answer += (i-pre) *max
            pre = -1
            max = 0
        }else if (pre == -1) pre = i
    }
    println(answer)
}
