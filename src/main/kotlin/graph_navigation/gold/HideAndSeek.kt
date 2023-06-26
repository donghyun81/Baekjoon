package gold

import java.util.LinkedList

//5 17
import java.util.*

//dp에서 본 최단거리 숫자계산이 사용된 문제
const val MAX = 20

//fun main() {
//    val dist = IntArray(21) { -1 }
//    val input = readLine()!!.split(" ").map(String::toInt)
//    val N = input[0]
//    val K = input[1]
//
//    val q = LinkedList<Int>()
//    dist[N] = 0
//    q.offer(N)
//
//    while (q.isNotEmpty()) {
//        val cur = q.poll()
//        println(cur)
//        println(q)
//        var pw = cur * 2
//        while (pw in 0..MAX) {
//            if (dist[pw] == -1) {
//                dist[pw] = dist[cur]
//                q.offer(pw)
//            } else break
//            pw *= 2
//        }
//        if (cur > 0 && dist[cur - 1] == -1) {
//            dist[cur - 1] = dist[cur] + 1
//            q.offer(cur - 1)
//        }
//        if (cur < MAX && dist[cur + 1] == -1) {
//            dist[cur + 1] = dist[cur] + 1
//            q.offer(cur + 1)
//        }
//    }
//    println(dist[K])
//}

// 5 17
fun main() {
    val br = System.`in`.bufferedReader()
    val (s, l) = br.readLine().split(" ").map { it.toInt() }
    val graph = IntArray(20) { -1 }

    val q = LinkedList<Int>()
    q.offer(s)
    graph[s] = 0
    while (q.isNotEmpty()) {
        val cur = q.poll()
        var pw = cur * 2
        while (pw in 0..l) {
            if (graph[pw] == -1) {
                graph[pw] = graph[cur]
                q.offer(pw)
            } else break
            pw *= 2
        }
        if (cur > 0 && graph[cur - 1] == -1) {
            graph[cur - 1] = graph[cur] + 1
            q.offer(cur - 1)
        }
        if (cur < l && graph[cur + 1] == -1) {
            graph[cur + 1] = graph[cur] + 1
            q.offer(cur + 1)
        }
    }
    println(graph.toList())
    println(graph[l])
}