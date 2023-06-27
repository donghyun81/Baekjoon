package data_structure.silver

fun main(){
    PerfectTree().solution()
}

class PerfectTree {
    var cnt = 0
    lateinit var nums :IntArray
    lateinit var tree:Array<ArrayList<Int>>
    fun solution(){
        val br = System.`in`.bufferedReader()
        cnt = br.readLine().toInt()
        nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        tree = Array(cnt){ arrayListOf()}
        dfs(0,nums.size,0)
        for (i in tree.indices){
            for (j in tree[i].indices){
                print("${tree[i][j]} ")
            }
            println()
        }

    }
    fun dfs(start:Int,end:Int,depth:Int){
        if (start >= end){
            return
        }
        val mid = (start+end)/2
        tree[depth].add(nums[mid])
        dfs(start,mid,depth+1)
        dfs(mid+1,end,depth+1)

    }
}

//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//import java.lang.StringBuilder
//
//fun main() {
//    val reader = BufferedReader(InputStreamReader(System.`in`))
//    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
//
//    val k = reader.readLine().toInt()
//    val tree = ArrayList<ArrayList<Int>>()
//
//    for (i in 0 until k) {
//        tree.add(ArrayList())
//    }
//
//    val numbers = reader.readLine().split(" ").map { it.toInt() }
//    divideAndConquer(numbers, tree, 0, numbers.size, 0)
//
//    val stringBuilder = StringBuilder()
//    for (nodes in tree) {
//        for (node in nodes) {
//            stringBuilder.append(node).append(" ")
//        }
//        stringBuilder.append("\n")
//    }
//
//    writer.write(stringBuilder.toString())
//    writer.flush()
//    writer.close()
//    reader.close()
//}
//
//fun divideAndConquer(numbers: List<Int>, tree: ArrayList<ArrayList<Int>>, start: Int, end: Int, depth: Int) {
//    if (start >= end) {
//        return
//    }
//
//    val mid = (start + end) / 2
//    tree[depth].add(numbers[mid])
//
//    divideAndConquer(numbers, tree, start, mid, depth + 1)
//    divideAndConquer(numbers, tree, mid + 1, end, depth + 1)
//}