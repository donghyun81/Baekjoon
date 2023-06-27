package data_structure.silver

import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val cnt =br.readLine().toInt()
    val expression = br.readLine()
    val nums = DoubleArray(cnt){br.readLine().toDouble()}
    val s = Stack<Double>()
    var answer = 0.0
    for (i in expression){
        if (i !in ('A'..'Z')){
            val scd = s.pop()
            val fst = s.pop()
            var result =  when(i){
                    '+' -> fst+scd
                    '-' -> fst-scd
                    '*' -> fst*scd
                    else -> fst/scd
            }
            answer = result
            s.push(result)
        }else{
            s.push(nums[i-'A'])
        }
    }
    println("%.2f".format(answer))

}

