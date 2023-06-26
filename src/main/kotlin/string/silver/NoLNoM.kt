package silver

//3 4
//ohhenrie
//charlie
//baesangwook
//obama
//baesangwook
//ohhenrie
//clinton

fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val strs = HashSet<String>()
    val strss = ArrayList<String>()

    repeat(n) {
        strs.add(br.readLine())
    }
    println(strs)
    var answer = 0
    var str = ""
    repeat(m) {
        str = br.readLine()
        if (strs.contains(str)) {
            strss.add(str)
            answer++
        }
    }

    strss.sort()

    val sb = StringBuilder()
    sb.append(answer).append("\n")
    for (s in strss) {
        sb.append(s).append("\n")
    }
    print(sb)
}
