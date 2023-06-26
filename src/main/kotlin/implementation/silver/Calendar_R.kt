package silver


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
    val prefix = IntArray(20)

    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    for (i in 1..n) {
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        prefix[a]++ // 각 시작 일정에 +1 1= ++ , 10 --
        prefix[b + 1]-- // 각 끝 일정 뒤에 --
    }
    println(prefix.toList())
    var mx = 0
    var ans = 0
    var prv = -1

    for (i in 1..19) {
        prefix[i] += prefix[i - 1]
        mx = maxOf(mx, prefix[i])

        if (prefix[i] == 0) {
            ans += (i - prv) * mx
            mx = 0
            prv = -1
            println(prefix.toList())
            println(ans)
        } else if (prv == -1) {
            prv = i
        }
    }

    println(ans)
}
