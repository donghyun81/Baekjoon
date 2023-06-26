package silver
//
//
//
fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, cnt) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    fun deepCopy(board: Array<IntArray>): Array<IntArray> = board.map { it.toMutableList().toIntArray() }.toTypedArray()
    repeat(cnt){
        val tempBoard = deepCopy(board)

        for(i in 0 until minOf(n,m)/2){
            var row = i
            var column=i
            //아래
            for (j in row+1 until n-row){
                board[j][column] = tempBoard[j-1][column]
            }
            //오른쪽
            for (j in column+1 until m-column){

                board[n-1-row][j] = tempBoard[n-1-row][j-1]
            }
            //위
            for (j in n-row-1-1 downTo row){
                board[j][m-1-column] = tempBoard[j+1][m-1-column]
            }
            //왼쪽
            for (j in m-column-1-1 downTo column){
                board[row][j] = tempBoard[row][j+1]
            }
        }
    }
    for(i in board.indices){
        for (j in board[i].indices) print("${board[i][j]} ")
        println()
    }

}


//import java.util.*
//
//val dy = intArrayOf(1, 0, -1, 0)
//val dx = intArrayOf(0, 1, 0, -1)
//val arr = Array(333) { IntArray(333) }
//val used = Array(333) { BooleanArray(333) }
//val used2 = Array(333) { BooleanArray(333) }
//
//fun main() {
//    val input = Scanner(System.`in`)
//    val N = input.nextInt()
//    val M = input.nextInt()
//    val R = input.nextInt()
//
//    for (i in 0 until N) {
//        for (j in 0 until M) {
//            arr[i][j] = input.nextInt()
//        }
//    }
//
//    for (i in 0 until N) {
//        var y = i
//        var x = i
//        var dir = 0
//        val cur = mutableListOf<Int>()
//        cur.add(arr[y][x])
//        used[y][x] = true
//
//        while (dir < 4) {
//            val qy = y + dy[dir]
//            val qx = x + dx[dir]
//
//            if (qy < 0 || qy >= N || qx < 0 || qx >= M || used[qy][qx]) {
//                dir++
//                continue
//            }
//
//            y = qy
//            x = qx
//            used[y][x] = true
//            cur.add(arr[y][x])
//        }
//
//        val L = cur.size
//        var idx = (L - R % L) % L
//        y = i
//        x = i
//        dir = 0
//        used2[y][x] = true
//        arr[y][x] = cur[idx]
//
//        if (++idx == cur.size) {
//            idx = 0
//        }
//
//        while (dir < 4) {
//            val qy = y + dy[dir]
//            val qx = x + dx[dir]
//
//            if (qy < 0 || qy >= N || qx < 0 || qx >= M || used2[qy][qx]) {
//                dir++
//                continue
//            }
//
//            y = qy
//            x = qx
//            used2[y][x] = true
//            arr[y][x] = cur[idx]
//
//            if (++idx == cur.size) {
//                idx = 0
//            }
//        }
//    }
//
//    for (i in 0 until N) {
//        for (j in 0 until M) {
//            print("${arr[i][j]} ")
//        }
//        println()
//    }
//}

