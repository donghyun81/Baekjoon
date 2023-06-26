package gold
//5 5 3
//1 1 1 1 1
//1 2 2 1 1
//3 1 2 2 2
//1 3 2 1 1
//1 3 3 1 1
//3 1 E
//3 5
//5 3 N
//3 3
//5 2 N
//3 1
fun main(){
    Domino().solution()
}
class Domino {
    var row = 0
    var column = 0
    var roundCnt = 0
    lateinit var dominoBoard :Array<IntArray>
    lateinit var dominoState:Array<BooleanArray>
    val dx = listOf(-1,0,1,0)
    val dy = listOf(0,1,0,-1)
    val d = listOf("N","E","S","W")
    var answer = 0

    fun solution(){
        val br = System.`in`.bufferedReader()
        val (row,column,roundCnt) = br.readLine().split(" ").map { it.toInt() }
        val dominoBoard = Array(row){br.readLine().split(" ").map { it.toInt() }.toIntArray()}
        this.row = row
        this.column = column
        this.roundCnt = roundCnt
        this.dominoBoard = dominoBoard
        dominoState = Array(row){ BooleanArray(column) }
        repeat(roundCnt){
            val (attackX,attackY,direction) = br.readLine().split(" ")
            val (defenceX,defenceY) = br.readLine().split(" ").map { it.toInt() }
            attack(attackX.toInt()-1,attackY.toInt()-1,direction)
            defence(defenceX-1,defenceY-1)
        }
        println(answer)
        for (x in dominoState.indices){
            for (y in dominoState[x].indices){
                if (dominoState[x][y]) print("F ") else print("S ")
            }
            println()
        }
    }

    fun attack(x:Int,y:Int,direction:String){
        val dirIdx = d.indexOf(direction)
        var height = dominoBoard[x][y]
        dominoState[x][y] = true
        answer++
        var nx = x
        var ny = y
        while(true){
            if (height <2) break
            for (i in 1 until height){
                nx += dx[dirIdx]
                ny += dy[dirIdx]
                if (nx <0 || ny <0 || nx>=row || ny>=column) {
                    height = 0
                    break
                }
                if (dominoState[nx][ny]) height = maxOf(height-1,0)
                else {
                    answer++
                    dominoState[nx][ny] = true
                    height = maxOf(height-1,dominoBoard[nx][ny])
                }
            }
        }
    }
    fun defence(x:Int,y:Int){
        dominoState[x][y] = false
    }
}

