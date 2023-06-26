package gold

import java.util.LinkedList

//8 8
//0 0 0 0 0 0 0 0
//0 0 0 3 0 0 0 4
//0 1 0 0 3 0 0 3
//0 0 0 0 0 0 1 0
//0 1 0 9 0 0 4 0
//0 0 0 0 2 0 0 0
//0 0 0 0 0 0 0 0
//0 0 0 2 0 0 0 0

fun main() {
    Air().solution()

}

class Air {
    var row = 0
    var column = 0
    lateinit var board: Array<IntArray>
    lateinit var boardState: Array<BooleanArray>
    val dx = listOf(1,0,-1,0)
    val dy = listOf(0,1,0,-1)
    fun solution() {
        val br = System.`in`.bufferedReader()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        row = n
        column = m
        board = Array(row) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
        boardState = Array(row) { BooleanArray(column) }
        val airs = mutableListOf<Pair<Int,Int>>()
        for (i in board.indices)
            for (j in board[i].indices)
                if (board[i][j] == 9) airs.add(Pair(i,j))
        airs.forEach { airIdx ->
            val (x,y) = airIdx
            wind(x,y)
        }
        var answer = 0
        for (i in boardState) answer += i.count {it}
        println(answer)
    }

    fun wind(x:Int,y:Int){
        boardState[x][y] = true
        for (i in 0..3){
            var d = i
            var nx = x
            var ny = y
            while(true){
                nx += dx[d]
                ny += dy[d]
                if (nx < 0 || ny < 0 || nx >=row || ny >=column ) break
                if (board[nx][ny] == 9) break
                boardState[nx][ny] = true
                if(board[nx][ny] != 0){
                    val rotate = rotate(d,board[nx][ny])
                    if(rotate == -1) break
                    else d = rotate
                }
            }

        }
    }
    fun rotate(d:Int,tool:Int):Int{
        var direction = d
        when(tool){
            1 -> {
                direction = when (d) {
                    1 -> -1
                    3 -> -1
                    else -> d
                }
            }
            2 ->{
                direction = when (d) {
                    0 -> -1
                    2 -> -1
                    else -> d
                }
            }
            3 ->{
                direction = when (d) {
                    0 -> 3
                    1 -> 2
                    2 -> 1
                    else -> 0
                }
            }
            4 ->{
                direction = when (d) {
                    0 -> 1
                    1 -> 0
                    2 -> 3
                    else -> 2
                }
            }
        }
        return direction
    }
}



