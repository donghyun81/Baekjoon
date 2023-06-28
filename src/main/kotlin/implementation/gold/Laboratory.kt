package implementation.gold

import java.util.LinkedList

fun main(){
    Laboratory().solution()

}
//7 7
//2 0 0 0 1 1 0
//0 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 1 1
//0 1 0 0 0 0 0
//0 1 0 0 0 0 0
class Laboratory {
    var row = 0
    var column = 0
    var answer = 0
    lateinit var laboratory : Array<IntArray>
    fun solution(){
        val br = System.`in`.bufferedReader()
        val (n,m) = br.readLine().split(" ").map { it.toInt() }
        row = n
        column = m
        laboratory = Array(n) {br.readLine().split(" ").map { it.toInt() }.toIntArray() }
        val virusPlaces = mutableListOf<Pair<Int,Int>>()
        val blankPlaces = mutableListOf<Pair<Int,Int>>()
        for (x in laboratory.indices)
            for (y in laboratory[x].indices){
                when(laboratory[x][y]){
                    0 -> blankPlaces.add(x to y)
                    2 -> virusPlaces.add(x to y)
                    else -> continue
                }
            }
        for (i in 0 until blankPlaces.size -2)
            for (j in i+1 until blankPlaces.size-1 )
                for (k in j+1 until blankPlaces.size){
                    val closeBlankPlaces = listOf(blankPlaces[i],blankPlaces[j],blankPlaces[k])
                    val tempLaboratory = laboratory.map { it.toTypedArray() }.toTypedArray()
                    for (closeBlankPlace in closeBlankPlaces){
                        val (x,y) = closeBlankPlace
                        tempLaboratory[x][y] = 1
                    }
                    spread(virusPlaces,tempLaboratory)
                }

        println(answer)

    }

    fun spread(virusPlaces:List<Pair<Int,Int>>,laboratory : Array<Array<Int>>){
        val dx = listOf(1,0,-1,0)
        val dy = listOf(0,1,0,-1)
        var safetyPlaceCnt = 0
        for (virusPlace in virusPlaces){
            val q = LinkedList<Pair<Int,Int>>()
            q.offer(virusPlace)
            while (q.isNotEmpty()){
                var (x,y) = q.poll()
                for (drc in 0 until 4){
                    val nx  = x+dx[drc]
                    val ny  = y+dy[drc]
                    if (nx <0 || ny <0 || nx>=row || ny >=column) continue
                    if(laboratory[nx][ny] == 1 || laboratory[nx][ny] ==2) continue
                    q.offer(nx to ny)
                    laboratory[nx][ny] = 2
                }
            }
        }
        for (x in laboratory.indices)
            for (y in laboratory[x].indices)
                if(laboratory[x][y] == 0 ) safetyPlaceCnt++

        answer = maxOf(safetyPlaceCnt,answer)
    }

}