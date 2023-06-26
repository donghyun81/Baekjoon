package brute_force.bronze_solution

fun main() {
    val br = System.`in`.bufferedReader()
    val number = br.readLine().toInt()
    for (i in 1..number){
        if (i.toString().map { it.digitToInt() }.sum()+i==number) {
            println(i)
            return
        }
    }
}