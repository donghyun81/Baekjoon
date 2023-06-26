package silver

import java.util.LinkedList

class ShortDistance {
}

//세로 가로
//15 15
//2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
//1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
//1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
fun main() {
    val br = System.`in`.bufferedReader()
    val (y, x) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(y) { br.readLine().split(" ").map { it.toInt() } }
    val vis = Array(y) { IntArray(x){0} }
    val viss = Array(y) { BooleanArray(x) }
    var startIndex = Pair(0, 0)
    for (i in board.indices) if (board[i].indexOf(2) != -1) {
        startIndex = Pair(i, board[i].indexOf(2))
        break
    }
    fun isFrameIn(nx: Int, ny: Int) = nx >= 0 && ny >= 0 && nx < x && ny < y
    fun bfs(x: Int, y: Int) {
        val dx = listOf(1, 0, -1, 0)
        val dy = listOf(0, 1, 0, -1)
        val q = LinkedList<Pair<Int, Int>>()
        q.offer(Pair(x, y))
        vis[y][x] = 0
        viss[y][x] =true
        while (q.isNotEmpty()) {
            val (x,y) = q.poll()
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (!isFrameIn(nx, ny)) continue
                if (board[ny][nx] == 0) continue
                if (viss[ny][nx]) continue
                vis[ny][nx] = vis[y][x]+1
                viss[ny][nx] = true
                q.offer(Pair(nx,ny))
            }
        }
    }
    bfs(startIndex.second,startIndex.first)
    for (i in vis.indices) {
        for(j in vis[i].indices){
            if(board[i][j]==1 && vis[i][j] == 0 ) print("0 ")
            else  print("${vis[i][j]} ")
        }
        println()
    }
}