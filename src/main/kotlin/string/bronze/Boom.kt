package bronze


//20:00:00
//04:00:00
fun main(){
    val br = System.`in`.bufferedReader()
    val (startH,startM,startC) = br.readLine().split(":").map { it.toInt() }
    val (endH,endM,endC) = br.readLine().split(":").map{it.toInt()}
    val startTime = startH*3600+startM*60+startC
    val endTime = endH*3600+endM*60+endC
    var answer = if (startTime >= endTime) (endTime+24*3600) - startTime else endTime-startTime
    var answerSet = mutableListOf<Int>()
    val a = listOf(3600,60,1)
    for (i in a){
        answerSet.add(answer/i)
        answer %= i
    }
    println(answerSet.map { if (it >=10) it.toString() else "0$it" }.joinToString(":"))
}
class Boom {
}