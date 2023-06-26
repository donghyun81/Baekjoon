package silver


fun main(){
    TreeReCircle().solution()

}
//7
//1 2 3
//2 4 5
//3 6 7
//4 -1 -1
//5 -1 -1
//6 -1 -1
//7 -1 -1
class TreeReCircle {
    var n = 0
    lateinit var tree:Array<IntArray>
    var answer = 0
    fun solution() {
        val br = System.`in`.bufferedReader()
        n = br.readLine().toInt()
        tree = Array(n+1){ IntArray(3){-1} }
        repeat(n){
            val (roof,left,right) = br.readLine().split(" ").map { it.toInt() }
            tree[roof][0] = left
            tree[roof][1] = right
            if (left != -1) tree[left][2] =roof
            if (right != -1) tree[right][2]=(roof)
        }
        var idx = 1
        var last = 0
        while(true){
            if (tree[idx][1] == -1) {
                last = idx
                break
            }
            idx = tree[idx][1]
        }
        var cnt = 0
        fun dfs(cur:Int){
            if (last == cur) {
                answer = cnt
                return
            }
            for (i in tree[cur].indices){
                if (tree[cur][i] == -1) continue
                val temp = tree[cur][i]
                tree[cur][i] = -1
                cnt++
                dfs(temp)
            }
        }
        dfs(1)
        println(answer)
    }

}