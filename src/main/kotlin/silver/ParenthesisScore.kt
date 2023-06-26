package silver
//(()[[]])([])
import java.util.Stack
fun main(){
    val br = System.`in`.bufferedReader()
    val parentheses = br.readLine()
    val s = Stack<Char>()
    var score = 0
    var tempScore = 1
    val nums = mutableListOf<Int>()
    for (i in parentheses.indices){
        println(score)
        val p = parentheses[i]
        when (p) {
            '(' -> {
                s.push(p)
                tempScore *=2
            }
            '[' ->{
                s.push(p)
                tempScore *=3
            }
            ')' -> {
                if (s.isEmpty() || s.peek() != '(' ){
                    println(0)
                    return
                }
                if (parentheses[i-1] =='('){
                    score+= tempScore
                }
                tempScore/=2
                 s.pop()
            }
            ']' -> {
                if (s.isEmpty() || s.peek() != '[' ){
                    println(0)
                    return
                }
                if (parentheses[i-1] =='['){
                    score+= tempScore
                }
                tempScore/=3
                s.pop()
            }
        }
    }
   if (s.isEmpty()) println(score) else println(0)
}