package implementation.silver

fun main(){
    Confetti().solution()

}
class Confetti {
    val drawingPaper = Array(101) {BooleanArray(101)}
    fun solution(){
        val br = System.`in`.bufferedReader()
        val confettiCnt = br.readLine().toInt()
        var totalArea = 0
        repeat(confettiCnt){
            val (startX,startY) = br.readLine().split(" ").map { it.toInt() }
            for (x in startX until startX+10)
                for (y in startY until startY+10)
                    drawingPaper[x][y] = true
        }
        for (x in drawingPaper.indices)
            for (y in drawingPaper[x].indices)
                if (drawingPaper[x][y]) totalArea++
        println(totalArea)
    }
}