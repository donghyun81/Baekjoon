package silver

import java.util.*

fun main(){
    Word().solution()

}

class Word(){
    var word :String
    init {
        val br = System.`in`.bufferedReader()
        word = br.readLine()
    }
    fun solution(){
       val len = word.length
        var idx = 0
        var answer=""
        while(idx <= len-1){
            val curIdx = idx
            val stack = Stack<Char>()
            if (word[idx] == '<') {
                stack.push(word[idx])
                while (stack.isNotEmpty()){
                    idx++
                    if(word[idx] == '>') stack.pop()
                }
                idx++
                answer+= word.substring(curIdx,idx)
            }
            else if(word[idx] != ' '){
                stack.push('i')
                while (stack.isNotEmpty()) {
                    idx++
                    if(word[idx] == '<' || word[idx] == ' ' || idx <= len-1 ) stack.pop()
                }
                println(word.substring(curIdx,idx).reversed())
                answer += word.substring(curIdx,idx).reversed()
            }
            else idx++
            println(answer)
        }
        println(answer)
    }
    fun getBracketsIdx(){

    }
}



