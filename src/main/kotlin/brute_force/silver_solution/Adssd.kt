package brute_force.silver_solution

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(" ").map{it.toInt()}
    val graph = Array(n) { IntArray(m) } // 얼음 틀을 그래프로 표현
    for (i in 0 until n) {
        val row = br.readLine()
        for (j in row.indices) {
            graph[i][j] = row[j].digitToInt()
        }
    }

    // DFS 함수 정의
    fun dfs(x: Int, y: Int) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return
        }
        if (graph[x][y] == 0) {
            graph[x][y] = 2 // 방문 처리
            dfs(x + 1, y)
            dfs(x - 1, y)
            dfs(x, y + 1)
            dfs(x, y - 1)
        }
    }

    // DFS 실행 및 아이스크림 개수 세기
    var count = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 0) { // 구멍이라면
                dfs(i, j) // DFS 실행
                println(graph.toList().map { it.toList() })
                count++ // 아이스크림 개수 증가
            }
        }
    }

    println(count) // 결과 출력
}

//fun main() {
//    val (n, m) = readLine()!!.split(' ').map(String::toInt)
//    val graph = Array(n) { IntArray(m) }
//    for (i in 0 until n) {
//        val row = readLine()!!
//        for (j in 0 until m) {
//            graph[i][j] = row[j] - '0'
//        }
//    }
//    val result = solveMaze(n, m, graph)
//    println(result)
//}

//fun solveMaze(n: Int, m: Int, graph: Array<IntArray>): Int {
//    val dist = Array(n) { IntArray(m) { -1 } } // 이동 거리 확인
//    val dx = intArrayOf(-1, 1, 0, 0) // 위치 이동값 앙옆
//    val dy = intArrayOf(0, 0, -1, 1) // 위치 이동값 위 아래
//    val queue: Queue<Pair<Int, Int>> = LinkedList() // 이동 할 수 있는 경로 탐색
//    queue.offer(Pair(0, 0)) // 첫 경로 설정
//    dist[0][0] = 0 // 첫 이동 경로는 0 경로가 증가하며 이동한 만큼 거리 계산 가능
//    while (!queue.isEmpty()) {
//        val (x, y) = queue.poll() // 첫 0,0
//        for (i in 0 until 4) { // 첫 0,0에서 1,0 0,1 이동 가능
//            val nx = x + dx[i]
//            val ny = y + dy[i]
//            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue //-1,0으로는 이동이 불가능
//            if (graph[nx][ny] == 0) continue // 값이  0인 경우 이동이 불가능한 지역
//            if (dist[nx][ny] != -1) continue // -1이 아닐 경우에 이미 이동한 경로라 이동 불가
//            dist[nx][ny] = dist[x][y] + 1 // 위치값이 이동할 시에 원래 이동값에 +1
//            println(dist[nx][ny])
////            println(dist.toList().map{it.toList()})
//            println("$nx  $ny")
////            println(graph.toList().map { it.toList() })
//            queue.offer(Pair(nx, ny)) // 이동한 곳이
//            println(queue)
//        }
//    }
//    return dist[n - 1][m - 1] + 1
//}
