package programmers

import kotlin.math.ceil


//	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]
fun main() {
    val comNum = 3
    val computers = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))
    println(Solution().solution(comNum, computers))
    val a = mutableMapOf<Int,Int  >()
    a.values.reduce{a,c-> a*c}

}

class Solution {

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visited = mutableListOf<Int>()
        fun dfs(cur: Int) {
            visited.add(cur)
            for (i in computers[cur].indices) {
                if (computers[cur][i] == 0 || visited.contains(i)) continue
                dfs(i)
            }
        }
        for (i in 0 until n) {
            if (!visited.contains(i)) {
                dfs(i)
                answer++
            }
        }
        return answer
    }
}