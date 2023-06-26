package gold

class StringGame {
}

//2
//superaquatornado
//2
//abcdefghijklmnopqrstuvwxyz
//5

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    repeat(br.readLine().toInt()) {
        val alphabetsCnt = Array(26){ mutableListOf<Int>()}
        val word = br.readLine()
        val targetCnt = br.readLine().toInt()
        for (idx in word.indices){
            alphabetsCnt[word[idx]-'a'].add(idx)
        }
        var minLen = 987654321
        var maxLen = -1
       alphabetsCnt.forEach {

           for (i in 0 until it.size-targetCnt+1){

               minLen = minOf(minLen, it[i+targetCnt-1]-it[i]+1)
               maxLen = maxOf(maxLen, it[i+targetCnt-1]-it[i]+1)
               println(minLen)
               println(maxLen)
           }
       }
        if(maxLen == -1) {
            println(-1)
        } else {
            println("$minLen $maxLen")
        }
    }
    bw.flush()
    bw.close()
}


