package brute_force.gold

import kotlin.math.abs


fun main(){
    val br = System.`in`.bufferedReader()
    val (cnt,maxCnt) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(cnt){br.readLine().split(" ").map { it.toInt() }.toIntArray()}

    Chicken().solution(board,maxCnt)

}
class Chicken {

    lateinit var board :Array<IntArray>
    var chickenCnt = 0
    var chickensIdx = mutableListOf<Pair<Int,Int>>()
    lateinit var ditances :Array<IntArray>
    var homesIdx = mutableListOf<Pair<Int,Int>>()
    var answer = Int.MAX_VALUE
    var cntt = 0L


    fun solution(board:Array<IntArray>,maxCnt:Int){
        this.board = board
        this.chickenCnt = maxCnt
        searchChickensAndHomesIdx()
        val visited = BooleanArray(chickensIdx.size)
        calculateDistances()
        dfs(visited, listOf(),0)
        println(answer)
    }
    fun searchChickensAndHomesIdx (){
        for (x in board.indices){
            for (y in board[x].indices){
                when(board[x][y]){
                    homeNum -> homesIdx.add(Pair(x,y))
                    chickenNum -> chickensIdx.add(Pair(x,y))
                    else -> continue
                }
            }
        }
    }

    fun calculateDistances(){
        ditances = Array(homesIdx.size){ IntArray(chickensIdx.size) }
        for (i in homesIdx.indices){
            val (homeX,homeY) = homesIdx[i]
            for (j in chickensIdx.indices){
                val (chickenX,chickenY) = chickensIdx[j]
                ditances[i][j]=calculateDistance(homeX,homeY,chickenX,chickenY)
            }
        }
    }
    fun calculateDistance(x:Int,y:Int,targetX:Int,targetY: Int) = abs(x-targetX) + abs(y-targetY)

    fun dfs(visited:BooleanArray,chickens:List<Int>,cnt:Int){
        println(cntt++)
        if (chickens.size == chickenCnt){
            var sum = 0
            for (i in homesIdx.indices){
                var temp = Int.MAX_VALUE
                for (j in chickens){
                    temp = minOf(temp,ditances[i][j])
                }
                sum+=temp
            }
            answer = minOf(sum,answer)
        }
        for (idx in cnt until chickensIdx.size){
            dfs(visited,chickens + idx,idx+1)
        }
    }

    companion object {
        val homeNum = 1
        val chickenNum = 2
    }

}


