package bronze

fun main() {
    val br = System.`in`.bufferedReader()
    val studentNumbers = List<Int>(28) {br.readLine().toInt()}
    val notJoin = (1..30).filter { !studentNumbers.contains(it) }
    println(notJoin)
}