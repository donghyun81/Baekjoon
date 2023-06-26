package programmers

import java.util.*

fun main() {
    val tickets = arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))
    val a = AirPort().solution(tickets)
    println(AirPort().solution(tickets).toList())

}
//
//class AirPort {
//    var answer = 0
//    private lateinit var visited: BooleanArray
//
//    fun solution(tickets: Array<Array<String>>): Array<String> {
//        val answers = mutableListOf<MutableList<String>>()
//        val visited = BooleanArray(tickets.size - 1)
//        for (i in tickets) {
//            val answer = mutableListOf<String>()
//
//
//        }
//        return answer
//    }
//
//    fun dfs(cur: Int, ticket: Array<String>, tickets: Array<Array<String>>,answer:MutableList<String>) {
//
//        for (i in tickets.indices) {
//            if (tickets[i][0] == tickets[cur][0] || !visited[i]) {
//                visited[i] = true
//                answer.add(tickets[i])
//                dfs(i,tickets[i],tickets, answer)
//                visited[i] = false
//            }
//        }
//
//    }
//
//
//}
class AirPort {

    private lateinit var tickets: Array<Array<String>>

    fun solution(tickets: Array<Array<String>>): Array<String> {
        this.tickets = tickets
        tickets.sortBy { it[1] }

        val route = mutableListOf<String>()
        val visited = BooleanArray(tickets.size) { false }

        dfs("ICN", visited, route)

        return route.toTypedArray()
    }

    private fun dfs(city: String, visited: BooleanArray, route: MutableList<String>): Boolean {
        route.add(city)
        println(route)
        if (route.size == tickets.size + 1) {
            return true
        }

        for (i in tickets.indices) {
            if (!visited[i] && tickets[i][0] == city) {
                visited[i] = true
                if (dfs(tickets[i][1], visited, route)) {
                    return true
                }
                visited[i] = false
            }
        }
        route.removeLast()
        return false
    }

}


//class AirPort {
//
//    private lateinit var tickets: Array<Array<String>>
//    private lateinit var visit: Array<Boolean>
//    private var len: Int = 0;
//    private var list: MutableList<String> = ArrayList<String>();
//    private var sb = StringBuilder();
//
//
//    fun solution(tickets: Array<Array<String>>): Array<String> {
//        this.tickets = tickets;
//        len = tickets.size;
//        visit = Array<Boolean>(len) { false };
//
//        // tickets (문자형)2차원 배열 정렬
//        this.tickets.sortWith { x, y ->
//            if (x[0] == y[0]) {
//                x[1].compareTo(y[1])
//            } else x[0].compareTo(y[0])
//        }
//
//
//        DFS("ICN", "ICN", 0);
//
//        var result = list[0];
//        var st = StringTokenizer(result);
//        var answer = Array<String>(len + 1) { "" };
//        for (i in 0..len) {
//            answer[i] = st.nextToken();
//        }
//
//        return answer
//    } // End of solution
//
//    private fun DFS(boarding: String, route: String, depth: Int) {
//        sb = StringBuilder();
//
//        if (depth == len) {
//            list.add(route)
//            return;
//        }
//
//        for (i in 0 until len) {
//            if (visit[i]) continue;
//
//            if (tickets[i][0] == boarding) {
//                visit[i] = true;
//                sb.append(route).append(' ').append(tickets[i][1]);
//                DFS(tickets[i][1], sb.toString(), depth + 1);
//                visit[i] = false;
//            }
//        }
//
//    } // End of DFS
//
//} // End of Solution class
