package gold

fun main(){
    FourOrSeven().solution()

}
class FourOrSeven {
    fun solution(){
        val br = System.`in`.bufferedReader()
        val cnt = (br.readLine().toInt()+1).toString(2)
        val answer = StringBuilder()
        for (i in 1 until cnt.length){
            if (cnt[i]=='1') answer.append(7) else answer.append(4)
        }
        println(answer.toString())
    }
}