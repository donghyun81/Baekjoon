package silver

import java.util.LinkedList

class DfsAndBfs {
}

//4 5 1 정점 개수 간선 개수 탐색 시작지점 (1~4),조합개수,탐색지점 1
//1 2
//1 3
//1 4
//2 4
//3 4

// dfs 조회순서
// bfs 조회순서
//fun main() {
//    val br = System.`in`.bufferedReader()
//    val (cnt, cbnCnt, targetNum) = br.readLine().split(" ").map { it.toInt() }
//    val graph = Array(cnt + 1) { mutableListOf<Int>() }
//
//    repeat(cbnCnt) {
//        val (firstNum, secondNum) = br.readLine().split(" ").map { it.toInt() }
//        graph[firstNum].add(secondNum)
//    }
//    val dfsNumbers = mutableListOf<Int>()
//    val visited = BooleanArray(cnt+1)
//    val bfsNumbers = mutableListOf<Int>()
//    fun dfs(targetNum: Int) {
//        //실행 조건
//        //탈출 조건
//        visited[targetNum] = true
//        dfsNumbers.add(targetNum)
//        for(i in graph[targetNum]){
//            if (!visited[i]) dfs(i)
//        }
//    }
//    fun bfs(src:Int){
//        val q = LinkedList<Int>()
//        q.offer(src)
//        visited[src] = true
//        while (q.isNotEmpty()){
//            val n = q.poll()
//            bfsNumbers.add(n)
//            for (i in graph[n]){
//                if (!visited[i]) {
//                    q.offer(i)
//                    visited[i] = true
//                }
//            }
//        }
//    }
//}

//4 5 1 1~4, 조합 5 시작번호
//1 2
//1 3
//1 4
//2 4
//3 4

fun main(){
    val br = System.`in`.bufferedReader()
    val (maxNum,cbnCnt,targetNum) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(maxNum+1){ mutableListOf<Int>()}
    val visited = BooleanArray(maxNum+1)
    val dfsAnswer = mutableListOf<Int>()
    val bfsAnswer = mutableListOf<Int>()
    repeat(cbnCnt){
        val (fNum,sNum) = br.readLine().split(" ").map { it.toInt() }
        graph[fNum].add(sNum)
        graph[sNum].add(fNum)
    }
    fun dfs(cur:Int){
        visited[cur] = true
        dfsAnswer.add(cur)
        for (i in graph[cur].sorted()){
            if (!visited[i]) {
                dfs(i)
            }
        }
    }
    fun bfs(cur:Int){
        val q = LinkedList<Int>()
        q.offer(cur)
        bfsAnswer.add(cur)
        visited[cur] = true
        while (q.isNotEmpty()){
            val num = q.poll()
            for (i in graph[num].sorted()){
                if (!visited[i]) {
                    visited[i] = true
                    bfsAnswer.add(i)
                    q.offer(i)
                }
            }
        }
    }
    dfs(targetNum)
    visited.fill(false)
    bfs(targetNum)
    println(dfsAnswer)
    println(bfsAnswer)
}