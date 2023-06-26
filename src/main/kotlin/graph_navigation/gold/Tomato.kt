package gold

import java.util.LinkedList

import java.util.*

//
//data class Point(val x: Int, val y: Int)
//
//fun main() {
//    val (m: Int, n: Int) = readLine()!!.split(" ").map(String::toInt)
//    val arr = Array(n) { IntArray(m) }
//    var tot = 0
//    var done = 0
//    for (i in 0 until n) {
//        arr[i] = readLine()!!.split(" ").map(String::toInt).toIntArray()
//        tot += arr[i].count { it >= 0 }
//        done += arr[i].count { it == 1 }
//    }
//    if (tot == done) {
//        println(0)
//        return
//    }
//    val dist = Array(n) { IntArray(m) { -1 } }
//    val queue: Queue<Point> = LinkedList()
//    for (i in 0 until n) {
//        for (j in 0 until m) {
//            if (arr[i][j] == 1) {
//                dist[i][j] = 0
//                queue.offer(Point(i, j))
//            }
//        }
//    }
//    var ans = 0
//    while (queue.isNotEmpty()) {
//        val p = queue.poll()
//        ans = maxOf(ans, dist[p.x][p.y])
//        for ((dx, dy) in listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)) {
//            val nx = p.x + dx
//            val ny = p.y + dy
//            if (!valid(nx, ny, n, m) || arr[nx][ny] == -1 || dist[nx][ny] != -1) {
//                continue
//            }
//            dist[nx][ny] = dist[p.x][p.y] + 1
//            done++
//            queue.offer(Point(nx, ny))
//        }
//    }
//    println(done)
//    println(tot)
//    for(i in dist) println(i.toList())
//    println("----")
//    for(i in dist) println(i.toList())
//    if (tot == done) {
//        println(ans)
//    } else {
//        println(-1)
//    }
//}
//
//fun valid(x: Int, y: Int, n: Int, m: Int) = x in 0 until n && y in 0 until m


//fun main(){
//    val br = System.`in`.bufferedReader()
//    val (colum,row) = br.readLine().split(" ").map { it.toInt() }
//    val graph = Array(row) {br.readLine().split(" ").map { it.toInt() }}
//    var tomato = 0
//    val startIndexes = mutableListOf<Pair<Int,Int>>()
//    var done = 0
//    val dist = Array(row){IntArray(colum){-1}.toMutableList() }
//    val dx = listOf(1,0,-1,0)
//    val dy = listOf(0,1,0,-1)
//
//    fun isFrameIn(nx: Int, ny: Int) = nx >= 0 && ny >= 0 && nx < colum && ny < row
//    for (i in graph.indices){
//        for (j in graph[i].indices){
//            if(graph[i][j]==1) {
//                startIndexes.add(Pair(i,j))
//                dist[i][j] = 0
//                done++
//            }
//            if (graph[i][j]>=0) tomato++
//        }
//    }
//    if (tomato==done) {
//        println(0)
//        return
//    }
//    var answer = 0
//    fun bfs(startIndexes:MutableList<Pair<Int,Int>>){
//        val q = LinkedList<Pair<Int,Int>>()
//        for (i in startIndexes) q.offer(i)
//        while (q.isNotEmpty()){
//            val (y,x) = q.poll()
//            answer = maxOf(answer,dist[y][x])
//            for (direction in 0..3) {
//                val nx = x + dx[direction]
//                val ny = y + dy[direction]
//                if (!isFrameIn(nx, ny)) continue
//                if (dist[ny][nx] != -1 || graph[ny][nx] == -1) continue
//                dist[ny][nx] = dist[y][x]+1
//                q.offer(Pair(ny,nx))
//            }
//        }
//    }
//
//    bfs(startIndexes)
//    for (i in dist) {
//        if (i.contains(-1)) {
//            println(-1)
//            return
//        }
//    }
//    println(answer)
//
//}

//6 4 가로 세로 1 = done 0 = tomato -1 = 빈칸 가로 세로 한칸씩 익는데 모두 익는데 걸리는 시간
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 1

fun main() {
    val br = System.`in`.bufferedReader()
    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(y) { br.readLine().split(" ").map { it.toInt() } }
    val visited = Array(y) { BooleanArray(x) }
    val answerGraph = Array(y) { IntArray(x) }
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    var tomato = 0
    var done = 0
    val q = LinkedList<Pair<Int, Int>>()
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (graph[i][j] >= 0) {
                tomato++
                if (graph[i][j] == 1) {
                    done++
                    q.offer(Pair(i, j))
                    visited[i][j] = true
                }
            }
        }
    }
    if (tomato == done) {
        println(0)
        return
    }
    fun isFrameIn(ny: Int, nx: Int) = nx >= 0 && ny >= 0 && nx < x && ny < y
    var a = 0
    while (q.isNotEmpty()) {
        val (y, x) = q.poll()
        for (dir in 0..3){
            val nx = x + dx[dir]
            val ny = y + dy[dir]
            if (!isFrameIn(ny, nx)) continue
            if (graph[ny][nx] == -1 || visited[ny][nx]) continue
            answerGraph[ny][nx] = answerGraph[y][x]+1
            visited[ny][nx] = true
            done++
            q.offer(Pair(ny,nx))
        }
        a = answerGraph[y][x]
    }
    if(done != tomato) println(-1)
    else println(a)
}