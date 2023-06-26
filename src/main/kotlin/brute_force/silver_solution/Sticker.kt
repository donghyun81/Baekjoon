package brute_force.silver_solution
//10 9
//4
//2 3
//1 1
//5 10
//9 11
class Sticker {
}
fun main(){
    val br = System.`in`.bufferedReader()
    val (row,column) = br.readLine().split(" ").map { it.toInt() }
    val stickers = mutableListOf<Pair<Int,Int>>()
    val cnt = br.readLine().toInt()
    repeat(cnt){
        val (x,y) = br.readLine().split(" ").map { it.toInt() }
        stickers.add((Pair(x,y)))
    }
    var answer = 0
    val visited = BooleanArray(cnt)
    fun dfs(depth:Int,extend:Int){
        if(depth ==2 && extend <= row*column) {
            println(answer)
            answer = maxOf(extend,answer)
            return
        }
        for (i in stickers.indices){
            if (visited[i]) continue
            visited[i] = true
            val (x,y) = stickers[i]
            if ((x>row || y >column) && (y>row || x >column)) continue
            println(x)
            println(y)
            dfs(depth+1,x*y+extend)
            visited[i] = false
        }
    }
    dfs(0,0)
    println(answer)
}
