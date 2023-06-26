package gold

//3 5 10
//10 15 20
//20 30 25
//40 22 10

fun main(){
    val br = System.`in`.bufferedReader()
    val (n,l,r) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n){br.readLine().split(" ").map { it.toInt() }.toIntArray()}
    PopulationMovement().solution(n,l,r,graph)

}
class PopulationMovement {
    var n = 0
    var l = 0
    var r = 0
    lateinit var graph :Array<IntArray>

    fun solution(n:Int,l:Int,r:Int,graph:Array<IntArray>){
        this.n = n
        this.l = l
        this.r  = r
        this.graph = graph
        var state = BooleanArray(n*(n-1)*2)
        for (x in graph.indices){
            for (y in graph.indices){

            }
        }
    }


}