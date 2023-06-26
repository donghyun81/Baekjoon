package silver


//fun main() {
//    val input = System.`in`.bufferedReader()
//    val n = input.readLine().toInt()
//    val graph = Array(10001){ mutableListOf<Int>()}
//    val answer = IntArray(10001)
//    for (i in 1 until n) {
//        val (u,v) = input.readLine().split(" ").map { it.toInt() }
//        graph[u].add(v)
//        graph[v].add(u)
//    }
//    fun dfs(cur:Int){
//        for(nxt in graph[cur]){
//            if(nxt == answer[cur]) continue
//            answer[nxt] = cur
//            dfs(nxt)
//        }
//    }
//    dfs(1)
//    println(answer.toList())
//}

//7
//1 6
//6 3
//3 5
//4 1
//2 4
//4 7
fun main() {
    val br = System.`in`.bufferedReader()
    val maxNum = br.readLine().toInt()
    val graph = Array(maxNum + 1) { mutableListOf<Int>() }
    val answer = IntArray(maxNum+1)
    repeat(maxNum - 1) {
        val (fNum, sNum) = br.readLine().split(" ").map { it.toInt() }
        graph[fNum].add(sNum)
        graph[sNum].add(fNum)
    }
    fun dfs(cur:Int){
        for (i in graph[cur]){
            if(i == answer[cur]) continue
            answer[i] = cur
            dfs(i)
        }
    }
    dfs(1)
    println(answer.toList())

}