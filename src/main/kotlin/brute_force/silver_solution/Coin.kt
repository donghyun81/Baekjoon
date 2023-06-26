package brute_force.silver_solution

import java.util.*

fun findArr(arr: Array<IntArray>) {
    var result = Int.MAX_VALUE
    for (bitMask in 0 until (1 shl 8)) {
        val copyArr = Array(3) { arr[it].copyOf() }
        val changeBit = Integer.bitCount(bitMask)
        if (result < changeBit) {
            continue
        }
        for (row in 0 until 3) {
            if (bitMask and (1 shl row) != 0) {
                for (col in 0 until 3) {
                    copyArr[row][col] = (copyArr[row][col] + 1) % 2
                }
            }
        }
        for (col in 0 until 3) {
            if (bitMask and (1 shl (col + 3)) != 0) {
                for (row in 0 until 3) {
                    copyArr[row][col] = (copyArr[row][col] + 1) % 2
                }
            }
        }
        if (bitMask and (1 shl 6) != 0) {
            for (row in 0 until 3) {
                copyArr[row][row] = (copyArr[row][row] + 1) % 2
            }
        }
        if (bitMask and (1 shl 7) != 0) {
            for (row in 0 until 3) {
                copyArr[row][2 - row] = (copyArr[row][2 - row] + 1) % 2
            }
        }
        val sumTemp = copyArr.map { it.sum() }.sum()
        if (sumTemp == 9 || sumTemp == 0) {
            result = changeBit
        }
    }
    println(if (result == Int.MAX_VALUE) -1 else result)
}

fun main() {
    val T = readLine()!!.toInt()

    repeat(T) {
        val arr = Array(3) { IntArray(3) }
        var result = Int.MAX_VALUE
        for (i in 0 until 3) {
            val s = readLine()!!.split(" ")
            for (j in 0 until 3) {
                if (s[j] == "T") {
                    arr[i][j] = 1
                } else {
                    arr[i][j] = 0
                }
            }
        }
        findArr(arr)
    }
}


