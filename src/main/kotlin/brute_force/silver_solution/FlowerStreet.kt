package brute_force.silver_solution
//6
//1 0 2 3 3 4
//1 1 1 1 1 1
//0 0 1 1 1 1
//3 9 9 0 1 99
//9 11 3 1 0 3
//12 3 0 0 0 1

//package jimin.`11week`
//
//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.lang.Integer.min
//
//var min = Int.MAX_VALUE
//var n: Int = 0
//val ground = mutableListOf<MutableList<Int>>()
//val visited = mutableListOf<MutableList<Boolean>>()
//val direction = listOf(
//    Pair(-1, 0),
//    Pair(0, 0),
//    Pair(1, 0),
//    Pair(0, -1),
//    Pair(0, 1)
//)
//
//fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
//    n = readLine().toInt()
//    repeat(n) {
//        ground.add(readLine().split(" ").map { it.toInt() }.toMutableList())
//        visited.add(MutableList(n) { false })
//    }
//
//    dfs(0, 0)
//    println(min)
//}
//
//fun dfs(num: Int, sum: Int) {
//    if (num == 3) {
//        min = min(min, sum)
//        return@dfs
//    }
//
//    for (i in 1 until n - 1) {
//        for (j in 1 until n - 1) {
//            val checked = checkGround(i, j)
//            if (checked.first) {
//                visitGround(i, j, true)
//                //println("$i,$j $num $sum")
//                dfs(num + 1, sum + checked.second)
//                visitGround(i, j, false)
//            }
//        }
//    }
//}
//
//fun checkGround(x: Int, y: Int): Pair<Boolean, Int> {
//    var price = 0
//    direction.forEach {
//        if (visited[x + it.first][y + it.second]) {
//            return Pair(false, 0)
//        }
//        price += ground[x + it.first][y + it.second]
//    }
//    return Pair(true, price)
//}
//
//fun visitGround(x: Int, y:Int, boolean: Boolean){
//    direction.forEach{
//        visited[x + it.first][y + it.second] = boolean
//    }
//}
fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val board = Array(n){br.readLine().split(" ").map { it.toInt() }}
    val state = Array(n){BooleanArray(n)}
    val dx = listOf(1,0,-1,0,0)
    val dy = listOf(0,1,0,-1,0)
    fun check(x:Int,y:Int,state:Array<BooleanArray>):Boolean{
        for (k in 0..4){
            val nx = x+dx[k]
            val ny = y+dy[k]
            if (nx <0 || ny <0 || nx >= n || ny >= n) return false
            if (state[nx][ny]) return false
        }
        return true
    }
    var answer = Int.MAX_VALUE
    fun dfs(depth:Int,totalSum:Int){
        if (depth == 3){
            answer =  minOf(totalSum,answer)
            return
        }
        for (i in board.indices){
            for (j in board[i].indices){
                if (state[i][j]) continue
                if(check(i,j,state)){
                    var sum = 0
                    for (k in 0..4){
                        val nx = i+dx[k]
                        val ny = j+dy[k]
                        sum += board[nx][ny]
                        state[nx][ny] = true
                    }
                    dfs(depth+1,sum+totalSum)
                    for (k in 0..4){
                        val nx = i+dx[k]
                        val ny = j+dy[k]
                        state[nx][ny] = false
                    }
                }
            }
        }
    }
    dfs(0,0)
    println(answer)
}

