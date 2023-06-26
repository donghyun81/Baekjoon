package brute_force.gold

import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.sqrt

//5
//1 3 5 4 2
fun main(){
    val br = System.`in`.bufferedReader()
    val cards = MutableList(br.readLine().toInt()) { it+1}
    val doneCards = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    SwapCard().solution(cards,doneCards)
}
class SwapCard {

    lateinit var cards : MutableList<Int>
    lateinit var doneCards : MutableList<Int>
    var answer = mutableListOf<Int>()
    var visited = BooleanArray(11)
    var cnt = 0

    fun solution(cards: MutableList<Int>, doneCards: MutableList<Int>) {
        this.cards = cards
        this.doneCards = doneCards
      dfs(listOf(),cards.toList())
        println(cnt)
    }
    fun firstShuffle(k: Double): List<Int> {
        val moveCard = cards.takeLast(2.0.pow(k).toInt())
        val containCard = cards.dropLast(2.0.pow(k).toInt())
        cards = (moveCard + containCard).toMutableList()
        return moveCard
    }

    fun shuffle(cnt:Int,k:Double,movedCard:List<Int>):List<Int> {
        val moveCard = movedCard.takeLast(2.0.pow(k-cnt+1).toInt())
        val containCard = cards.filter { !moveCard.contains(it) }
        cards = (moveCard + containCard).toMutableList()
        return moveCard
    }
    fun dfs(answers:List<Int>,tempCards:List<Int>){
        if (answers.size==2){
            answers.forEach{
                var movedCard = firstShuffle(it.toDouble())
                for (cnt in 2..it+1){
                    movedCard = shuffle(cnt,it.toDouble(),movedCard)
                }
            }
            if (cards == doneCards) {
                println(answers.joinToString(" "))
            }
            cards = tempCards.toMutableList()
            return
        }
        for(i in 1 ..cards.size){
            if (2.0.pow(i) >= cards.size ) continue
            dfs(answers+i,tempCards)
        }
    }

}



