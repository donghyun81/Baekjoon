package brute_force.silver_solution

import java.lang.StringBuilder

class Dna {
}
//5 8
//TATGATAC
//TAAGCTAC
//AAAGATCC
//TGAGATAC
//TAAGATGT

fun main(){
    val br = System.`in`.bufferedReader()
    val (cnt,length) = br.readLine().split(" ").map { it.toInt() }
    val DNAs = mutableListOf<String>()
    val result = StringBuilder()
    var answer = 0
    repeat(cnt){
        DNAs.add(br.readLine())
    }
    var row = 0
    var column = 0
    while(column < length){
        val a = mutableListOf<Char>()
        for (i in 0 until cnt){
            a.add(DNAs[i][column])
        }
        val ab = a.groupingBy { it }.eachCount().entries.sortedBy { it.key }.sortedByDescending { it.value }[0]
        result.append(ab.key)
        answer += cnt-ab.value
        column++
    }
    println(result)
    println(answer)
}