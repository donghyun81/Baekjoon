package silver

//8 전구 개수 1~100
//0 1 0 1 0 0 0 1 초기 상태
//2 학생수 1~100
//1 3
//2 3
//8
//0 1 0 1 0 0 0 1
//2
//1 3
//2 3
fun main() {
    Switch().play()

}

class Switch {
    var switch: IntArray
    var cnt: Int
    var sexCnt: Int
    var sexAndNums: Array<List<Int>>

    init {
        val br = System.`in`.bufferedReader()
        cnt = br.readLine().toInt()
        switch = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        sexCnt = br.readLine().toInt()
        sexAndNums = Array(sexCnt) { br.readLine().split(" ").map { it.toInt() } }
    }

    fun play() {
        sexAndNums.forEach{value ->
            val (sex,num) = value
            if (sex==1) manSwitch(num) else girlSwitch(num)
        }
        for(i in switch.toMutableList().chunked(20)){
            println(i.joinToString(" "))
        }
    }

    fun manSwitch(num: Int) {
        for(idx in switch.indices){
            if ((idx+1) % num == 0){
                if (switch[idx] == 1) { switch[idx] = 0
                }
                else{
                    switch[idx] = 1
                }
            }
        }
    }

    fun girlSwitch(num:Int) {
        var down = num-1
        var up = num-1
        while(true){
            if(down < 0 || up >= switch.size) {
                down++
                up--
                break
            }
            if (switch[down] != switch[up]){
                down++
                up--
                break
            }
            down--
            up++
        }
        for(idx in down..up) if (switch[idx] == 1) switch[idx] = 0 else switch[idx] = 1
    }
}