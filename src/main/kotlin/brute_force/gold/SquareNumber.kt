package brute_force.gold

import kotlin.math.sqrt


fun main(){
    SquareNumber().solution()

}
//2 3
//123
//456

class SquareNumber {

    var n = 0
    var m = 0
    var answer = 0
    lateinit var graph:Array<IntArray>
    fun solution(){
        val br = System.`in`.bufferedReader()
        val (n,m) = br.readLine().split(" ").map { it.toInt() }
        this.n = n
        this.m = m
        graph = Array(n){br.readLine().map { it.digitToInt() }.toIntArray()}
        for (i in 0 until n){
            for (j in 0 until m ) dfs(i,j,"")
        }
        println(answer)
    }
    fun dfs(x:Int,y:Int,sum:String){
        if (sum.isNotEmpty()&&sqrt(sum.toDouble())== sqrt(sum.toDouble()).toInt().toDouble()){
            answer = maxOf(answer,sum.toInt())
        }

        for (curX in x until n){
            for (curY in y until m){
                dfs(x+1,y+1,sum+graph[curX][curY])
            }
        }
    }
}