package brute_force.gold

fun main(){
    AB().solution()

}

//A
//BABA
class AB {
    var a = ""
    var b = ""
    var possible = false
    fun solution(){
        val br = System.`in`.bufferedReader()
        a = br.readLine()
        b = br.readLine()
        dfs(b)
        if (possible) println(1) else println(0)
    }

    fun dfs(curS:String){
        if (curS.length <= a.length){
            if(curS==a) possible = true
            return
        }
        if(curS.first() =='B') dfs(curS.substring(1).reversed())
        if(curS.last() == 'A') dfs(curS.substring(0,curS.length-1))
    }


}