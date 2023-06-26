package brute_force.silver_solution

import kotlin.math.abs


fun main(){
    LinkAndStart().solution()

}

//4
//0 1 2 3
//4 0 5 6
//7 1 0 2
//3 4 5 0
class LinkAndStart {
    var n = 0
    var aScore = 0
    var bScore = 0
    var answer = Int.MAX_VALUE
    private var totalScore = 0
    lateinit var graph:Array<IntArray>
    lateinit var visited:BooleanArray
    fun solution(){
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        graph = Array(n){br.readLine().split(" ").map { it.toInt() }.toIntArray()}

        for (x in graph.indices)
            for (y in graph[x].indices) totalScore += graph[x][y]
        dfs1(0,(1..n).toList(), listOf())
        println(answer)
    }

    fun dfs1(cur:Int,team:List<Int>,cbn:List<Int>){
       if (cbn.size >=2){
           aScore = search(cbn)
           println(cbn)
           bScore = search(team.filter { !cbn.contains(it) })
           println(cbn)
           answer = minOf(abs(bScore-aScore))
        }

        for (i in cur until team.size){
            dfs1(i+1,team,cbn+i)
        }
    }
    fun search(cbn:List<Int>) :Int{
        var score = 0
     for (i in 0 until cbn.size-1){
         for (j in i+1 until cbn.size){
             score += teamScore(i,j)
         }
     }
        return score
    }

    fun teamScore(x:Int,y:Int):Int = graph[x][y] + graph[y][x]
}