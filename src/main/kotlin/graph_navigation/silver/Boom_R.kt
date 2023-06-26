package silver


//6 7 3 가로 세로 상태 시간
//.......
//...O...
//....O..
//.......
//OO.....
//OO.....
//fun main() {
//    val br = System.`in`.bufferedReader()
//    val (y, x, time) = br.readLine().split(" ").map { it.toInt() }
//    val state = Array(y) { br.readLine().toMutableList() }
//    val dx = listOf(1, 0, -1, 0)
//    val dy = listOf(0, 1, 0, -1)
//    fun isFrameIn(ny: Int, nx: Int) = ny >= 0 && nx >= 0 && ny < y && nx < x
//    fun bfs(x: Int, y: Int) {
//        val q = LinkedList<Pair<Int, Int>>()
//        q.offer(Pair(y,x))
//        while (q.isNotEmpty()){
//            val (y,x) = q.poll()
//            for (dir in 0..3){
//                val ny = y + dy[dir]
//                val nx = x + dx[dir]
//                if (!isFrameIn(ny, nx)) continue
//                state[ny][nx] = '.'
//            }
//        }
//    }
//
//    for(i in 1..time){
//        for(j in)
//
//    }
//}

fun main() {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val br = System.`in`.bufferedReader()
    val (r, c, n) = br.readLine().split(" ").map { it.toInt() }
    val state = Array(r) { br.readLine() }
    val fireTime = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (state[i][j] == 'O') fireTime[i][j] = 3
        }
    }
    for (t in 2..n) {
        if (t % 2 == 1) fire(fireTime, state, r, c, dx, dy, t)
        else setAll(fireTime, state, r, c, t)
    }
    for (i in 0 until r) {
        println(state[i])
    }
    for (i in 0 until r) {
        println(fireTime[i].toList())
    }
}

fun valid(x: Int, y: Int, r: Int, c: Int): Boolean {
    return x in 0 until r && y in 0 until c
}

fun fire(fireTime: Array<IntArray>, a: Array<String>, r: Int, c: Int, dx: IntArray, dy: IntArray, t: Int) {
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (fireTime[i][j] != t) continue
            for (k in 0..3) {
                val nx = i + dx[k]
                val ny = j + dy[k]
                if (!valid(nx, ny, r, c)) continue
                if (fireTime[nx][ny] == t) continue
                fireTime[nx][ny] = 0
                val arr = a[nx].toCharArray()
                arr[ny] = '.'
                a[nx] = String(arr)
            }
            fireTime[i][j] = 0
            val arr = a[i].toCharArray()
            arr[j] = '.'
            a[i] = String(arr)
        }
    }
}

fun setAll(fireTime: Array<IntArray>, a: Array<String>, r: Int, c: Int, t: Int) {
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (a[i][j] == 'O') continue
            val arr = a[i].toCharArray()
            arr[j] = 'O'
            a[i] = String(arr)
            fireTime[i][j] = t + 3
        }
    }
}
