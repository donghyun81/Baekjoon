package silver

import java.util.LinkedList


//7
//0110100
//0110101
//1110101
//0000111
//0100000
//0111110
//0111000
fun main() {
    val br = System.`in`.bufferedReader()
    val frame = br.readLine().toInt()
    val graph = Array(frame) { br.readLine().map { it.digitToInt() } }
    val vis = Array(frame) { BooleanArray(frame) }

    val answer = mutableListOf<Int>()
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    fun isFrameOut(nx: Int, ny: Int) = nx >= 0 && ny >= 0 && nx < frame && ny < frame

    fun bfs(x: Int, y: Int):Int {
        val q = LinkedList<Pair<Int,Int>>()
        vis[y][x] = true
        q.offer(Pair(x,y))
        var homeCount = 0
        while (q.isNotEmpty()) {
            val (x, y) = q.poll()
            homeCount++
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (!isFrameOut(nx, ny)) continue
                if (graph[ny][nx] == 0) continue
                if (vis[ny][nx]) continue
                vis[ny][nx] = true
                q.offer(Pair(nx, ny))
            }
        }
        return homeCount
    }

    for(i in 0 until frame){
        for(j in 0 until frame){
            if (vis[i][j]) continue
            if (graph[i][j] == 0) continue
            answer.add(bfs(j,i))
        }
    }
    println(answer.count())
    for (i in answer.sorted()) println(i)

}

//7 7*7 1일 경우에 단지 시작 각 개수 구하고 개수들을 오름차순으로 추력
//0110100
//0110101
//1110101
//0000111
//0100000
//0111110
//0111000
//fun main() {
//    val br = System.`in`.bufferedReader()
//    val frame = br.readLine().toInt()
//    val graph = Array(frame) { br.readLine().map { it.digitToInt() } }
//    val dx = listOf(1,0,-1,0)
//    val dy = listOf(0,1,0,-1)
//    var count = 1
//    val answer = mutableSetOf<Int>()
//    fun isFrameIn(ny: Int, nx: Int) = ny >= 0 && nx >= 0 && ny < frame && nx < frame
//    fun bfs(y: Int, x: Int,visited:Array<BooleanArray>) {
//        val q = LinkedList<Pair<Int, Int>>()
//        q.offer(Pair(y,x))
//        visited[y][x] = true
//        if (graph[y][x] == 0) return
//        count = 1
//        while(q.isNotEmpty()){
//            val (y,x) = q.poll()
//            for (dir in 0..3){
//                val ny = y + dy[dir]
//                val nx = x + dx[dir]
//                if (!isFrameIn(ny,nx)) continue
//                if (graph[ny][nx] == 0 || visited[ny][nx]) continue
//                visited[ny][nx] = true
//                q.offer(Pair(ny,nx))
//                count++
//            }
//        }
//        if (count>=1) answer.add(count)
//    }
//    for (i in 0 until frame){
//        for (j in 0 until frame){
//            val visited = Array(frame) {BooleanArray(frame)}
//            bfs(i,j,visited)
//        }
//    }
//    println(answer.count())
//    for (i in answer.sorted()) println(i)
//}