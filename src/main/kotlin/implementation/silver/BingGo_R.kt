package silver


fun main(){
    BingGo().play()
}
class BingGo(){
    var myBoard :Array<List<Int>>
    var call : Array<List<Int>>
    var checkBoard :Array<BooleanArray>

    init {
        val br = System.`in`.bufferedReader()
        myBoard = Array(5){br.readLine().split(" ").map { it.toInt() }}
        call = Array(5){br.readLine().split(" ").map { it.toInt() }}
        checkBoard = Array(5) {BooleanArray(5)}
    }
    fun play(){
        var answer = 0
        for(i in checkBoard.indices){
            for (j in checkBoard[i].indices){
                marking(call[i][j])
                answer++
                if(isBingGo()) {
                    println(answer)
                    return
                }
            }
        }
    }
    fun marking(num:Int){
        for(i in myBoard.indices){
            for(j in myBoard.indices){
                if(myBoard[i][j] == num) checkBoard[i][j] = true

            }
        }
    }
    fun isBingGo() = columnBingoCnt()+rowBingoCnt()+countDiagonalBingo() >= 3

    fun columnBingoCnt():Int{
        var answer = 0
        checkBoard.forEach { if(it.all { it }) answer++ }
        return answer
    }
    fun rowBingoCnt():Int{
        var answer = 0
        for(i in checkBoard.indices){
            var bingGo = true
            for(j in checkBoard.indices){
                bingGo = bingGo and checkBoard[j][i]
            }
            if (bingGo) answer++
        }
        return answer
    }
    fun countDiagonalBingo():Int{
        var answer = 0
        var bingGo = true
        for(i in checkBoard.indices){
           bingGo = bingGo and checkBoard[i][i]
        }
        if (bingGo) answer++

        bingGo = true
        for(i in checkBoard.indices){
            bingGo = bingGo and checkBoard[checkBoard.size-1-i][i]
        }
        if (bingGo) answer++

        return answer
    }

}

