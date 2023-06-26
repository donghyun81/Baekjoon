package silver




fun main(){
    val br = System.`in`.bufferedReader()
    val cptCnt = br.readLine().toInt()
    val cbnCnt = br.readLine().toInt()
    val graph = Array(cptCnt+1){ mutableListOf<Int>()}
    val visited = BooleanArray(cptCnt+1)
    var answer = 0
    repeat(cbnCnt){
        val (fNum,sNum) = br.readLine().split(" ").map { it.toInt() }
        graph[fNum].add(sNum)
        graph[sNum].add(fNum)
    }
    fun dfs(cur:Int){
        visited[cur] = true
        for(i in graph[cur]){
            if (!visited[i]) {
                visited[i] = true
                answer++
                dfs(i)
            }
        }
    }
    dfs(1)
    println(answer)
}