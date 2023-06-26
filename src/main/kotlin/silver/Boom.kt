package silver

import java.util.LinkedList

//5
//3 2 1 -3 -1
fun main(){
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()
    var q = LinkedList<Pair<Int,Int>>()
    val nums = br.readLine().split(" ").forEachIndexed{idx,value -> q.offer(idx+1 to value.toInt())}
    var curIndex = 0
    while (true){
        val (curIdx,value) = q.removeAt(curIndex)
//        print("$curIdx ")
        if (q.isEmpty()) break
        println(curIndex + value -1)
        curIndex = if (value > 0){
            (curIndex + value -1).mod(q.size)
        }else{
            (curIndex + value).mod(q.size)
        }
    }

}