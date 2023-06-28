package implementation.gold

import java.util.LinkedList

fun main(){
    RoboticVacuum().solution()

}

//3 3 n m
//1 1 0 start drc
//1 1 1 board
//1 0 1
//1 1 1
class RoboticVacuum {
    var row = 0
    var column = 0
    var answer = 0
    lateinit var board: Array<IntArray>
    lateinit var cleanState: Array<BooleanArray>
    val dx = listOf(-1, 0, 1, 0)
    val dy = listOf(0, 1, 0, -1)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        row = n
        column = m
        val (startX, startY, direction) = br.readLine().split(" ").map { it.toInt() }
        board = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
        cleanState = Array(n) { BooleanArray(m) }
        var wallCnt = 0
        for (x in board.indices)
            for (y in board[x].indices)
                if (board[x][y] ==1 ){
                    cleanState[x][y]=  true
                    wallCnt++
                }
        execute(startX to startY,direction)

        for (x in cleanState.indices)
            for (y in cleanState[x].indices)
                if (cleanState[x][y]) answer++
        println(answer-wallCnt)
    }

    fun execute(startPlace: Pair<Int, Int>, direction: Int) {
        var curDrc = direction
        var (curX,curY) = startPlace
        while (true){
            cleanState[curX][curY] = true
            if(isCleanAround(curX to curY)){
                val moveX  = curX - dx[curDrc]
                val moveY = curY - dy[curDrc]
                if (moveX <0 || moveY <0 || moveX >=row || moveY >=column) break
                if (board[moveX][moveY]==1) break
                curX = moveX
                curY = moveY

            }else {
                curDrc--
                if (curDrc < 0) curDrc =3
                val moveX  = curX + dx[curDrc]
                val moveY = curY + dy[curDrc]
                if (moveX <0 || moveY <0 || moveX >=row || moveY >=column) continue
                if (cleanState[moveX][moveY]) continue
                curX = moveX
                curY = moveY
            }
        }
    }

    fun isCleanAround(startPlace: Pair<Int, Int>):Boolean{
        val (x,y) = startPlace
        for (idx in 0 until 4){
            val nx = x+dx[idx]
            val ny = y+dy[idx]
            if (nx <0 || ny <0 || nx >=row || ny >=column) continue
            if(!cleanState[x+dx[idx]][y+dy[idx]])  return false
        }
        return true
    }

}
