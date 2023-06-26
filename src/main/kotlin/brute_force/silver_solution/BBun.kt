package brute_force.silver_solution

//8 사람수
//2 몇번째
//0 뻔 1 데기
fun main(){
    val br = System.`in`.bufferedReader()
    val peopleCnt = br.readLine().toInt()
    var targetCnt = br.readLine().toInt()
    val bbunOrDagi = if(br.readLine().toInt() == 0) '뻔' else '데'
    var n = 2
    var cnt = 0
    var num = 0
    while (true){
        val a = "뻔데뻔데${"뻔".repeat(n)}${"데".repeat(n)}"
        for (i in a){
            if (i ==bbunOrDagi) targetCnt--
            if (0 == targetCnt) {
                cnt = num%peopleCnt
                break
            }
            num++
        }
        if (targetCnt == 0) break
        n++
    }
    println(cnt)
}