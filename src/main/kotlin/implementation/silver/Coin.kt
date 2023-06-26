package silver

import java.util.*

fun makeBit(s: String): Int {
    var bit = 0
    for (i in 8 downTo 0) {
        bit = bit shl 1
        if (s[i] == 'H') bit = bit or 1
    }
    return bit
}

fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()
    repeat(T) {
        var coin = ""
        val used = BooleanArray(512) { false }
        var answer = -1

       repeat(3){
           coin += br.readLine().split(" ").joinToString("")
       }

        val bit = makeBit(coin)

        val q: Queue<Int> = LinkedList()
        q.offer(bit)
        used[bit] = true

        var flag = true
        while (q.isNotEmpty() && flag) {
            val qSize = q.size
            answer++
            repeat(qSize) {
                val cur = q.poll()
                if (cur == 0 || cur == (1 shl 9) - 1) {
                    flag = false
                    return@repeat
                }
                val nxts = listOf(7, 56, 448, 73, 146, 292, 273, 84)
                for (nxt in nxts) {
                    val nxtState = cur xor nxt
                    if (used[nxtState]) continue
                    used[nxtState] = true
                    q.offer(nxtState)
                }
            }
        }
        if (flag) answer = -1
        println(answer)
    }
}
