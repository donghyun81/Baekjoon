package gold

import java.lang.Math.abs
import java.util.LinkedList

//2 20 50 땅n*n 조건 L R
//50 30
//20 40

// 실행 목록
//국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
//위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
//국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
//연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
//연합을 해체하고, 모든 국경선을 닫는다.
// 답: 인구 이동 기간(횟수)

import java.util.*

fun main() {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    val (n, l, r) = readLine()!!.split(" ").map { it.toInt() }
    val a = Array(n) { IntArray(n) }
    repeat(n) { i ->
        val row = readLine()!!.split(" ").map { it.toInt() }
        repeat(n) { j ->
            a[i][j] = row[j]
        }
    }
    var ans = 0
    fun valid(y: Int, x: Int) = y in 0 until n && x in 0 until n

    fun bfs(): Boolean {
        var flag = false // 연결되는부분이 있는지
        val vis = Array(n) { BooleanArray(n) } //방문 날마다 리셋
        val comp = mutableListOf<List<Pair<Int, Int>>>() //인접 국가들 좌표
        val compPop = mutableListOf<Int>()
        val q: Queue<Pair<Int, Int>> = LinkedList()
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (vis[i][j]) continue
                val cur = mutableListOf<Pair<Int, Int>>()
                var sum = 0
                q.offer(i to j)
                vis[i][j] = true
                while (q.isNotEmpty()) {
                    val (y, x) = q.poll()
                    sum += a[y][x]
                    cur.add(y to x)
                    for (k in 0 until 4) {
                        val ny = y + dy[k]
                        val nx = x + dx[k]
                        if (!valid(ny, nx) || vis[ny][nx]) continue
                        val diff = abs(a[y][x] - a[ny][nx])
                        if (diff > r || diff < l) continue
                        flag = true
                        vis[ny][nx] = true
                        q.offer(ny to nx)
                    }
                }
                comp.add(cur)
                compPop.add(sum)
            }
        }
        if (!flag) return false
        for (i in comp.indices) {
            println(comp[i])
            val pop = compPop[i] / comp[i].size
            for ((y, x) in comp[i]) a[y][x] = pop
        }
        return true
    }
    while (bfs()) ans++
    println(ans)
}

//fun main() {
//    val br = System.`in`.bufferedReader()
//    val (frame, minPopulationGap, maxPopulationGap) = br.readLine().split(" ").map { it.toInt() }
//    val countries = Array(frame) { br.readLine().split(" ").map { Country(it.toInt()) }.toMutableList() }
//    var answer = 0
//    val dx = listOf(1, 0, -1, 0)
//    val dy = listOf(0, 1, 0, -1)
//    fun isFrameIn(nx: Int, ny: Int) = nx >= 0 && ny >= 0 && nx < frame && ny < frame
//    fun isUnite(country: Country, otherCountry: Country): Boolean {
//        val gap = maxOf(country.population, otherCountry.population) - minOf(
//            country.population,
//            otherCountry.population
//        )
//        return gap in minPopulationGap..maxPopulationGap
//    }
//
//
//    fun bfs():Boolean {
//        var flag = false
//        val q = LinkedList<Pair<Int, Int>>()
//        val visited = Array(frame){BooleanArray(frame)}
//        val comp = mutableListOf<MutableList<Pair<Int,Int>>>()
//        val compSum = mutableListOf<Int>()
//        for(i in 0 until frame){
//            for (j in 0 until frame){
//                if (visited[i][j]) continue
//                q.offer(Pair(i,j))
//                var cur = mutableListOf<Pair<Int,Int>>()
//                var sum = 0
//                while (q.isNotEmpty()) {
//                    val (y, x) = q.poll()
//                        for (d in 0..3) {
//                            val nx = x + dx[d]
//                            val ny = y + dy[d]
//                            sum += countries[y][x].population
//                            if (!isFrameIn(nx, ny)) continue
//                            if (!isUnite(countries[y][x],countries[ny][nx])||visited[ny][nx]) continue
//                            cur.add(Pair(ny,nx))
//                            visited[ny][nx] = true
//                            flag = true
//                        }
//                }
//                comp.add(cur)
//                compSum.add(sum)
//            }
//        }
//        if (!flag) return false
//        for (i in comp.indices){
//            val people = compSum[i].div(comp[i].size)
//            for ((y,x) in comp[i]) countries[y][x] = Country(people)
//        }
//        return true
//    }
//    while(bfs()) answer++
//    println(answer)
//}
//
//data class Country(val population: Int)
//
//2 20 50 n*n , 최소 인원 ,최대 인원
//50 30
//20 40
