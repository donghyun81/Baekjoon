package silver

import java.lang.Math.pow
import java.util.*
import kotlin.math.pow


fun main() {
    SharkElementarySchool().solution()
}

//3
//4 2 5 1 7
//3 1 9 4 5
//9 8 1 2 3
//8 1 9 3 4
//7 2 3 4 8
//1 9 2 5 7
//6 5 2 3 4
//5 1 9 2 8
//2 9 3 1 4
data class PlaceInfo(val likeCnt: Int, val emptyCnt: Int, val x: Int, val y: Int)
class SharkElementarySchool {
    lateinit var student: MutableMap<Int, List<Int>>
    lateinit var place: Array<IntArray>
    var n = 0
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    var answer = 0
    fun solution() {
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        place = Array(n) { IntArray(n) }
        student = mutableMapOf()
        repeat(n * n) {
            val studentInfo = br.readLine().split(" ").map { it.toInt() }
            student[studentInfo[0]] = studentInfo.subList(1, 5)
        }
        student.keys.forEach {
            searchPlace(it)
        }
        getAnswer()
        println(answer)
    }
    fun getAnswer(){
        for (x in 0 until n)
            for (y in 0 until n){
                var likeCnt = 0
                for (i in 0..3){
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue
                    if (student[place[x][y]]!!.contains(place[nx][ny])) likeCnt++
                }
                answer += if (likeCnt >= 1) 10.0.pow(likeCnt.toDouble() - 1).toInt() else 0
            }
    }

    fun searchPlace(studentNum: Int) {
        val favoriteStudents = student[studentNum] ?: emptyList()
        val comparator = compareBy<PlaceInfo> { it.likeCnt }.thenBy { it.emptyCnt }.thenByDescending { it.x }
            .thenByDescending { it.y }
        val placesInfo = mutableListOf<PlaceInfo>()
        for (x in 0 until n) {
            for (y in 0 until n) {
                if (place[x][y] != 0) continue
                    var likeCnt = 0
                    var emptyCnt = 0
                    for (i in 0..3) {
                        val nx = x + dx[i]
                        val ny = y + dy[i]
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue
                        if (place[nx][ny] == 0) emptyCnt++
                        if (favoriteStudents.contains(place[nx][ny])) likeCnt++
                    }
                    placesInfo.add(PlaceInfo(likeCnt, emptyCnt, x, y))
                }
            }
            val (likeCnt, _, x, y) = placesInfo.sortedWith(comparator).last()
            place[x][y] = studentNum
        }
    }
