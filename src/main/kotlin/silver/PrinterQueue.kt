package silver

import java.util.LinkedList

//3
//1 0
//5
//4 2
//1 2 3 4
//6 0
//1 1 9 1 1 1
fun main(){
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()
    repeat(cnt){
        val (nCnt,target) = br.readLine().split(" ").map { it.toInt() }
        val nums = br.readLine().split(" ").map { it.toInt() }.toMutableList()
        val printer = LinkedList<Pair<Int,Int>>()
        val answers = mutableListOf<Int>()
        for (i in nums.indices) printer.add(i to nums[i])
        var cnt = 0
        var a = true
        while (printer.isNotEmpty()){
            if (printer.first.second== printer.maxOf { it.second }){
                cnt++
                if(printer.poll().first ==target) break
            }else printer.offer(printer.poll())
        }
        println(cnt)
    }
}