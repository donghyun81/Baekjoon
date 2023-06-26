package brute_force.silver_solution

import java.io.BufferedReader
import java.io.InputStreamReader



//3 5
//1 2 3 4 5
//5 4 3 2 1
//1 2 3 2 1
//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//
//    val (n: Int, m: Int) = br.readLine().split(" ").map { it.toInt() }
//
//    val map = Array(n) { br.readLine().split(" ").map { it.toInt() } }
//    val visited = BooleanArray(m)
//    var answer = 0
//   fun dfs(cur:Int,depth:Int){
//       if (depth == 3){
//           var sum = 0
//           for(i in 0 until  n){
//               var temp = 0
//               for (j in 0 until m){
//                   if (visited[j]) {
//                       temp = maxOf(temp,map[i][j])
//                   }
//               }
//               sum += temp
//           }
//           answer = maxOf(sum,answer)
//           return
//       }
//       for (i in cur until m){
//           if (visited[i]) continue
//           visited[i] = true
//           dfs(cur+1,depth+1)
//           visited[i] = false
//       }
//   }
//    dfs(0,0)
//    println(answer)
//}


//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//
//    val (n: Int, m: Int) = br.readLine().split(" ").map { it.toInt() }
//
//    val map = Array(n) { br.readLine().split(" ").map { it.toInt() } }
//    for (i in 0 until m){
//        for (j in i+1 until m){
//            for (k in j+1 until m){
//                var temp = 0
//                for (l in 0 until n){
//                    temp  += maxOf(map[l][i],map[l][j],map[l][k])
//                    println(temp)
//                }
//                println()
//                println(temp)
//                println()
//            }
//        }
//    }
//}

