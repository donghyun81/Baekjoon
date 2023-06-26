package silver

fun main(){
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()
    val words = mutableListOf<String>()
    repeat(cnt){
        words.add(br.readLine())
    }
    var answer = 0
    for (word in words){
        val alphabets = mutableListOf(word.first())
        var pre = 'a'
        for (alpIdx in 1 until word.length){
          pre = word[alpIdx-1]
            if (pre != word[alpIdx]) alphabets.add(word[alpIdx])
        }
        if (alphabets.size == alphabets.distinct().size) answer++
    }
    println(answer)
}
class GroupWord {
}