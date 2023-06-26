package gold

//7 8 1
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
fun main(){
    val br = System.`in`.bufferedReader()
    val (r,c,t) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(r){br.readLine().split(" ").map { it.toInt() }.toIntArray()}
    FineDust().solution(r,c,t,graph)
}
class FineDust {
    var r = 0
    var c = 0
    var t = 0
    var highWind = -1
    var lowWind = -1
    lateinit var graph: Array<IntArray>
    fun solution(r: Int, c: Int, t: Int, graph: Array<IntArray>) {
        this.r = r
        this.c = c
        this.t = t
        this.graph = graph
        repeat(t){
            spreadDust()
            wind()
        }
        var answer = 2

        for (i in this.graph) {
            answer += i.sum()
        }
        println(answer)
    }


    fun spreadDust() {
        val dx = listOf(1, 0, -1, 0)
        val dy = listOf(0, 1, 0, -1)
        val tempGraph = Array(r) { IntArray(c) }
        for (x in 0 until r) {
            for (y in 0 until c) {
                if (graph[x][y] > 0) {
                    var cnt = 0
                    for (dir in 0..3) {
                        val nx = x +dx[dir]
                        val ny = y + dy[dir]
                        if (nx <0 || ny <0 || nx >=r || ny >=c) continue
                        if (graph[nx][ny] == -1) continue
                        tempGraph[nx][ny] += graph[x][y]/5
                        cnt ++
                    }
                    tempGraph[x][y] += graph[x][y]-(graph[x][y]/5 * cnt)
                }
                if (graph[x][y] == -1) {
                    tempGraph[x][y] = -1
                    if (highWind == -1){
                        highWind = x
                    } else{
                       lowWind = x
                    }
                }
            }
        }
        graph = tempGraph
    }

    fun wind(){
        val tempGraph = graph.map { it.toTypedArray() }.toTypedArray()
        tempGraph[highWind][1] = 0
        tempGraph[lowWind][1] = 0
        for (i in 1 until c-1){
            tempGraph[highWind][i+1] = graph[highWind][i]
            tempGraph[lowWind][i+1] = graph[lowWind][i]
        }
        for (i in highWind downTo  1){
            tempGraph[i-1][c-1] = graph[i][c-1]
        }
        for (i in lowWind until r-1){
            tempGraph[i+1][c-1] = graph[i][c-1]
        }
        for (i in c-1 downTo 1){
            tempGraph[0][i-1] = graph[0][i]
            tempGraph[r-1][i-1] = graph[r-1][i]
        }
        for (i in 0..highWind){
            if (graph[i+1][0] == -1) continue
            tempGraph[i+1][0] = graph[i][0]
        }
        for (i in r-1 downTo lowWind){
            if (graph[i-1][0] == -1) continue
            tempGraph[i-1][0] = graph[i][0]
        }
        graph = tempGraph.map { it.toIntArray() }.toTypedArray()
    }

}