package silver

fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()-1
    val b = mutableListOf<String>()
    val a = Array(n+(n*4)){ "*".repeat(n+(n*4)).toCharArray() }
    for(i in a.indices){
        for(j in a[i].indices){
            if (i%2 == 1) a[i][j] = ' '
        }
    }
}