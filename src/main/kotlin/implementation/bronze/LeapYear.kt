package bronze

fun main(){
    val br = System.`in`.bufferedReader()
    val year = br.readLine().toInt()
    if(isLeapYear(year)) println(1) else println(0)


}
fun isLeapYear(year:Int) = year%4==0&&(year%100!=0||year%400==0)