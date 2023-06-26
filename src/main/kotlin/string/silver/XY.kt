package silver

fun main(){
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()
    val regex = "\\b[A-F]?A+F+C+[A-F]?\\b".toRegex()
    repeat(cnt){
        val word = br.readLine()
        if(regex.matches(word)) println("Infected!")
        else println("Good")
    }
}