package silver

import java.util.*

//fun main() {
//    val br = System.`in`.bufferedReader()
//    val (row, colum) = br.readLine().split(" ").map { it.toInt() }
//    val graph = Array(row) { br.readLine().map { it.digitToInt() } }
//    val dist = Array(row) { Array(colum) { -1 } }
//
//    fun valid(nx:Int,ny:Int) = nx>=0&&ny>=0&&nx<colum&&ny<row
//
//    fun bfs(x:Int,y:Int){
//        val dx = listOf(1,0,-1,0)
//        val dy = listOf(0,1,0,-1)
//        val q = LinkedList<Pair<Int,Int>>()
//        q.offer(Pair(0,0))
//        dist[0][0] = 1
//        while (q.isNotEmpty()){
//            val (x,y) = q.poll()
//            for(i in 0..3){
//                val nx = x+dx[i]
//                val ny = y+dy[i]
//                if (!(valid(nx,ny))) continue
//                if (graph[ny][nx]==0) continue
//                if (dist[ny][nx] != -1) continue
//                dist[ny][nx] = dist[y][x]+1
//                q.offer(Pair(nx,ny))
//            }
//        }
//    }
//    bfs(0,0)
//    println(dist[row-1][colum-1])
//
//}


//4 6 가로 세로 1로 탈출
//101111
//101010
//101011
//111011
fun main() {
    val br = System.`in`.bufferedReader()
    val (y, x) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(y) { br.readLine().map { it.digitToInt() } }
    val visited = Array(y) { BooleanArray(x) }
    val dist = Array(y) { IntArray(x) }
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, -1, 0, 1)
    fun isFrameIn(ny: Int, nx: Int) = ny >= 0 && nx >= 0 && ny < y && nx < x
    fun bfs(y: Int, x: Int) {
        val q = LinkedList<Pair<Int, Int>>()
        q.offer(Pair(y, x))
        visited[y][x] = true
        while (q.isNotEmpty()) {
            val (y, x) = q.poll()
            for (dir in 0..3) {
                val ny = y + dy[dir]
                val nx = x + dx[dir]
                if (!isFrameIn(ny, nx)) continue
                if (visited[ny][nx] || graph[ny][nx] == 0) continue
                visited[ny][nx] = true
                dist[ny][nx] = dist[y][x] + 1
                q.offer(Pair(ny,nx))
            }
        }
    }
    bfs(0,0)
    println(dist[y-1][x-1]+1)
}