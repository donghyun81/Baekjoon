package implementation

import kotlin.math.max

fun main(){
    Yutnori().execute()

}
class Yutnori {
    private val place = listOf('Z','W','V','X','Y')
    var curPlace = 0
    var nextPlace = 1
    var curMovePlace = 0
    private var curInfo = ""
    var score = 0

    fun execute(){
        val br = System.`in`.bufferedReader()
        repeat(10){
            var turnCnt = 1
            while(turnCnt > 0){
                turnCnt--
                val yutResult =br.readLine()
                val moveCnt = yutResultToMoveCnt(yutResult)
                if (moveCnt >=4) turnCnt++
                curMovePlace += moveCnt
                placeChange()
                println(curInfo)
            }
        }
        if (score >0) println("WIN") else println("LOSE")

    }
    fun yutResultToMoveCnt(yutResult:String):Int = if(yutResult.count { it=='0' }>0 ) yutResult.count { it=='0' } else 5

    fun placeChange(){
        val isShortcut = ((curPlace ==1 || curPlace ==2) && nextPlace ==4) || curPlace ==4
        var maxPlace = if (isShortcut) 3 else 5
        if(nextPlace ==0) maxPlace++
        if(maxPlace < curMovePlace){
            if (nextPlace==0) score++
            curPlace = nextPlace
            nextPlace = if (curPlace ==3 || curPlace ==4) 0
            else (nextPlace+1)%5
            curMovePlace -= maxPlace
            curInfo = "${place[curPlace]}$curMovePlace${place[nextPlace]}"
        } else if(maxPlace == curMovePlace){
            if (nextPlace == 0) {
                score++
                curInfo ="Z"
                curPlace = nextPlace
                nextPlace += 1
                curMovePlace = 0
                return
            }
            curInfo = "${place[curPlace]}$curMovePlace${place[nextPlace]}"
            curMovePlace = 0
            if (curPlace == 0 || curPlace ==1){
                curPlace ++
                nextPlace = 4
            }else{
                curPlace = nextPlace
                if (curPlace==3|| curPlace==4) nextPlace = 0
                else nextPlace++
            }
        } else{
            curInfo = "${place[curPlace]}$curMovePlace${place[nextPlace]}"
            return
        }
    }




}