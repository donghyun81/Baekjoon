package data_structure.silver

import java.util.*


//fun main(){
//    val br = System.`in`.bufferedReader()
//    val cnt = br.readLine().toInt()
//    var nums = LinkedList<Int>()
//    repeat(cnt){nums.offer(it+1)}
//    while (nums.size!=1){
//        nums.poll()
//        nums.offer(nums.poll())
//    }
//    println(nums.poll())
//}

import java.io.*
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val nums = mutableListOf<Int>()
    val sb = StringBuilder()
    val stack = Stack<Int>()
    var cur = 1
    repeat(n){
        nums.add(br.readLine().toInt())
    }
    for (i in nums){
        while(cur<=i){
            stack.push(cur)
            sb.append("+\n")
            cur++
        }
        if (i==stack.peek()){
            stack.pop()
            sb.append("-\n")
        }else{
            println("NO")
            return
        }
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}