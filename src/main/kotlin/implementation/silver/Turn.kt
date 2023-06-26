package silver

fun main(){
    Turn().solution()

}
class Turn {
//    var testCase :Int
    var n:Int
    var angle:Int
    var board:Array<IntArray>
    init {
        val br = System.`in`.bufferedReader()
//        testCase = br.readLine().toInt()
        var (tempN,tempAngel) = br.readLine().split(" ").map { it.toInt() }
        n = tempN
        angle = tempAngel
        board = Array(n){br.readLine().split(" ").map { it.toInt() }.toIntArray()}
    }
    fun solution(){
        if (angle>0){
            repeat(angle/45){
                rotate45()
                for (i in board) println(i.toList())
                println("--------")
            }
        } else{
            repeat(angle/45){
                rotateMinus45()
            }
        }

    }

    fun rotate45(){
        val tempBoard = deepCopy(board)
        val n = n-1
        for (i in board.indices) {
            board[i][(n + 1) / 2] = tempBoard[i][i]
            board[i][n - i] = tempBoard[i][(n + 1) / 2]
            board[(n + 1) / 2][n-i] = tempBoard[i][n - i]
            board[i][i] = tempBoard[(n + 1) / 2][i]
        }
    }
    fun rotateMinus45(){

    }
    fun deepCopy(board:Array<IntArray>):Array<IntArray>{
        return board.map { it.toMutableList().toIntArray() }.toTypedArray()
    }


}