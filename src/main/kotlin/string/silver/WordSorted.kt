package silver

class WordSorted {
}

fun main(){
    val br = System.`in`.bufferedReader()
    val words = mutableListOf<String>()
    repeat(br.readLine().toInt()) {
        words.add(br.readLine())
    }
    val answer = words.sortedWith(compareBy({it.length},{it})).distinct()
    answer.forEach{
        println(it)
    }
}