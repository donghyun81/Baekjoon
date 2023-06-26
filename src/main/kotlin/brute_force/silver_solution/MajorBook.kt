package brute_force.silver_solution

import java.util.Scanner
import kotlin.math.min
//ANT
//4
//35000 COMPUTERARCHITECTURE
//47000 ALGORITHM
//43000 NETWORK
//40000 OPERATINGSYSTEM
import java.util.*

//fun main() {
//    val input = Scanner(System.`in`)
//    val t = input.next()
//    val n = input.nextInt()
//    val tChar = IntArray(26)
//    val selectedChar = IntArray(26)
//    val book = Array(n) { Pair(0, "") }
//    var result = 987654321
//
//    for (i in t.indices) {
//        tChar[t[i] - 'A']++
//    }
//    for (i in 0 until n) {
//        book[i] = Pair(input.nextInt(), input.next())
//    }
//
//    fun check(): Boolean {
//        for (i in 0 until 26) {
//            if (tChar[i] > selectedChar[i]) {
//                return false
//            }
//        }
//        return true
//    }
//
//    fun combination(cnt: Int, priceSum: Int) {
//        if (cnt == n) {
//            if (check()) {
//                result = minOf(result, priceSum)
//            }
//            return
//        }
//        for (i in 0 until book[cnt].second.length) {
//            selectedChar[book[cnt].second[i] - 'A']++
//        }
//        combination(cnt + 1, priceSum + book[cnt].first)
//        for (i in 0 until book[cnt].second.length) {
//            selectedChar[book[cnt].second[i] - 'A']--
//        }
//        combination(cnt + 1, priceSum)
//    }
//
//    combination(0, 0)
//    if (result == 987654321) {
//        println(-1)
//    } else {
//        println(result)
//    }
//}

//ANT
//4
//35000 COMPUTERARCHITECTURE
//47000 ALGORITHM
//43000 NETWORK
//40000 OPERATINGSYSTEM

fun main(){
    MajorBook().solution()
}

class MajorBook {
    var alphabetCnt = IntArray(26)
    lateinit var books : Array<List<String>>
    var answer = Int.MAX_VALUE
    var bookCnt = 0
    fun solution(){
        val br = System.`in`.bufferedReader()
        val target = br.readLine()
        bookCnt = br.readLine().toInt()
        val visited = BooleanArray(bookCnt)
        books = Array(bookCnt){br.readLine().split(" ")}
        for (i in target){
            alphabetCnt[i-'A']--
        }
        dfs(0,0)
        if(answer == Int.MAX_VALUE) println(-1) else println(answer)

    }

    fun dfs(cur:Int,price:Int){
        if (cur==bookCnt) {
            if(alphabetCnt.all { it>=0 }){
                answer = minOf(answer,price)
            }
            return
        }
        for (i in books[cur][1]){
            alphabetCnt[i-'A'] ++
        }
        dfs(cur+1,price+books[cur][0].toInt())
        for (i in books[cur][1]){
            alphabetCnt[i-'A'] --
        }
        dfs(cur+1,price)
    }
}