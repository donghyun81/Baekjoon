package silver

import kotlin.math.abs

val qwerty = arrayOf("qwertyuiop", "asdfghjkl", "zxcvbnm")
val onlyLeft = "qwertasdfgzxcv"
val X = IntArray(33)
val Y = IntArray(33)

fun isLeft(x: Char) = onlyLeft.contains(x)
fun dist(a: Char, b: Char) = abs(Y[a - 'a'] - Y[b - 'a']) + abs(X[a - 'a'] - X[b - 'a'])

fun main() {
    for (i in 0 until 3) {
        for (j in qwerty[i].indices) {
            Y[qwerty[i][j] - 'a'] = i
            X[qwerty[i][j] - 'a'] = j
        }
    }
    println(X.toList())
    println(Y.toList())

    var (L, R) = readLine()!!.split(" ")
    var word = readLine()!!

    var answer = 0
    for (w in word) {
        if (isLeft(w)) {
            answer += dist(L[0], w) + 1
            L = w.toString()
        } else {
            answer += dist(R[0], w) + 1
            R = w.toString()
        }
        println(answer)
    }
    println(answer)
}