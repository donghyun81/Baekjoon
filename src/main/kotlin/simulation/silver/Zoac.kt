package silver

import kotlin.math.abs


fun main(){
    Zoac().solution()

}
class Zoac {
    private val br =System.`in`.bufferedReader()
    private var right:String
    private var left:String
    private var targetWord:String
    val board = listOf("qwertyuiop","asdfghjkl","zxcvbnm")
    val xPlace = IntArray(44)
    val yPlace = IntArray(44)
    val rights = "yuiophjklbnm"
    init {

        val (startLeft,startRight) = br.readLine().split(" ")
        right = startRight
        left = startLeft
        targetWord = br.readLine()
    }
    // 실행
    fun solution(){
        var time = 0
        for (x in board.indices){
            for(y in board[x].indices){
                yPlace[board[x][y]-'a'] = y
                xPlace[board[x][y]-'a'] = x
            }
        }
        println(xPlace.toList())
        println(yPlace.toList())
        targetWord.forEach { alphabet ->
            if (rights.contains(alphabet)){
                time += abs(right.first(),alphabet)+1
                right= alphabet.toString()
            }else{
                time +=abs(left.first(),alphabet)+1
                left= alphabet.toString()
            }
            println(time)
        }
        println(time)
    }
    // 절대값 식
    fun abs(cur:Char,nxt:Char):Int = abs(xPlace[cur-'a']-xPlace[nxt-'a']) + abs(yPlace[cur-'a']-yPlace[nxt-'a'])
    // 오른쪽 왼쪽 확인

}