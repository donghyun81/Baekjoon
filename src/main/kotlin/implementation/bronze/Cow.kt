package bronze

//8 총 관찰
//3 1 소 번호, 위치(위치는 0,1)
//3 0
//6 0
//2 1
//4 1
//3 0
//4 0
//3 1
//소가 길을 건너간 최소횟수 구하기
fun main(){
    val br = System.`in`.bufferedReader()
    val moving = br.readLine().toInt()
     val cowMoving = mutableMapOf<Int,Int>()
    var result = 0
        for (i in 0 until moving){
            val (number,place) =  br.readLine().split(" ").map{it.toInt()}
            if (cowMoving.containsKey(number) && cowMoving[number] != place) result++
            cowMoving[number] = place
        }
    println(result)
    }
