package gold


import java.util.*

fun main(){
    DragonCurb().solution()

}
class DragonCurb(){

    var endX = 0
    var endY = 0
    lateinit var map:Array<BooleanArray>
    val dx = listOf(0,-1,0,1)
    val dy = listOf(1,0,-1,0)
    val stack = Stack<Int>()

    fun solution(){
        val br = System.`in`.bufferedReader()
        var cnt = 0
        map = Array(101){ BooleanArray(101) }
        repeat(br.readLine().toInt()){
            val (y,x,d,g) = br.readLine().split(" ").map { it.toInt() }
            stack.clear()
            stack.add(d)
            map[x][y] = true
            endX = x+dx[d]
            endY = y+dy[d]
            map[endX][endY] = true
            for (i in 0 until g){
                val size = stack.size
                for (i in size-1 downTo 0){
                    val direction = (stack[i]+1)%4
                    endX += dx[direction]
                    endY += dy[direction]
                    map[endX][endY] = true
                    stack.add(direction)
                }
            }
        }
        for (x in 0 until 101)
            for (y in 0 until 101)
                if (map[x][y] && map[x+1][y] &&map[x+1][y+1]&& map[x][y+1]) cnt++

        println(cnt)

    }
}


//
//const val maxInt = 101
//
//var n = 0
//var x = 0
//var y = 0
//var d = 0
//var g = 0
//var result = 0
//
//// 끝점의 정보
//var endX = 0
//var endY = 0
//
//val map = Array(maxInt) { BooleanArray(maxInt) }
//
//// 왼쪽, 위쪽, 오른쪽, 아래쪽
//val dx = intArrayOf(0, -1, 0, 1)
//val dy = intArrayOf(1, 0, -1, 0)
//
//// 이전 세대의 방향정보를 저장하는 스택
//val dragon = Stack<Int>()
//
//// 스택을 조사하면서 드래곤 커브를 만드는 함수
//fun makeGeneration(dragon: Stack<Int>) {
//    // 현재 스택의 크기를 먼저 계산해 놓는다.
//    val size = dragon.size
//    println(size)
//    // 스택의 뒤에서부터 꺼내면서
//    // 다음 세대의 방향정보를 dir = (dragon[i] + 1) % 4; 규칙에 따라 생성한다.
//    for (i in size - 1 downTo 0) {
//        val dir = (dragon[i] + 1) % 4
//
//        // 다음 세대의 방향정보를 바탕으로 다음 x, y를 찾고 이를 갱신한다.
//        endX += dx[dir]
//        endY += dy[dir]
//
//        // 만들어진 드래곤 커브를 지도에 놓아준다.
//        map[endX][endY] = true
//
//        // 다음 세대를 위한 스택에 방향정보를 넣어준다.
//        dragon.push(dir)
//    }
//}
//
//fun main() {
//    val scanner = Scanner(System.`in`)
//    n = scanner.nextInt()
//
//    for (i in 0 until n) {
//        // x, y의 순서를 바꿔서 입력받는다.
//        y = scanner.nextInt()
//        x = scanner.nextInt()
//        d = scanner.nextInt()
//        g = scanner.nextInt()
//
//        // 기존 드래곤 커브의 스택을 비워준다.
//        dragon.clear()
//
//        // 시작점에 드래곤 커브가 놓여있으므로 지도에 표시해준다.
//        map[x][y] = true
//
//        // 0세대는 미리 만들어 놓는다.
//        endX = x + dx[d]
//        endY = y + dy[d]
//
//        // 0세대를 만든 이후에도 지도에 표시해준다.
//        map[endX][endY] = true
//
//        // 0세대의 방향정보를 스택에 넣어준다.
//        dragon.push(d)
//        for (i in 0 until g) {
//            // 드래곤 커브를 만든다.
//            makeGeneration(dragon)
//            println()
//        }
//    }
//    // 100*100 2차원 행렬을 2중 for문을 사용한 단순한 탐색
//    // 인접한 4칸이 모두 true이면, 4칸이 모두 드래곤 커브의 일부인 것
//    // 개수를 1 증가시킨다.
//    for (i in 0 until maxInt - 1) {
//        for (j in 0 until maxInt - 1) {
//            // 인접한 4칸의 정사각형이 모두 드래곤의 일부이면
//            if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
//                // 개수를 1 증가시킨다.
//                result++
//            }
//        }
//    }
//
//    // 개수 출력
//    println(result)
//}
// 반복문을 통해 0부터 차례차례 드래곤 커브를 만들면서 g세대
