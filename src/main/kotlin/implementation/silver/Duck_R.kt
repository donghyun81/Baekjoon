package silver

import java.util.*

//fun main() {
//    val quack = "quack"
//    val input = readLine()!!
//
//    // 입력된 문자열이 "quack"으로 이루어져 있지 않으면 -1 출력
//    if (!input.all { it in "quack" } || input.length % 5 != 0) {
//        println("-1")
//        return
//    }
//
//    val visited = BooleanArray(input.length)
//
//    var count = 0
//    for (i in input.indices step quack.length) {
//        // "quack"으로 시작하는 문자열이 없으면 종료
//        if (input.substring(i, i + quack.length) != quack) {
//            println("-1")
//            return
//        }
//        // "quack"으로 시작하는 문자열을 찾을 때마다 count 증가
//        count++
//        // 해당 문자열을 방문처리
//        for (j in i until i + quack.length) {
//            visited[j] = true
//        }
//    }
//    // 모든 문자를 방문하지 않은 경우 -1 출력
//    if (!visited.all { it }) {
//        println("-1")
//        return
//    }
//    // 올바른 "quack" 문자열의 개수 출력
//    println(count)
//}

//fun main(){
//    val quack = "quack"
//    val input = readLine()!!
//    val visited = Array(input.length){false}
//    var result = 0
//    if (!input.all { it in quack } || input.length%5 != 0){
//        println(-1)
//        return
//    }
//
//  fun find(start:Int){
//      var j = 0
//      var first = true
//      for (i in start until input.length ){
//          if (input[i]==quack[j] || !visited[i]){
//              visited[i] = true
//              if (quack[j]=='k'){
//                  if (first){
//                      result++
//                      first=false
//                  }
//                  j = 0
//              }
//              else j++
//          }
//      }
//  }
//
//    for (i in input.indices){
//        if (input[i] =='q'&&!visited[i]){
//            find(i)
//            result++
//        }
//    }
//    if (result==0 || !visited.all { true }) {
//        println(-1)
//        return
//    }
//    println(result)
//}

fun main() {
    val sound = readLine()!!.toMutableList()
    val duck = "quack"
    var answer = 0
    val visited = BooleanArray(sound.size)
    var isDuck = true
    if (sound.size%5 !=0) {
        println(-1)
        return
    }
    while(true){
        var duckIdx = 0
        val s = Stack<Char>()
        for(i in sound.indices){
            if (visited[i]) continue
            if (duck[duckIdx%5] == sound[i]){
                duckIdx++
                visited[i] = true
                s.push(sound[i])
            }
        }
        answer++
        if(visited.all { it }) break
        if (s.isEmpty() || s.peek() != 'k'){
            isDuck = false
            break
        }
    }
    if (isDuck) println(answer) else println(-1)
}






