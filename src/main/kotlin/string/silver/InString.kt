package silver

class InString {
}

//sequence subsequence
//person compression
//VERDI vivaVittorioEmanueleReDiItalia
//caseDoesMatter CaseDoesMatter
fun main(){
    val br = System.`in`.bufferedReader()
    while(true){
        val (targetS,s) = br.readLine().split(" ")
        var idx = 0
        for (i in s){
            if (i == targetS[idx]) idx++
            if (idx == targetS.length-1) {
                println("Yes")
                break
            }
        }
        if (idx != targetS.length-1) println("No")
    }
}