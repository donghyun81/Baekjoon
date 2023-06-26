package gold


//fun main() {
//    val br = System.`in`.bufferedReader()
//    val (row, colum) = br.readLine().split(" ").map { it.toInt() }
//    val frame = List(row) { MutableList(colum) { 0 } }
//    val floor =  br.readLine().split(" ").map { it.toInt() }
//    var maxFloor = 0
//    var count = 0
//    for (i in 0 until colum){
//       var count = 0
//        for (j in 0 until  floor[i] ) {
//            count++
//            frame[j][i] = count
//        }
//    }
//    for (i in 0 until colum){
//        if (maxFloor !=0 && maxFloor<=floor[i])
//        {
//            for (j in 0 until floor[i]){
//                for (k in 0..i){
//                    if(frame[j][k] == 0 ) count++
//                }
//            }
//        }
//        maxFloor = maxOf(floor[i],maxFloor)
//    }
//    for (i in frame) println(i)
//    println(count)
//}

//import kotlin.math.max
//
fun main() {
    val (h: Int, w: Int) = readLine()!!.split(" ").map { it.toInt() }
    val wall = readLine()!!.split(" ").map { it.toInt() }.toList()

    // Numpy 없이 argmax
    fun argmax(a: List<Int>): Int = a.indices.maxBy { a[it] }!!

    val maxIdx = argmax(wall)
    var sol = 0
    var tmpMax = 0

    // 가장 높은 벽 기준 왼쪽부터 벽+채울 수 있는 물 합한 면적 더하기
    for (i in 0..maxIdx) {
        tmpMax = maxOf(tmpMax, wall[i])
        println(tmpMax)
        sol += tmpMax
    }
    tmpMax = 0
    println()
    // 가장 높은 벽 기준 오른쪽부터 벽+채울 수 있는 물 합한 면적 더하기
    for (i in w - 1 downTo maxIdx + 1) {
        tmpMax = maxOf(tmpMax, wall[i])
        println(tmpMax)
        sol += tmpMax
    }
    //벽이 차지하는 면적 빼주면 정답
    println(sol - wall.sum())
}

//fun main(){
//    val br = System.`in`.bufferedReader()
//    val (n,m) = br.readLine().split(" ").map { it.toInt() }
//    val nums = br.readLine().split(" ").map { it.toInt() }
//    var max = 0
//
//    for (i in nums.indices){
//
//    }
//}
