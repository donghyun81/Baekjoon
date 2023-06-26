package silver

import java.util.*
import kotlin.math.abs

fun main() {
    KeyBoard().play()

}

class KeyBoard(){
    lateinit var leftKeyBoard:List<List<String>>
    lateinit var rightKeyBoard:List<List<String>>



    fun play(){
        val br = System.`in`.bufferedReader()
        var (left,right) = br.readLine().split(" ")
        var answer = 0
        leftKeyBoard = listOf(
            listOf("q","w","e","r","t"),
            listOf("a","s","d","f","g"),
            listOf("z","x","c","v")
        )
        rightKeyBoard = listOf(
            listOf("y","u","i","o","p"),
            listOf("h","j","k","l"),
            listOf("b","n","m")
        )

        val word = br.readLine()
        for (i in word.indices){
            if(rightKeyBoard.flatten().contains(word[i].toString())){
                val keyIdx = getKeyIdx(word[i].toString(),rightKeyBoard)
                val rightIdx = getKeyIdx(right,rightKeyBoard)
                val rightValue = abs(keyIdx.first-rightIdx.first) + abs(keyIdx.second-rightIdx.second)
                answer+=rightValue+1
                right=word[i].toString()
            }else {
                val keyIdx = getKeyIdx(word[i].toString(),leftKeyBoard)
                val leftIdx = getKeyIdx(left, leftKeyBoard)
                val leftValue = abs(keyIdx.first - leftIdx.first) + abs(keyIdx.second - leftIdx.second)
                answer += leftValue+1
                left = word[i].toString()
            }
        }
        println(answer)
    }
    fun getKeyIdx(alphabet:String,keyBoard: List<List<String>>) : Pair<Int,Int>{
        var answer = Pair(0,0)
        for(i in keyBoard.indices)
            for (j in keyBoard.indices) if(keyBoard[i][j]==alphabet)  answer = Pair(i,j)
        return answer
    }
}

//