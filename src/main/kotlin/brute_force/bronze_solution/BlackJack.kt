package brute_force.bronze_solution

//5 21
//5 6 7 8 9
fun main() {
    val br = System.`in`.bufferedReader()
    val (cardCount, targetNumber) = br.readLine().split(" ").map { it.toInt() }
    val cards = br.readLine().split(" ").map { it.toInt() }.sortedDescending()
    var result = 0
    var sum = 0
    for (i in 0 until cards.size - 2){
        for (j in i + 1 until cards.size-1) {
            for (k in j + 1 until cards.size) {
                sum = cards[i] + cards[j] + cards[k]
                if (sum <= targetNumber){
                    result = maxOf(sum,result)
                }
            }
        }
    }

    println(result)
}