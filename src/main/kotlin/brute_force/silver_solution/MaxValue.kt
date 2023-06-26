package brute_force.silver_solution

//657 3
//1 5 7
fun main(){
    val br = System.`in`.bufferedReader()
    val (targetNumber,numbersCount ) = br.readLine().split(" ").map {it.toInt()}
    val numbers = br.readLine().split(" ").map{it.toInt()}.sortedDescending()
    var answer = 0
    fun dfs(curNum:String){
        if (curNum.isNotEmpty() && curNum.toInt() > targetNumber){
            return
        }

        if (curNum.isNotEmpty()){
            answer = maxOf(curNum.toInt(),answer)
        }
        for (i in numbers){
            dfs(curNum+i)
        }
    }
    dfs("")
    println(answer)
}


