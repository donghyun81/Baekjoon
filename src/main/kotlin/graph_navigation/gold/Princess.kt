package gold

import java.util.*

//import java.util.LinkedList
//
//fun main() {
//    val dx = listOf(1, 0, -1, 0)
//    val dy = listOf(0, 1, 0, -1)
//    val br = System.`in`.bufferedReader()
//    val (yCnt, xCnt, time) = br.readLine().split(" ").map { it.toInt() }
//    val graph = Array(yCnt) { br.readLine().split(" ").map { it.toInt() } }
//    val noGram = Array(yCnt) { IntArray(xCnt) { -1 } }
//    val gram = Array(yCnt) { IntArray(xCnt) { -1 } }
//    val noGramVisited = Array(yCnt) { BooleanArray(xCnt) }
//    val gramVisited = Array(yCnt) { BooleanArray(xCnt) }
//    var gramPos: Pair<Int, Int> = Pair(0, 0)
//
//    fun isFrameIn(ny: Int, nx: Int) = nx >= 0 && ny >= 0 && nx < xCnt && ny < yCnt
//    fun bfs(startPos: Pair<Int, Int>) {
//        val q = LinkedList<Pair<Int, Int>>()
//        q.offer(startPos)
//        noGram[startPos.first][startPos.second] = 0
//        noGramVisited[startPos.first][startPos.second] = true
//        if (graph[startPos.first][startPos.second] == 2) gramPos = startPos
//        while (q.isNotEmpty()) {
//            val (y, x) = q.poll()
//            for (dir in 0..3) {
//                val nx = x + dx[dir]
//                val ny = y + dy[dir]
//                if (!isFrameIn(ny, nx)) continue
//                if (graph[ny][nx] == 1 || noGram[ny][nx] != -1 || noGramVisited[ny][nx]) continue
//                if (graph[ny][nx] == 2) gramPos = Pair(ny, nx)
//                noGram[ny][nx] = noGram[y][x] + 1
//                noGramVisited[ny][nx] = true
//                q.offer(Pair(ny, nx))
//            }
//        }
//    }
//
//    fun gramBfs(gramPos: Pair<Int, Int>) {
//        val q = LinkedList<Pair<Int, Int>>()
//        q.offer(gramPos)
//        gram[gramPos.first][gramPos.second] = 0
//        gramVisited[gramPos.first][gramPos.second] = true
//        while (q.isNotEmpty()) {
//            val (y, x) = q.poll()
//            for (dir in 0..3) {
//                val nx = x + dx[dir]
//                val ny = y + dy[dir]
//                if (!isFrameIn(ny, nx)) continue
//                if (gram[ny][nx] != -1 || gramVisited[ny][nx]) continue
//                gram[ny][nx] = gram[y][x] + 1
//                gramVisited[ny][nx] = true
//                q.offer(Pair(ny, nx))
//            }
//        }
//    }
//    bfs(Pair(0, 0))
//    gramBfs(gramPos)
//    val answer =
//        minOf(noGram[yCnt - 1][xCnt - 1], noGram[gramPos.first][gramPos.second] + gram[yCnt - 1][xCnt - 1])
//    if (answer>time || answer ==-1) println("Fail") else println(answer)
//}

fun main() {
    val castle = Array(110) { IntArray(110) }
    val dist = Array(110) { IntArray(110) }
    var (n, m, t) = readLine()!!.split(' ').map { it.toInt() }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val visited = Array(110) { BooleanArray(110) }
    var sword: Pair<Int, Int> = Pair(0, 0)

    fun bfs() {
        val q = LinkedList<Pair<Int, Int>>()
        q.offer(Pair(1, 1))
        visited[1][1] = true

        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (i in 0..3) {
                val nextY = cur.first + dy[i]
                val nextX = cur.second + dx[i]

                if (nextY <= 0 || nextX <= 0 || nextY > m || nextX > n) continue
                if (visited[nextY][nextX] || castle[nextY][nextX] == 1) continue

                q.offer(Pair(nextY, nextX))
                visited[nextY][nextX] = true
                dist[nextY][nextX] = dist[cur.first][cur.second] + 1
            }
        }
    }

    for (i in 1..n) {
        val input = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
        for (j in 1..m) {
            castle[i][j] = input[j - 1]
            if (castle[i][j] == 2)
                sword = Pair(i, j)
        }
    }

    bfs()

    var useSword = Int.MAX_VALUE
    var notUseSword = Int.MAX_VALUE

// 검을 사용했을 때 걸리는 시간. 구하지 못하는 경우는 int형 최대값
    if (dist[sword.first][sword.second] != 0)
        useSword = dist[sword.first][sword.second] + (n - sword.first) + (m - sword.second)

// 검을 사용하지 않고 걸리는 시간. 구하지 못하는 경우는 int형 최대값
    if (dist[n][m] != 0)
        notUseSword = dist[n][m]

// 둘 중 작은 값을 T보다 작을때만 출력, 그 외는 Fail출력
    val answer = minOf(useSword, notUseSword)
    if (answer > t)
        println("Fail")
    else println(answer)
}
