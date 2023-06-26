package silver

class Hacking {
}

//fun main(){
//    val br = System.`in`.bufferedReader()
//    val (maxComputerNumber,combinationCnt) = br.readLine().split(" ").map { it.toInt() }
//    val graph = Array(maxComputerNumber+1){ mutableListOf<Int>()}
//    val visited = BooleanArray(maxComputerNumber+1)
//    val answer = IntArray(maxComputerNumber+1)
//    var count = 0
//    repeat(combinationCnt){
//        val (fstNum,scdNum) = br.readLine().split(" ").map { it.toInt() }
////        graph[fstNum].add(scdNum)
//        graph[scdNum].add(fstNum)
//    }
//    fun dfs(cur:Int){
//        visited[cur] = true
//        count++
//        for (i in graph[cur]){
//            if (!visited[i]) dfs(i)
//        }
//    }
//    for (i in 1..maxComputerNumber){
//        visited.fill(false)
//        count = 0
//        dfs(i)
//        answer[i] = count
//    }
//    println(answer.toList())
//    br.close()
//
//}

//5 4 num cnt
//3 1
//3 2
//4 3
//5 3
//fun main(){
//    val br = System.`in`.bufferedReader()
//    val (num,cnt) = br.readLine().split(" ").map { it.toInt() }
//    val graph = Array(num+1){ mutableListOf<Int>()}
//    val answer =IntArray(num+1)
//    repeat(cnt){
//        val (fNum,sNum) = br.readLine().split(" ").map { it.toInt() }
//        graph[sNum].add(fNum)
//    }
//    var max = 0
//    fun dfs(cur:Int,visited: BooleanArray){
//        visited[cur] = true
//        max++
//        for (i in graph[cur]){
//            if (!visited[i]) dfs(i,visited)
//        }
//    }
//    for(i in 1..num){
//        val visited = BooleanArray(num+1)
//        visited.fill(false)
//        max = 0
//        dfs(i,visited)
//        answer[i] = max
//    }
//    for (i in answer.indices.filter { answer[it] == answer.max() }) print("$i ")
//}
//

fun main() {
    val br = System.`in`.bufferedReader()
    val (num,cnt) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(num+1){ mutableListOf<Int>()}
    val answer =IntArray(num+1)
    repeat(cnt){
        val (fNum,sNum) = br.readLine().split(" ").map { it.toInt() }
        graph[sNum].add(fNum)
    }
    var maxCnt = -1
    val ans = mutableListOf<Int>()
    for (i in 1..num) {
        val vis = BooleanArray(num + 1)
        var compCnt = 0
        fun dfs(cur: Int) {
            vis[cur] = true
            ++compCnt
            for (nxt in graph[cur]) {
                if (!vis[nxt]) dfs(nxt)
            }
        }
        dfs(i)
        if (maxCnt < compCnt) {
            maxCnt = compCnt
            ans.clear()
            ans.add(i)
        } else if (maxCnt == compCnt) ans.add(i)
    }
    println(ans.joinToString(" "))
}
