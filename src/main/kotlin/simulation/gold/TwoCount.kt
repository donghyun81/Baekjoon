package gold



//import java.util.*
//
//const val MAX = 101
//
//var R = 0
//var C = 0
//var K = 0
//var Answer = 0
//val MAP = Array(MAX) { IntArray(MAX) }
//val Number_Cnt = IntArray(MAX)
//
//fun Input() {
//    val reader = Scanner(System.`in`)
//    R = reader.nextInt()
//    C = reader.nextInt()
//    K = reader.nextInt()
//    for (i in 1..3) {
//        for (j in 1..3) {
//            MAP[i][j] = reader.nextInt()
//        }
//    }
//}
//
//fun Print() {
//    for (i in 1 until 50) {
//        for (j in 1 until 50) {
//            print("${MAP[i][j]} ")
//        }
//        println()
//    }
//    println("########################################")
//}
//
//fun Find() {
//    var Time = 0
//    var Hang = 3
//    var Yul = 3
//
//    while (true) {
//        if (MAP[R][C] == K) {
//            Answer = Time
//            break
//        }
//        if (Time > 100) {
//            Answer = -1
//            break
//        }
//
//        val Size = ArrayList<Int>()
//        if (Hang >= Yul) {
//            for (i in 1..Hang) {
//                val V = ArrayList<Pair<Int, Int>>()
//                Number_Cnt.fill(0)
//                for (j in 1..Yul) Number_Cnt[MAP[i][j]]++
//                for (j in 1 until MAX) {
//                    if (Number_Cnt[j] == 0) continue
//                    V.add(Number_Cnt[j] to j)
//                }
//                V.sortBy { it.first }
//                MAP[i].fill(0)
//                var Idx = 1
//                for (j in V.indices) {
//                    MAP[i][Idx++] = V[j].second
//                    MAP[i][Idx++] = V[j].first
//                }
//                Idx--
//                Size.add(Idx)
//            }
//            Size.sort()
//            Yul = Size.last()
//        } else {
//            for (i in 1..Yul) {
//                val V = ArrayList<Pair<Int, Int>>()
//                Number_Cnt.fill(0)
//                for (j in 1..Hang) Number_Cnt[MAP[j][i]]++
//                for (j in 1 until MAX) {
//                    if (Number_Cnt[j] != 0) {
//                        V.add(Number_Cnt[j] to j)
//                    }
//                }
//                V.sortBy { it.first }
//                for (j in 1..Hang) MAP[j][i] = 0
//                var Idx = 1
//                for (j in V.indices) {
//                    MAP[Idx++][i] = V[j].second
//                    MAP[Idx++][i] = V[j].first
//                }
//                Idx--
//                Size.add(Idx)
//            }
//            Size.sort()
//            Hang = Size.last()
//        }
//        Time++
//    }
//}
//
//fun Solution() {
//    if (MAP[R][C] == K) {
//        Answer = 0
//        println(Answer)
//        return
//    }
//    Find()
//    println(Answer)
//}
//
//fun main(args: Array<String>) {
//    // System.setIn(FileInputStream("Input.txt"))
//    Input()
//    Solution()
//}


fun main(){
    TwoCount().solution()

}

//1 2 2
//1 2 1
//2 1 3
//3 3 3
class TwoCount {
    private val graph = Array(MAX_IDX){IntArray(MAX_IDX)}
    private var columnMax = 2
    private var rowMax = 2
    fun solution(){
        val br = System.`in`.bufferedReader()
        val (targetX,targetY,targetNum) = br.readLine().split(" ").map { it.toInt() }
       for (x in 0..2){
           val numbers = br.readLine().split(" ").map { it.toInt() }
           numbers.forEachIndexed { idx,num -> graph[x][idx] = num }
        }
        for(i in 0..99){
            if(graph[targetX-1][targetY-1] == targetNum){
                println(i)
                return
            }
            if(columnMax <= rowMax) columnCount(columnMax,rowMax)
            else rowCount(columnMax,rowMax)
        }
        if(graph[targetX-1][targetY-1] == targetNum) println(100) else println(-1)
    }
    fun columnCount(column:Int,row:Int){
        for (y in 0 .. row){
            val temp = mutableListOf<Int>()
            for (x in 0 .. column){
                if (graph[y][x] ==0) continue
                temp.add(graph[y][x])
                graph[y][x] = 0
            }
            val eachCount = temp.groupingBy{it}.eachCount().entries.sortedWith(compareBy({it.value},{it.key}))
            var x =0
            for (i in eachCount){
                if (x > 99) break
                val(key,value) = i
                graph[y][x] = key
                graph[y][x+1] = value
                x+=2
            }
            columnMax = maxOf(columnMax,eachCount.size*2-1)
        }
    }

    fun rowCount(column:Int,row:Int){
       for (x in 0 .. column){
           val temp = mutableListOf<Int>()
           for (y in 0.. row){
               if (graph[y][x]==0 ) continue
               temp.add(graph[y][x])
               graph[y][x] = 0
           }
           val eachCount = temp.groupingBy{it}.eachCount().entries.sortedWith(compareBy({it.value},{it.key}))
           var y = 0
           for (i in eachCount){
               if (y>99) break
               val(num,cnt) = i
               graph[y][x] = num
               graph[y+1][x] = cnt
               y+=2
           }
           rowMax = maxOf(rowMax,eachCount.size*2-1)
       }
    }
    companion object{
        val MAX_IDX = 100
    }
}