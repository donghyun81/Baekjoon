package silver

//fun main() {
//    MinesWeeper().play()
//
//}
//
//class MinesWeeper() {
//    private val br = System.`in`.bufferedReader()
//    private val range = br.readLine().toInt()
//    private val minesLocation = Array(range) { br.readLine() }
//    private val playResult = Array(range) { br.readLine().toCharArray().toMutableList() }
//    private val minesIndex = mutableListOf<Pair<Int, Int>>()
//    private val intResult = Array(range) { MutableList(range) { 0 } }
//
//    fun play() {
//        getMinesLocation()
//        setMinesCount()
//        val result = intResult.map { it.map { it.toString().toCharArray()[0] } }
//        for (i in playResult.indices) {
//            for (j in playResult.indices) {
//                if (playResult[i][j] == 'x') playResult[i][j] = result[i][j]
//                for (p in minesIndex) if (p == Pair(i, j) && playResult[i][j] == '*') playResult[p.first][p.second] =
//                    '*'
//            }
//        }
//        for (i in playResult) {
//            println(i)
//        }
//    }
//
//    private fun getMinesLocation() {
//        for (i in minesLocation.indices) {
//            for (j in minesLocation[i].indices) {
//                if (minesLocation[i][j] == '*') minesIndex.add(Pair(i, j))
//            }
//        }
//    }
//
//    private fun setMinesCount() {
//        for (i in minesIndex) {
//            if (i.first - 1 >= 0 && i.second - 1 >= 0 && i.first + 1 < range && i.second + 1 < range ) {
//                intResult[i.first + 1][i.second]++
//                intResult[i.first + 1][i.second + 1]++
//                intResult[i.first + 1][i.second - 1]++
//                intResult[i.first - 1][i.second - 1]++
//                intResult[i.first - 1][i.second + 1]++
//                intResult[i.first - 1][i.second]++
//                intResult[i.first][i.second + 1]++
//                intResult[i.first][i.second - 1]++
//            }
//        }
//    }
//}

import java.io.File

//fun main() {
//    val br = System.`in`.bufferedReader()
//    val n = br.readLine().toInt()
//
//    val map = mutableListOf<MutableList<Char>>()
//    val current = mutableListOf<MutableList<Char>>()
//
//    for (i in 1..n) {
//        map.add(br.readLine().toCharArray().toMutableList())
//    }
//    for (i in 1..n) {
//        current.add(br.readLine().toCharArray().toMutableList())
//    }
//
//    val dx = listOf(-1, 0, 1, -1, 1, -1, 0, 1)
//    val dy = listOf(-1, -1, -1, 0, 0, 1, 1, 1)
//
//    var isMine = false
//
//    for (i in 0 until n) {
//        for (j in 0 until n) {
//            if (current[i][j] == 'x') {
//                if (map[i][j] == '*') {
//                    // 지뢰 밟음
//                    isMine = true
//                }
//                var cnt = 0
//                for (k in 0 until 8) {
//                    val x = i + dx[k]
//                    val y = j + dy[k]
//                    if (x < 0 || x >= n || y < 0 || y >= n)
//                        continue
//                    if (map[x][y] == '*') cnt++
//                }
//                current[i][j] = cnt.toString().first()
//            }
//        }
//    }
//
//    if (isMine) {
//        for (i in 0 until n) {
//            for (j in 0 until n) {
//                if (map[i][j] == '*') {
//                    current[i][j] = '*'
//                }
//            }
//        }
//    }
//
//    for (i in 0 until n) {
//        println(current[i].joinToString(""))
//    }
//}

//입력 결과
//8 8x8 지뢰 범위(1~10)
//...**..* *은 지뢰
//......*.
//....*...
//........
//........
//.....*..
//...**.*.
//.....*..
//xxx..... 현재 지뢰찾기 시점
//xxxx....
//xxxx....
//xxxxx...
//xxxxx...
//xxxxx...
//xxx.....
//xxxxx...
//출력 결과
//001.....
//0013....
//0001....
//00011...
//00001...
//00123...
//001.....
//00123...
//현 시점에 x는 x근처의 지뢰개수로 변경, 현 시점에 지뢰가 있을 경우 전부 지뢰부분 모두 표시된 결과를 출력

fun main(){
    MinesWeeper().play()

}
class MinesWeeper (){
    private var board:Array<String>
    private var curBoard:Array<MutableList<Char>>
    private var minesCntBoard:Array<IntArray>
    private val minesIdx = mutableListOf<Pair<Int,Int>>()
    val dx = listOf(-1,-1,-1,0,0,1,1,1)
    val dy = listOf(-1,0,1,-1,1,-1,0,1)
    init {
        val br = System.`in`.bufferedReader()
        val n = br.readLine().toInt()
        board = Array(n){br.readLine()}
        curBoard = Array(n){br.readLine().toCharArray().toMutableList()}
        minesCntBoard = Array(n){ IntArray(n) }
    }
    fun play(){
        boardSet()
        curBoardSet()
        for(i in curBoard) println(i)
    }
    fun boardSet(){
        for(i in board.indices){
            for(j in board[i].indices){
                if (board[i][j] == '*') minesIdx.add(Pair(i,j))
                for(dir in 0..7){
                    val nx = i+dx[dir]
                    val ny = j+dy[dir]
                    if (isFrameOut(nx,ny, frame = board.size)) continue
                    if (board[nx][ny] == '.') continue
                    minesCntBoard[i][j] +=1
                }
            }
        }
    }
    fun curBoardSet(){
        var isMineOn = false
        for (i in curBoard.indices){
            for(j in curBoard.indices){
                if(curBoard[i][j] =='x') {
                    curBoard[i][j] = minesCntBoard[i][j].digitToChar()
                    if(board[i][j] =='*') isMineOn=true
                }
            }
        }
        if (isMineOn){
            for (i in minesIdx){
                val (x,y) = i
                curBoard[x][y] ='*'
            }
        }
    }
    fun isFrameOut(x:Int,y:Int,frame:Int) = x<0 || y < 0 || x>=frame || y >=frame
}


//fun main() {
//    val br = System.`in`.bufferedReader()
//    val n = br.readLine().toInt()
//    val map = Array(n) { br.readLine().toCharArray() }
//    val current = Array(n) { br.readLine().toCharArray().toMutableList() }
//    var isMine = false
//    val bx = listOf(-1, 0, 1, -1, 1, -1, 0, 1)
//    val by = listOf(1, 1, 1, 0, 0, -1, -1, -1)
//    for (y in current.indices) {
//        for (x in current.indices) {
//            if (current[y][x] == 'x') {
//                if (map[y][x] == '*') isMine = true
//                var mineCount = 0
//                for (position in bx.indices) {
//                    val nx = bx[position] + x
//                    val ny = by[position] + y
//                    if (nx>=0&&ny>=0&&nx<n&&ny<n)
//                        if(map[ny][nx] == '*')  mineCount++
//                }
//                current[y][x] = mineCount.toString().first()
//            }
//        }
//    }
//    if (isMine){
//        for (y in current.indices) {
//            for (x in current.indices) {
//                if(map[y][x]=='*') current[y][x] = '*'
//            }
//        }
//    }
//
//    for (y in current.indices) {
//        for (x in current.indices) {
//            print(current[y][x] )
//        }
//        println()
//    }
//}