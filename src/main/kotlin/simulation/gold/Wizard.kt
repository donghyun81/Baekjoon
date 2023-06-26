package gold

import kotlin.math.abs
import kotlin.system.measureTimeMillis


//5 4 n,move(이동 횟수)
//0 0 1 0 2 graph
//2 3 2 1 0
//4 3 2 9 0
//1 0 2 9 0
//8 8 2 1 0
//1 3 d,s
//3 4
//8 1
//4 8
//fun main(){
//    val elapsed: Long = measureTimeMillis {
//        Wizard().solution()
//    }
//    println(elapsed)
//}
//
//class Wizard {
//    var frame:Int
//    var move:Int
//    var graph:Array<IntArray>
//    var dx = listOf(0,-1,-1,-1,0,1,1,1)
//    var dy = listOf(-1,-1,0,1,1,1,0,-1)
//    var cloud :MutableList<Pair<Int,Int>>
//    private val br = System.`in`.bufferedReader()
//    init {
//        val (n,m)= br.readLine().split(" ").map { it.toInt() }
//        frame = n
//        move = m
//        graph = Array(n){br.readLine().split(" ").map { it.toInt() }.toIntArray()}
//        cloud = mutableListOf(Pair(n-1, 0),Pair (n-1, 1),Pair (n-2, 0), Pair(n-2, 1))
//    }
//    fun solution(){
//
//        repeat(move){
//            val (dir,s) = br.readLine().split(" ").map { it.toInt() }
//            var tempCloud = mutableListOf<Pair<Int,Int>>()
//            // 구름 이동
//            cloud.forEach { cloudIdx ->
//                val (x, y) = cloudIdx
//                tempCloud.add(cloudMove(dir, s, x, y))
//            }
//            tempCloud.forEach {cloudIdx ->
//                val (x,y) = cloudIdx
//                graph[x][y] +=1
//            }
//            tempCloud.forEach {cloudIdx ->
//                val (x,y) = cloudIdx
//                copyWater(x,y)
//            }
//            cloud.clear()
//            for (x in graph.indices){
//                for (y in graph[x].indices){
//                    if (graph[x][y] >=2 && !tempCloud.contains(Pair(x,y))) {
//                        graph[x][y] -=2
//                        cloud.add(Pair(x,y))
//                    }
//                }
//            }
//        }
//        var answer = 0
//        graph.forEach { answer += it.sum()}
//        println(answer)
//    }
//
//    fun cloudMove(dir:Int,s:Int,x:Int,y:Int):Pair<Int,Int>{
//        val direction = dir-1
//        var nx = (x+dx[direction]*s)%frame
//        var ny = (y+dy[direction]*s)%frame
//        if (nx <0) nx += frame
//        if (ny <0) ny += frame
//
//        return Pair(nx,ny)
//    }
//    fun copyWater(x:Int,y:Int){
//        val dx = listOf(1,1,-1,-1)
//        val dy = listOf(-1,1,1,-1)
//        for (dir in 0..3){
//            val nx = dx[dir]+x
//            val ny = dy[dir]+y
//            if (nx <0 || ny <0 || nx >=frame || ny >=frame) continue
//            if (graph[nx][ny]>0) graph[x][y]++
//        }
//    }
//
//}

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(N) { IntArray(N) }
    val moves = ArrayList<Pair<Int, Int>>()
    val visited = Array(N) { IntArray(N) { 0 } }
    val storm = ArrayList<Pair<Int, Int>>()

    val nx = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)
    val ny = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)

    for (i in 0 until N) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until N) {
            arr[i][j] = input[j]
        }
    }

    for (i in 0 until M) {
        val input = br.readLine().split(" ").map { it.toInt() }
        moves.add(Pair(input[0] - 1, input[1]))
    }

    storm.add(Pair(N - 1, 0))
    storm.add(Pair(N - 1, 1))
    storm.add(Pair(N - 2, 0))
    storm.add(Pair(N - 2, 1))

    for (i in 0 until M) {
        val (d, s) = moves[i]
        val newStorm = ArrayList<Pair<Int, Int>>()
        for (j in storm.indices) {
            var dx = storm[j].first + nx[d] * s
            var dy = storm[j].second + ny[d] * s
            if (dx < 0) {
                while (true) {
                    val newDx = dx + N
                    if (newDx >= N) break
                    dx += N
                }
            } else if (dx >= N) {
                while (true) {
                    val newDx = dx - N
                    if (newDx < 0) break
                    dx -= N
                }
            }
            if (dy < 0) {
                while (true) {
                    val newDy = dy + N
                    if (newDy >= N) break
                    dy += N
                }
            } else if (dy >= N) {
                while (true) {
                    val newDy = dy - N
                    if (newDy < 0) break
                    dy -= N
                }
            }
            newStorm.add(Pair(dx, dy))
            visited[dx][dy] = 1
        }

        for (j in newStorm.indices) {
            arr[newStorm[j].first][newStorm[j].second] += 1
        }

        val save = ArrayList<Int>()
        for (j in newStorm.indices) {
            var ct = 0
            for (z in 1 until 8 step 2) {
                val dx = newStorm[j].first + nx[z]
                val dy = newStorm[j].second + ny[z]
                if (dx < 0 || dx >= N) continue
                if (dy < 0 || dy >= N) continue
                if (arr[dx][dy] > 0) {
                    ct += 1
                }
                save.add(ct)
            }
        }
            for (j in newStorm.indices) {
                    arr[newStorm[j].first][newStorm[j].second] += save[j]
                }
            }

                storm.clear()
                for (x in 0 until N) {
                    for (y in 0 until N) {
                        if (visited[x][y] == 0 && arr[x][y] >= 2) {
                            arr[x][y] -= 2
                            storm.add(Pair(x, y))
                        }
                    }
                }

            var total = 0
            for (i in 0 until N) {
                for (j in 0 until N) {
                    if (arr[i][j] > 0) {
                        total += arr[i][j]
                    }
                }
            }
            println(total)
        }


