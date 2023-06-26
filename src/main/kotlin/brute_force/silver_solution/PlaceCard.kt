package brute_force.silver_solution

import kotlin.system.measureNanoTime


//상근이는 카드 n(4 ≤ n ≤ 10)장을 바닥에 나란히 놓고 놀고있다. 각 카드에는 1이상 99이하의 정수가 적혀져 있다. 상근이는 이 카드 중에서 k(2 ≤ k ≤ 4)장을 선택하고, 가로로 나란히 정수를 만들기로 했다. 상근이가 만들 수 있는 정수는 모두 몇 가지일까?
//
//예를 들어, 카드가 5장 있고, 카드에 쓰여 있는 수가 1, 2, 3, 13, 21라고 하자. 여기서 3장을 선택해서 정수를 만들려고 한다. 2, 1, 13을 순서대로 나열하면 정수 2113을 만들 수 있다. 또, 21, 1, 3을 순서대로 나열하면 2113을 만들 수 있다. 이렇게 한 정수를 만드는 조합이 여러 가지 일 수 있다.
//
//n장의 카드에 적힌 숫자가 주어졌을 때, 그 중에서 k개를 선택해서 만들 수 있는 정수의 개수를 구하는 프로그램을 작성하시오.

//fun main(){
//    val br = System.`in`.bufferedReader()
//    val cardsCount = br.readLine().toInt()
//    val selectCardCount = br.readLine().toInt()
//    val cards = List(cardsCount) { br.readLine().toInt() }
//    val results = mutableSetOf<Int>()
//    var sum = 0
//
//    fun dfs(cards:List<Int>,cardCount:Int,number:Int){
//        //탈출조건
//        if (cardCount == selectCardCount) {
//            sum = 0
//            results.add(number)
//        }
//        //실행
//        for (i in cards){
//            sum += if (i>=10) i*100 else i*10
//            dfs(cards,selectCardCount+1,number)
//        }
//    }
//    dfs(cards,0,)
//    println(results)
//}

//var result = 0
//fun main() {
//    val br = System.`in`.bufferedReader()
//    val cardsCount = br.readLine().toInt()
//    val selectCardCount = br.readLine().toInt()
//    val cards = List(cardsCount) { br.readLine().toInt() }
//    val visited = Array(cardsCount){true}
//    fun dfss(next:Int,num:Int,selectCardCount:Int,cardsCount:Int,cards:List<Int>,visited:Array<Boolean>){
//        if (next==selectCardCount) {
//            result++
//            return
//        }
//        for (i in 0 until cardsCount){
//            if (visited[i]) continue
//            visited[i] = true
//            val tmp = if (cards[i] >9) num*100+cards[i] else cards[i]*10 + cards[i]
//            dfss(next+1,tmp,selectCardCount,cardsCount,cards,visited)
//            visited[i] = false
//        }
//    }
//
//    dfss(0,0,selectCardCount,cardsCount,cards,visited)
//    println(result)
//}


//fun main() {
//    val br = System.`in`.bufferedReader()
//    val cardsCount = br.readLine().toInt()
//    val selectCardCount = br.readLine().toInt()
//    val cards = List(cardsCount) { br.readLine().toInt() }
//    val numberCards = NumberCards(cards)
//    val placeCard = PlaceCard(numberCards, selectCardCount)
//    placeCard.combinationNumbers()
//}
//
//class NumberCards(private val cards: List<Int>) {
//    fun getCards() = cards
//}
//
//class PlaceCard(private val cards: NumberCards, private val selectCardCount: Int) {
//    private val result = mutableListOf<Int>()
//    private val visited = MutableList(cards.getCards().size) { false }
//    private var countt = 0
//
//
//    fun combinationNumbers() {
//        process(0, 0)
//        println(result)
//
//    }
//
//    private fun process(count: Int, num: Int) {
//        if (count == selectCardCount){
//            result.add(num)
//            println(count)
//            return
//        }
//        for (i in cards.getCards().indices) {
//            if (visited[i]) { continue }
//            visited[i] = true
//            val tmp = if (cards.getCards()[i] > 9) num * 100 + cards.getCards()[i] else num * 10 + cards.getCards()[i]
//            process(count + 1, tmp)
//            visited[i] = false
//        }
//    }
//}

//4
//2
//1
//2
//12
//1
fun main(){
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()
    val targetCnt = br.readLine().toInt()
    val nums = mutableListOf<Int>()
    val answer = mutableSetOf<Int>()
    val visited = BooleanArray(cnt)
    repeat(cnt){
        nums.add(br.readLine().toInt())
    }

    fun dfs(depth:Int,num:String,visited:BooleanArray,cur:Int){
        if (depth == targetCnt){
            answer.add(num.toInt())
            return
        }

        for (i in nums.indices){
            if (visited[i]) continue
            visited[i] = true
            dfs(depth+1,num+nums[i],visited,cur)
            visited[i] =false
        }
    }
    val elapsed: Long = measureNanoTime {
        dfs(0,"", visited,0)
        println(answer.size)
    }
    println(elapsed)

}