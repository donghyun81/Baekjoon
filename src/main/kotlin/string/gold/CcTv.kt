package gold

import java.util.LinkedList

//4 6
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 1 0 6 0
//0 0 0 0 0 0
fun main(){
    val br = System.`in`.bufferedReader()
    val (row,column) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(row){br.readLine().split(" ").map { it.toInt() }.toIntArray()}

}
class CcTv {
    var row = 0
    var column = 0
    lateinit var board:Array<IntArray>
    lateinit var boardState: Array<BooleanArray>
    val dx = listOf(1,0,-1,0)
    val dy = listOf(0,1,0,-1)
    fun solution(row:Int,column:Int,board : Array<IntArray>){
        this.row = row
        this.column = column
        this.board = board
    }
    fun dfs(cur:Pair<Int,Int>,cctvNum:Int){
        val q = LinkedList<Pair<Int,Int>>()
        q.offer(cur)
            when(cctvNum){
                1 ->{
                    val (x,y)= q.poll()
                    var idx = 0
                    var max = 0
                    for (i in 0..3){
                        var cnt = 0
                       var nx = x
                       var ny = y
                        while (nx>=0 && ny >=0 && nx < row && ny <column ){
                            if (board[nx][ny] == 6) break
                            if (boardState[nx][ny]) continue
                            cnt++
                            nx +=x
                            ny +=y
                        }
                        if (max <= cnt) {
                            max=cnt
                            idx = i
                        }
                    }
                    q.offer(Pair(x,y))
                    while (q.isNotEmpty()) {
                        var nx = x
                        var ny = y
                        boardState[nx][ny] = true

                    }
                }
                2 ->{}
                3 ->{}
                4 ->{}
                5 ->{}
        }
    }
}
