package silver


fun main() {
    val br = System.`in`.bufferedReader()
    val (n,k) = br.readLine().split(" ").map { it.toInt() }
    val s = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    var d = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    var result = Array(n){ 0 }
    repeat(k){
        val copy = deepCopy(s)
        for (i in d.indices){
            s[d[i]-1] = copy[i]
        }
    }
    println(s.toList())
}

fun deepCopy(target : Array<Int>) : Array<Int>{
    val answer = Array(target.size){0}
    for (i in target.indices){
        answer[i] = target[i]
    }
    return answer
}

