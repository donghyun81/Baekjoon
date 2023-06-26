package bronze

import java.util.LinkedList

fun main(){
    val br = System.`in`.bufferedReader()
    fun convert(target:Char):Int{
        val alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val nums = "32123333113133122212112221"
        return nums[alphabets.indexOf(target)].digitToInt()
    }

    val word = br.readLine().map { convert(it) }

    val q = LinkedList<Int>()
    var cnt = 2
    for (i in word.chunked(2)){
       q.offer(i.sum()%10)
    }
    while(q.size!=1){
        q.offer((q.poll()+q.poll())%10)
    }
    if (q.poll()%2 == 0 ) println("You're the winner?") else println("I'm a winner!")
}