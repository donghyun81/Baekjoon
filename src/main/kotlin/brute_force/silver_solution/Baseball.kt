package brute_force.silver_solution

import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

// 숫자 야구 게임
// 총 질문에 대한 답변중 남은 정답의 개수를 계산한다.
// 경우의 수에 총 개수를 구하기

//var count =0
//@OptIn(ExperimentalTime::class)
//fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
//    val input = readLine().toInt()
//    val baseBallList = ArrayList<BaseBall>()
//    val visited = BooleanArray(10){false}
//    repeat(input) {
//        readLine().split(" ").apply {
//            baseBallList.add(BaseBall(this[0], this[1].toInt(), this[2].toInt()))
//        }
//    }
//    dfs(0,baseBallList,visited,"")
//
//    println(count)
//    val measuredTime = measureTimedValue {
//    }
//
//    println("result => ${measuredTime.value} || measured time ==>${measuredTime.duration}")
//}
//
//
//tailrec fun dfs(depth:Int,baseBallList:ArrayList<BaseBall>,visited:BooleanArray,target: String){
//    if(depth==3){
//        var temp =0
//        for(baseBall in baseBallList){
//            if((checkBall(baseBall.baseBall,target)==baseBall.ball)&& (checkStrke(baseBall.baseBall,target)==baseBall.strike)){
//                temp+=1
//            }
//        }
//        if(temp==baseBallList.size){ count+=1 }
//        return
//    }
//    for(i in 1 .. 9){
//        if(!visited[i]){
//            visited[i]=true
//            dfs(depth+1,baseBallList,visited,target+i.toString())
//            visited[i]=false
//        }
//    }
//}
//
//data class BaseBall(val baseBall: String, val strike: Int, val ball: Int)
//
//fun checkBall(source: String, target: String): Int {
//    var count = 0
//    for (i in source.indices) {
//        if (source.contains(target[i])&&target[i] != source[i]) {
//            count += 1
//        }
//    }
//    return count
//}
//
//fun checkStrke(source: String, target: String): Int {
//    var count = 0
//    for (i in source.indices) {
//        if (target[i] == source[i]) {
//            count += 1
//        }
//    }
//    return count
//}

//4
//123 1 1
//356 1 0
//327 2 0
//489 0 1
//fun main(){
//    val br =System.`in`.bufferedReader()
//    val answerCount = br.readLine().toInt()
//    val answers = mutableListOf<List<Int>>()
//    repeat(answerCount){
//        answers.add(br.readLine().split(" ").map { it.toInt()})
//    }
//    val visited = Array(10){false}
//    var result = 0
//    var count = 0
//    fun dfs(depth:Int,number:String){
//        //탈출 조건
//        count++
//        if (depth == 3){
//            var count = 0
//            for (i in answers){
//                if(checkBallCount(i[0].toString(),number)==i[2]&& checkStrikeCount(i[0].toString(),number) ==i[1]) count++
//            }
//            println(count)
//            if (count==answerCount) result++
//            return
//        }
//    // 실행 조건
//            for (i in 1..9){
//                if(!visited[i]){
//                    visited[i] = true
//                    dfs(depth+1,number+i)
//                    visited[i] = false
//                }
//            }
//
//    }
//    dfs(0,"")
//    println(count)
//    println(result)
//
//}
//
//fun checkBallCount(questionNumber:String,targetNumber:String):Int{
//    var ballCount = 0
//    for (i in targetNumber.indices){
//        if(questionNumber.contains(targetNumber[i])&&questionNumber[i] !=targetNumber[i]) ballCount++
//    }
//
//    return ballCount
//}
//fun checkStrikeCount(questionNumber:String,targetNumber:String):Int{
//    var strikeCount = 0
//    for (i in targetNumber.indices){
//        if(questionNumber[i] ==targetNumber[i]) strikeCount++
//    }
//
//    return strikeCount
//}

//4
//123 1 1
//356 1 0
//327 2 0
//489 0 1
fun main(){
    val br = System.`in`.bufferedReader()
    val cbnCnt = br.readLine().toInt()
    var baseball = (123..987)
        .map { it.toString()}
        .filter { !it.contains('0')&&it.toList().distinct().size == it.length }
    repeat(cbnCnt){
        val (targetNum,s,b) = br.readLine().split(" ").map { it.toInt() }
        baseball = baseball.filter {
            getBallCnt(targetNum.toString(),it) ==b && getStrikeCnt(targetNum.toString(),it) ==s
        }
    }
    println(baseball.size)
}
fun getBallCnt(targetNum:String,nums:String):Int{
    var ballCnt = 0
    for(numIdx in nums.indices){
        if(targetNum.contains(nums[numIdx]) && targetNum[numIdx] !=nums[numIdx]) ballCnt++
    }
    return ballCnt
}
fun getStrikeCnt(targetNum:String,nums:String):Int{
    var strikeCnt = 0
    for(numIdx in nums.indices){
        if(targetNum[numIdx] ==nums[numIdx]) strikeCnt++
    }
    return strikeCnt
}
