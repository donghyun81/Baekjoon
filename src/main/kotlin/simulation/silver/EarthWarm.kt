package silver

fun main() {
    EarthWarm().solution()

}

class EarthWarm {
    var r = 0
    var c = 0
    var graph = Array(10) { BooleanArray(10) }
    lateinit var grid :Array<CharArray>
    var minR = 11
    var maxR = 0
    var minC = 11
    var maxC = 0
    val dx = listOf(1,0,-1,0)
    val dy = listOf(0,1,0,-1)
    fun solution() {
        val br = System.`in`.bufferedReader()
        val (r, c) = br.readLine().split(" ").map { it.toInt() }
        this.r = r
        this.c = c
        this.grid = Array(r){br.readLine().toCharArray()}
        searchGround()
        for (x in minR..maxR){
            for (y in minC..maxC){
                if (graph[x][y]) print("X") else print(".")
            }
            println()
        }
    }

    fun searchGround(){
        for (x in 0 until  r){
            for (y in 0 until c ){
                var seaCnt = 0
                if (grid[x][y]=='X') {
                    graph[x][y] = true
                    for (dir in 0..3){
                        val nx = x +dx[dir]
                        val ny = y+dy[dir]
                        if (nx>=r || ny >=c || nx <0 || ny <0){
                            seaCnt++
                            continue
                        }
                        if (grid[nx][ny] !='.') continue
                        seaCnt++
                    }
                    if (seaCnt >=3){
                        graph[x][y] = false
                    }else {
                        minC = minOf(minC,y)
                        maxC = maxOf(maxC,y)
                        maxR = maxOf(maxR,x)
                        minR = minOf(minR,x)
                    }
                }
                else continue
            }
        }
    }
}
