package brute_force.silver_solution

//4
//1 7
//2 6
//3 8
//4 9
import kotlin.math.abs
fun main(){
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()
    val foods = mutableListOf<Pair<Int,Int>>()
    repeat(cnt){
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        foods.add(Pair(a,b))
    }
    val visited = BooleanArray(cnt)
    var minSum = Long.MAX_VALUE
    fun dfs(aSum:Long,bSum:Long){
        if (aSum > 1 || bSum > 1){
            minSum = minOf(abs(aSum-bSum),minSum)
        }
        for (i in foods.indices){
            if (visited[i]) continue
            val (a,b) = foods[i]
            visited[i] = true
            dfs(aSum*a,bSum+b)
            visited[i] = false
        }
    }
    dfs(1,0)
    println(minSum)
}