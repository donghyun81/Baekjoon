package silver

fun main(){
    val br = System.`in`.bufferedReader()
    val (n,k) = br.readLine().split(" ").map { it.toInt() }
    val nums = MutableList(n){it+1}
    val answers= mutableListOf<Int>()
    var start = 0
    for (i in nums.indices){
        start = (k+start-1)%(nums.size)
        answers.add(nums.removeAt(start))
    }
    println(answers)
}