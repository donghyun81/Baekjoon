package data_structure.silver

import java.util.Stack

//()(((()())(())()))(())
fun main(){
    val br = System.`in`.bufferedReader()
    val board = br.readLine()
    val laser = 0
    val sticks = Stack<Char>()
    var sticksCnt = 0
    var answer = 0
    for (idx in board.indices){
        if(board[idx] =='('){
            sticks.push(board[idx])
        }else{
            sticks.pop()
            if (board[idx-1]==')') {
                answer+=1
            } else{
                answer+= sticks.size
            }
        }
    }

    println(answer)
}