package brute_force.silver_solution


//fun main() {
//    val br = System.`in`.bufferedReader()
//    val n = 19
//    val board = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
//    Five().solution(board)
//}
//class Five {
//    lateinit var board :Array<IntArray>
//    var dx = intArrayOf(1, 1, 0, -1)
//    var dy = intArrayOf(0, 1, 1, 1)
//    fun solution(board :Array<IntArray>) {
//        this.board = board
//        println(search())
//
//    }
//
//    fun search():String {
//        for (i in board.indices) {
//            for (j in board[i].indices) {
//                if (board[i][j] == 1 || board[i][j]==2){
//                    if (stone(i,j,board[i][j])){
//                        return "${board[i][j]}\n${i+1} ${j+1}"
//                    }
//                }
//            }
//        }
//        return "0"
//    }
//
//    fun stone(x:Int,y:Int,curStoneNum:Int):Boolean{
//            for (i in 0..3) {
//                var stoneCnt = 1
//                var nx = x
//                var ny = y
//                val tempX = x-dx[i]
//                val tempY = y-dy[i]
//                if (tempX >= 0 && tempY >= 0 &&tempX < 19 && tempY < 19){
//                    if (board[tempX][tempY]==curStoneNum) continue
//                }
//                while (true){
//                    nx += dx[i]
//                    ny += dy[i]
//                    if(nx < 0 ||nx <0 ||nx >=19 || ny>=19) break
//                    if (curStoneNum != board[nx][ny]) break
//                    stoneCnt++
//                }
//                if (stoneCnt == 5) return true
//            }
//        return false
//    }
//
//}


var map = Array(21) { IntArray(21) }
var memo = Array(21) { Array(21) { IntArray(4) } }
var dx = intArrayOf(1, 1, 0, -1)
var dy = intArrayOf(0, 1, 1, 1)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    for (i in 1..19) {
        val str = readLine().split(" ").map { it.toInt() }
        for (j in 1..19) {
            map[i][j] = str[j - 1]
        }
    }
    println(findFive())
    println(memo[1][1].toList())
    println(memo[3][1].toList())
}

fun findFive(): String {
    for (j in 1..19) {
        for (i in 1..19) {
            if (map[i][j] != 0) {
                for (d in 0..3) {
                    if (memo[i][j][d] == 0 && calc(i, j, d, map[i][j]) == 5) {
                        return "${map[i][j]}\n$i $j"
                    }
                }
            }
        }
    }
    return "0"
}

fun calc(x: Int, y: Int, dir: Int, color: Int): Int {
    val nx = x + dx[dir]
    val ny = y + dy[dir]
    if (map[nx][ny] == color) {
        return calc(nx, ny, dir, color) + 1.also { memo[nx][ny][dir] = it }
    } else return 1
}