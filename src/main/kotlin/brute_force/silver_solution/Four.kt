package brute_force.silver_solution

import kotlin.math.pow
import kotlin.math.sqrt
fun main(){
    val br = System.`in`.bufferedReader()
    val num = br.readLine().toDouble()
    var answer = Int.MAX_VALUE
    val numSqrt = sqrt(num).toInt()
    val visited = BooleanArray(numSqrt)
    fun dfs(cur:Int,nums:List<Int>){
        if (nums.sum() >= num.toInt()) {
            return
            if (nums.sum() == num.toInt()) {
               answer = minOf(nums.size)
                return
            }
        }
        for (num in cur .. numSqrt ){
            dfs(cur+1,nums+cur.toDouble().pow(2).toInt())
        }
    }
    dfs(1, listOf())
    println(answer)
}