package brute_force.silver_solution

class AandB {
}

fun main(){
    val br = System.`in`.bufferedReader()
    val original = br.readLine()
    var done = br.readLine()
    var a = false
   fun dfs(original:String,target:String){
       if (original.length == target.length){
           if (original == target) a = true
           return
       }
       if (target.last() =='A') dfs(original,target.substring(0,target.length-1))
       if (target.first()=='B') dfs(original,target.substring(1).reversed())
       return
   }
    dfs(original,done)
    if (a) println(1) else println(0)
}