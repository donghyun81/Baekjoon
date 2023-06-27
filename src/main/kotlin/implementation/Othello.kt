package implementation

import java.lang.StringBuilder
import java.util.LinkedList

fun main() {
    Othello().solution()
}

//6
//3 2
//4 2
//5 3
//2 2
//2 1
//3 5

//......
//BW....
//.BWWW.
//.WBW..
//..B...
//......
class Othello {
    lateinit var othelloBoard: Array<IntArray>
    var round = 0

    fun solution() {
        val br = System.`in`.bufferedReader()
        othelloBoard = Array(6) { IntArray(6) }
        round = br.readLine().toInt()
        resetBoard()
        repeat(round){
            val stoneNum = if (it%2 == 0) BLACK_STONE else WHITE_STONE
            val (rPlace,cPlace) = br.readLine().split(" ").map { it.toInt() }
            executeRound(stoneNum,rPlace-1,cPlace-1)
        }
        boardPrint()
        printWinner()
    }

    fun resetBoard(){
        for (row in othelloBoard.indices) othelloBoard[row].fill(0)
        othelloBoard[2][2] = WHITE_STONE
        othelloBoard[2][3] = BLACK_STONE
        othelloBoard[3][3] = WHITE_STONE
        othelloBoard[3][2] = BLACK_STONE
    }

    fun executeRound(stoneNum:Int,rPlace:Int,cPlace:Int){
        val dx = listOf(1,0,-1,0,1,-1,1,-1)
        val dy = listOf(0,1,0,-1,1,-1,-1,1)
        othelloBoard[rPlace][cPlace] = stoneNum
            for (drc in 0 until 8) {
                var nr = rPlace
                var nc = cPlace
                val moveIdxs = mutableListOf<Pair<Int,Int>>()
                while(true){
                    nr += dx[drc]
                    nc += dy[drc]
                if (nr < 0 || nc < 0 || nr >= MAX_ROW || nc >= MAX_COLUMN) break
                if (othelloBoard[nr][nc] == 0) break
                if (othelloBoard[nr][nc] == stoneNum) {
                    for ((nr,nc) in moveIdxs){
                        othelloBoard[nr][nc] = stoneNum
                    }
                    break
                }
                    moveIdxs.add(nr to nc)
                }
            }
    }

    fun boardPrint(){
        for (r in othelloBoard.indices){
            for (c in othelloBoard[r].indices){
                print(
                    when(othelloBoard[r][c]){
                        BLACK_STONE -> "B"
                        WHITE_STONE -> "W"
                        else -> "."
                })
            }
           println()
        }
    }
    fun printWinner(){
        var blackStoneCnt = 0
        var whiteStoneCnt = 0
        for (r in othelloBoard.indices){
            for (c in othelloBoard[r].indices){
              if (othelloBoard[r][c]== BLACK_STONE)blackStoneCnt++
                else if(othelloBoard[r][c] == WHITE_STONE) whiteStoneCnt++
            }
        }
        when{
            blackStoneCnt > whiteStoneCnt -> println("Black")
            blackStoneCnt < whiteStoneCnt -> println("White")
        }
    }

    companion object{
        const val MAX_ROW = 6
        const val MAX_COLUMN = 6
        const val BLACK_STONE = 1
        const val WHITE_STONE = 2
    }
}