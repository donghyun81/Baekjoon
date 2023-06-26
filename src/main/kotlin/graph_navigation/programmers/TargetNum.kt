package programmers

import java.util.LinkedList

fun main() {
    val numbers = listOf(4, 1, 2, 1).toIntArray()
    val target = 4
    print(TargetNum().solution(numbers, target))

}

class TargetNum {
    fun solution(numbers: IntArray, target: Int): Int {
        var sums = mutableListOf<Int>()
        var answer = 0

        fun dfs(cur: Int, result: Int) {
            if (numbers.size == cur){
                if (result == 4) answer++
            }
            else {
                dfs(cur+1,result+numbers[cur])
                dfs(cur+1,result-numbers[cur])
            }
        }
        dfs(0,0)
        return answer
    }
}