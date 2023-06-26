package silver

import java.util.*

fun main(){
    Parenthesis().solution()

}

//6
//(())())
//(((()())()
//(()())((()))
//((()()(()))(((())))()
//()()()()(()()())()
//(()((())()(
class Parenthesis {
    fun solution(){
        val br = System.`in`.bufferedReader()
        val cnt =br.readLine().toInt()
        repeat(cnt){
            val parentheses = br.readLine()
            val s = Stack<Char>()
            var isVps = true
            for (parenthesis in parentheses){
                if (parenthesis =='('){
                    s.push(parenthesis)
                }else{
                    if (s.isEmpty()){
                        isVps = false
                        break
                    }
                    s.pop()
                }
            }
            if (!isVps || s.isNotEmpty()) println("NO") else println("YES")
        }
    }
}