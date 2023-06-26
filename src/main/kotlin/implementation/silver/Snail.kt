package silver


//fun main() {
//    val dr = intArrayOf(0, 1, 0, -1)
//    val dc = intArrayOf(1, 0, -1, 0)
//
//    var map = Array(35) { IntArray(35) }
//    var p = Pair(0, 0)
//
//    val n = readLine()!!.toInt()
//    val x = readLine()!!.toInt()
//
//    val rotateCnt = n / 2 // 회오리 수
//
//    var num = 1
//    map[n / 2][n / 2] = num //시작
//
//    var startR = n / 2 - 1 //시작 행
//    var startC = n / 2 - 1 // 시작 열
//    for (i in 1..rotateCnt) {
//        var r = startR //행
//        var c = startC //열
//        var d = 0
//        while (d < 4) { //방향
//            val nr = r + dr[d] // 오른쪽,왼쪽 2+1
//            val nc = c + dc[d] // 위,아래
//            if ((n / 2 - i <= nr && nr <= n / 2 + i) && (n / 2 - i <= nc && nc <= n / 2 + i)) {
//                num += 1
//                map[nr][nc] = num
//                if (num == x) {
//                    p = Pair(nr + 1, nc + 1)
//                }
//                r = nr // 다음 칸 전진
//                c = nc
//
//            } else { // 범위 넘어갔으니 방향 바꿔야 함
//                d++
//            }
//
//        }
//
//        // 시작점 바꾸기 -1, -1
//        startR -= 1
//        startC -= 1
//        for (i in 0 until n) {
//            for (j in 0 until n) {
//                print("${map[i][j]} ")
//            }
//            println()
//        }
//        println(map[r][c])
//        println(c)
//
//    }
//
//    for (i in 0 until n) {
//        for (j in 0 until n) {
//            print("${map[i][j]} ")
//        }
//        println()
//    }
//    println("${p.first} ${p.second}")
//}

//7 n*n 범위
//35 타겟 좌표 수
//fun main() {
//    val br = System.`in`.bufferedReader()
//    val frameNumber = br.readLine().toInt()
//    val targetNumber = br.readLine().toInt()
//    val snail = Array(frameNumber) { Array(frameNumber) { 1 } }
//    val dx = listOf(1, 0, -1, 0)
//    val dy = listOf(0, 1, 0, -1)
//    val rotateCnt = frameNumber / 2
//    var startX = frameNumber / 2 -1
//    var startY = frameNumber / 2 -1
//    var number = 1
//    var targetIndex = Pair(0, 0)
//    for(i in 1..rotateCnt){
//        var direction = 0
//        var x = startX
//        var y = startY
//        while (direction < 4) {
//            val nx = x +dx[direction]
//            val ny = y+dy[direction]
//            if ((frameNumber / 2 - i <= nx && nx <= frameNumber / 2 + i) && (frameNumber / 2 - i <= ny && ny <= frameNumber / 2 + i)) {
//                number++
//                snail[ny][nx] = number
//                if (number==targetNumber) targetIndex=Pair(y+1,x+1)
//                x = nx
//                y = ny
//            }else direction++
//        }
//        startY--
//        startX--
//    }
//    for (i in snail) println(i.toList())
//}

fun main(){
    Snail().solution()

}
class Snail(){
    var frame:Int
    var targetNum:Int
    init {
        val br =System.`in`.bufferedReader()
        frame = br.readLine().toInt()
        targetNum = br.readLine().toInt()
    }
    fun solution(){
        val graph = Array(frame){IntArray(frame)}
        var first = frame/2
        var num = 1
        graph[first][first] = num
        var line = 0
        while (first >0){
            first--
            line +=2
            var  x = first
            var  y = first
            for (i in 1 ..line){
                num++
                y++
                graph[x][y] = num
            }
            for (i in 1 ..line){
                num++
                x++
                graph[x][y] = num
            }
            for (i in 1 ..line){
                num++
                y--
                graph[x][y] = num
            }
            for (i in 1 ..line){
                num++
                x--
                graph[x][y] = num
            }
            println(num)
        }
        for (i in graph) println(i.toList())
    }
}
