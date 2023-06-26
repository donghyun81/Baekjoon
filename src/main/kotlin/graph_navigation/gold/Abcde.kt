package gold

import kotlin.system.exitProcess

fun main() {
    val br = System.`in`.bufferedReader()
    val (humanNum, relationCnt) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(humanNum + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(humanNum + 1)
    repeat(relationCnt) {
        val (f, s) = br.readLine().split(" ").map { it.toInt() }
        graph[f].add(s)
        graph[s].add(f)
    }
    var a = false
    fun dfs(cur: Int, depth: Int){
        visited[cur] = true
        //정지 조건
        if (depth == 4) {
            a=true
        }
        //실행
        for (i in graph[cur])
            if (!visited[i]) dfs(i, depth + 1)
        visited[cur] = false
    }
    for (i in 0 until humanNum) dfs(i,0)
    if (a) println(1) else println(0)
}