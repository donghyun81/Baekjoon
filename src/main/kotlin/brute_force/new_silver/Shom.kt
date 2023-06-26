package brute_force.new_silver


//5
//4 8 13 24 30
//10
import java.util.*

fun main(){
    val a = intArrayOf(1,3,5,3,27,4,3,8,6,2,1)
    mergeSort(a,0,a.size-1)
    println(a.toList())
}
fun mergeSort(A: IntArray, p: Int, r: Int) {
    if (p < r) {
        val q = (p + r) / 2
        mergeSort(A, p, q)
        mergeSort(A, q + 1, r)
        merge(A, p, q, r)
    }
}

fun merge(A: IntArray, p: Int, q: Int, r: Int) {
    val tmp = IntArray(r - p + 1)
    var i = p
    var j = q + 1
    var t = 0

    while (i <= q && j <= r) {
        if (A[i] <= A[j]) {
            tmp[t++] = A[i++]
        } else {
            tmp[t++] = A[j++]
        }
    }

    while (i <= q) {
        tmp[t++] = A[i++]
    }

    while (j <= r) {
        tmp[t++] = A[j++]
    }

    i = p
    t = 0
    while (i <= r) {
        A[i++] = tmp[t++]
    }
}


//fun main() {
//    val br = System.`in`.bufferedReader()
//    val cnt = br.readLine().toInt()
//    val s = br.readLine().split(" ").map { it.toInt() }
//    val n = br.readLine().toInt()
//    var cntA = 0
//    var cntB = 0
//    for (i in s.indices) {
//        if (s.contains(i)) break
//        else cntA++
//    }
//    println(cntA)
//    println(cntB)
//    val answer = cntA * cntB -1
//    if (answer <0) println(0) else println(answer)
//}




