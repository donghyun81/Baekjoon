package brute_force.silver_solution



fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }

    // 섞어먹으면 안 되는 조합을 저장하는 Set
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    println(graph.toList())

    var cnt = 0
    for (i in 1..n) { //1부터 n
        for (j in i + 1..n) { //2부터 n
            if (graph[i].contains(j)) continue
            for (k in j + 1..n) { // 3부터 n
                if (graph[i].contains(k) || graph[j].contains(k)) continue
                cnt++
            }
        }
    }
    println(cnt)
}

//5 3
//1 2
//3 4
//1 3


