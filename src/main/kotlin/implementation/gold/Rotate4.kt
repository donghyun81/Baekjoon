package gold

import kotlin.math.max

fun main(){
    Rotate4().solution()

}

//5 6 2
//1 2 3 2 5 6
//3 8 7 2 1 3
//8 2 3 1 4 5
//3 4 5 1 1 1
//9 3 2 1 4 3
//3 4 2
//4 2 1
class Rotate4 {
    var row = 0
    var column = 0
    lateinit var graph :Array<IntArray>
    lateinit var totalRotate : Array<IntArray>
    lateinit var visited: BooleanArray
    var answer = Int.MAX_VALUE
    fun solution(){
        val br = System.`in`.bufferedReader()
        val (n,m,rotateCnt) = br.readLine().split(" ").map { it.toInt() }
        row = n
        column = m
        visited = BooleanArray(rotateCnt)
        graph = Array(n) {br.readLine().split(" ").map { it.toInt() }.toIntArray()}
        totalRotate = Array(rotateCnt){br.readLine().split(" ").map { it.toInt() }.toIntArray()}
        dfs(0, listOf(),visited.toTypedArray().toBooleanArray())
        println(answer)
    }
    fun rotate(r:Int,c:Int,s:Int,graph: Array<Array<Int>>){
        val tempGraph = graph.map { it.toIntArray() }.toTypedArray()
        val minR = r-s
        val maxR = r+s
        val minC = c-s
        val maxC = c+s
        println(graph.map { it.toList() }.toList())
        if (minOf(r,c)/2 ==0) return
        for(cnt in 0 .. minOf(r,c)/2){
            for (i in minC+cnt until maxC-cnt){
                graph[minR][i+1] = tempGraph[minR][i]
            }
            for(i in minR+cnt until maxR-cnt){
                graph[i+1][maxC-cnt] = tempGraph[i][maxC-cnt]
            }
            for (i in maxC-cnt downTo minC+cnt+1){
                graph[maxR-cnt][i-1] = tempGraph[maxR-cnt][i]
            }
            for (i in maxR-cnt downTo minR+cnt+1){
                graph[i-1][minC+cnt] = tempGraph[i][minC+cnt]

            }
        }
        println(graph.map { it.toList() }.toList())
        println()

    }
    fun dfs(depth:Int,rotate:List<IntArray>,visited:BooleanArray){
        if (depth == visited.size){
            val tempGraph = graph.map { it.toTypedArray() }.toTypedArray()
            for (i in rotate){
                val (r,c,s) = i
                rotate(r-1,c-1,s,tempGraph)
            }
            var minRowSum = Int.MAX_VALUE
            for (x in 0 until row){
                var tempSum = 0
                for (y in 0 until column){
                    tempSum += tempGraph[x][y]
                }
                minRowSum = minOf(minRowSum,tempSum)
            }
            answer = minOf(answer,minRowSum)
        }
        for (i in totalRotate.indices){
            if (visited[i]) continue
            visited[i] = true
            dfs(depth+1,rotate+totalRotate[i],visited)
            visited[i] = false
        }
    }
}