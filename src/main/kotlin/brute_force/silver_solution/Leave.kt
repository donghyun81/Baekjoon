package brute_force.silver_solution

//import java.util.Scanner
//
//const val MAX = 12
//
//var N = 0
//var Ti = IntArray(MAX) { 0 }
//var Pi = IntArray(MAX) { 0 }
//var res = IntArray(MAX) { 0 }
//
//fun max(a: Int, b: Int): Int = if (a > b) a else b
//
//fun input() {
//    val sc = Scanner(System.`in`)
//    N = sc.nextInt()
//    for (i in 1..N) {
//        Ti[i] = sc.nextInt()
//        Pi[i] = sc.nextInt()
//    }
//}
//
//fun dp() {
//    var deadline: Int
//    for (i in N downTo 1) {
//        deadline = i + Ti[i]
//        if (deadline > N + 1) {
//            // 상담 불가
//            res[i] = res[i + 1]
//        } else {
//            // 상담 가능, 최대 이익 판별 필요
//            res[i] = max(res[i + 1], res[deadline] + Pi[i])
//            if (res[i]!=0) println(i)
//        }
//    }
//}
//
//fun main() {
//    input()
//    dp()
//    println(res.toList())
//    println(res[1])
//}

//7
//3 10
//5 20
//1 10
//1 20
//2 15
//4 40
//2 200
import java.util.*
fun main(){
    val data: Array<Array<String>> = arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
    )
    Solution().solution(data)
}


class Solution {
    fun bfs(p: Array<String>): Int {
        val start = mutableListOf<MutableList<Int>>()

        for (i in 0 until 5) {
            for (j in 0 until 5) {
                if (p[i][j] == 'P') {
                    start.add(mutableListOf(i, j))
                }
            }
        }

        for (s in start) {
            val queue: Queue<List<Int>> = LinkedList(listOf(s)) // 큐에 초기값
            val visited = Array(5) { IntArray(5) } // 방문 처리 리스트
            val distance = Array(5) { IntArray(5) } // 경로 길이 리스트
            visited[s[0]][s[1]] = 1
            while (queue.isNotEmpty()) {
                val (y, x) = queue.poll()
                val dx = listOf(-1, 1, 0, 0) // 좌우
                val dy = listOf(0, 0, -1, 1) // 상하

                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx in 0 until 5 && ny in 0 until 5 && visited[ny][nx] == 0) {
                        if (p[ny][nx] == 'O') {
                            queue.offer(listOf(ny, nx))
                            visited[ny][nx] = 1
                            distance[ny][nx] = distance[y][x] + 1
                        }

                        if (p[ny][nx] == 'P' && distance[y][x] <= 1) {
                            return 0
                        }
                    }
                }
            }
            for (i in distance) println(i.toList())
            println()
        }

        return 1
    }

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = mutableListOf<Int>()
        for (i in places) {
            answer.add(bfs(i))
        }
        return answer.toIntArray()
    }

}




