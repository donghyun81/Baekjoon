package gold

import java.lang.StringBuilder

fun main(){
    Ladder().solution()
}

//10
//5
//ACGBEDJFIH
//*-***-***
//-*-******
//?????????
//-**-***-*
//**-*-*-*-

class Ladder {
    var n = 0
    var m = 0

    fun solution() {
        val br = System.`in`.bufferedReader()
        this.n = br.readLine().toInt()
        this.m = br.readLine().toInt()
        val alphabets = CharArray(n){'A'+it}
        val done = br.readLine().toCharArray()
        val graph = List(m){br.readLine()}
        var markIdx = 0
        for (i in graph.indices) if (graph[i].contains('?')) markIdx=i
        moveLadder(alphabets,graph.subList(0,markIdx+1))
        moveLadder(done,graph.subList(markIdx+1,m).reversed())
        println(makeLadder(alphabets,done))
    }

    fun moveLadder(alphabets:CharArray,ladder:List<String>){
        for (x in ladder.indices){
            for (y in 0 until n-1){
                if (ladder[x][y] == '-'){
                    val temp  = alphabets[y]
                    alphabets[y] = alphabets[y+1]
                    alphabets[y+1] = temp
                }
            }
        }
    }
    fun makeLadder(alphabets: CharArray,doneAlphabets: CharArray):String{
        val ladder = StringBuilder()
        for (i in 0 until n-1){
            if (alphabets[i] != doneAlphabets[i]){
                val temp  = alphabets[i]
                alphabets[i] = alphabets[i+1]
                alphabets[i+1] = temp
                ladder.append("-")
            }else ladder.append("*")
        }

        return if(alphabets.joinToString("") == doneAlphabets.joinToString("")) ladder.toString() else "*".repeat(n-1)
    }

}

