package gold

class Tree {
}

fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph = Array(100_001){IntArray(3){-1} }
    var last = 0
    repeat(n){
        val (parent,fir,sec) = br.readLine().split(" ").map { it.toInt() }
        graph[parent][0] = fir
        graph[parent][1] = sec
        if (fir != -1) graph[fir][2] = parent
        if (sec != -1) graph[sec][2] = parent
    }
    var idx = 1
    while(true){
        if (graph[idx][1] == -1) {
            last = idx
            break
        }
        idx = graph[idx][1]
    }
    println(last)
    var cnt = 0
    var answer = 0
    fun dfs(cur:Int){
        if (cur == last) answer = cnt
        //실행
        for (i in graph[cur].indices){
            if (graph[cur][i] == -1) continue
            val temp = graph[cur][i]
            graph[cur][i] = -1
            cnt++
            dfs(temp)
        }
    }
    dfs(1)
    println(answer)
}