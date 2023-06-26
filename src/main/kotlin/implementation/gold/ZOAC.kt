package gold



//fun main(){
//    val br = System.`in`.bufferedReader()
//    val string = br.readLine().map { it.toString() }
//    val word = Array(string.size){""}
//    for (i in string.sorted()) {
//        word[string.indexOf(i)] = i
//        println(word.joinToString(""))
//    }
//}

import java.util.*

fun main() {
    val words = readLine()!!.trim()
    val result = CharArray(words.length)
    fun solution(inputWords: String, startIdx: Int) {
        if (inputWords.isEmpty()) {
            return
        }

        val minChar = inputWords.minOrNull() ?: return
        val minCharIdx = inputWords.indexOf(minChar)

        result[startIdx + minCharIdx] = minChar

        println(result.joinToString(""))

        solution(inputWords.substring(minCharIdx + 1), startIdx + minCharIdx + 1)
        solution(inputWords.substring(0, minCharIdx), startIdx)
    }

    solution(words, 0)
}
