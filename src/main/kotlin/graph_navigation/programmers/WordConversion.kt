package programmers

fun main() {
    val begin = "hit"
    val target = "cog"
    val words = arrayOf("hot", "dot", "dog", "lot", "cog","log")
    println(WordConversion().solution(begin, target, words))

}

class WordConversion {
    private var answer = 0
    private lateinit var visited: BooleanArray

    fun solution(begin: String, target: String, words: Array<String>): Int {
        visited = BooleanArray(words.size)
        dfs(begin, target, words, 0)
        return answer
    }

    private fun dfs(current: String, target: String, words: Array<String>, count: Int) {
        if (current == target) {
            if (answer == 0 || answer > count) {
                answer = count
            }
            return
        }

        for (i in words.indices) {
            if (!visited[i] && isConvertible(current, words[i])) {
                visited[i] = true
                dfs(words[i], target, words, count + 1)
                visited[i] = false
            }
        }
    }

    private fun isConvertible(current: String, next: String): Boolean {
        var count = 0
        for (i in current.indices) {
            if (current[i] != next[i]) {
                count++
            }
        }
        return count == 1
    }
}

