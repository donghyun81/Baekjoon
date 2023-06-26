package brute_force.gold


//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.StringTokenizer
//
//fun main(args: Array<String>) {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    var st = StringTokenizer(br.readLine())
//
//    val n = Integer.parseInt(st.nextToken())
//    val m = Integer.parseInt(st.nextToken())
//    val arr = Array(n) { IntArray(m) }
//    val visit = Array(n) { BooleanArray(m) }
//
//    // 입력
//    for (i in 0 until n) {
//        st = StringTokenizer(br.readLine())
//        for (j in 0 until m) {
//            arr[i][j] = Integer.parseInt(st.nextToken())
//        }
//    }
//
//    var max = 0
//    fun solve(row: Int, col: Int, sum: Int, count: Int, arr: Array<IntArray>, visit: Array<BooleanArray>, n: Int, m: Int) {
//        // 테트로미노 완성 시 수들의 합 계산
//        if (count == 4) {
//            max = Math.max(max, sum)
//            return
//        }
//
//        // 상하좌우 탐색
//        val dx = intArrayOf(-1, 1, 0, 0)
//        val dy = intArrayOf(0, 0, -1, 1)
//        for (i in 0 until 4) {
//            val curRow = row + dx[i]
//            val curCol = col + dy[i]
//            // 범위 벗어나면 예외 처리
//            if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
//                continue
//            }
//            // 아직 방문하지 않은 곳이라면
//            if (!visit[curRow][curCol]) {
//
//                // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
//                if (count == 2) {
//                    visit[curRow][curCol] = true
//                    solve(row, col, sum + arr[curRow][curCol], count + 1, arr, visit, n, m)
//                    visit[curRow][curCol] = false
//                }
//
//                visit[curRow][curCol] = true
//                solve(curRow, curCol, sum + arr[curRow][curCol], count + 1, arr, visit, n, m)
//                visit[curRow][curCol] = false
//            }
//        }
//    }
//
//    // 전체 탐색 (dfs)
//    for (i in 0 until n) {
//        for (j in 0 until m) {
//            visit[i][j] = true
//            solve(i, j, arr[i][j], 1, arr, visit, n, m)
//            visit[i][j] = false
//        }
//    }
//
//    println(max)
//}
//5 5
//1 2 3 4 5
//5 4 3 2 1
//2 3 4 5 6
//6 5 4 3 2
//1 2 1 2 1
fun main() {
    Tacromino().solution()

}

class Tacromino {
    var n = 0
    var m = 0
    lateinit var graph: Array<IntArray>
    lateinit var visited:Array<BooleanArray>
    var answer = 0
    fun solution() {
        val br = System.`in`.bufferedReader()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        this.n = n
        this.m = m
        graph = Array(n){ br.readLine().split(" ").map { it.toInt() }.toIntArray()}
        visited = Array(n){ BooleanArray(m) }
        for (x in graph.indices){
            for (y in graph[x].indices) dfs(x,y,0,0)
        }
        println(answer)
    }

    fun dfs(x:Int,y:Int,cnt:Int,sum:Int){
        if(cnt == 4){
            answer = maxOf(answer,sum)
            return
        }
        val dx = intArrayOf(1,0,-1,0)
        val dy = intArrayOf(0,1,0,-1)
        for (i in 0 until 4){
            val nx = x+dx[i]
            val ny = y+dy[i]
            if (nx<0 || ny <0|| nx>=n||ny>=m) continue

            if(!visited[nx][ny]){
                if(cnt==2){
                    visited[nx][ny] = true
                    dfs(x,y,cnt+1,sum+graph[nx][ny])
                    visited[nx][ny] = false
                }
                visited[nx][ny] = true
                dfs(nx,ny,cnt+1,sum+graph[nx][ny])
                visited[nx][ny] = false
            }
        }
    }
}


