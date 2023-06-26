package silver

import java.util.PriorityQueue

//3
//9
//2 1 4 3 5 6 2 7 2
//fun main(){
//    val br = System.`in`.bufferedReader()
//    val pictureCnt:Int = br.readLine().toInt()
//    val rcmCnt:Int =br.readLine().toInt()
//    val rcm:IntArray = br.readLine().split(" ").map { it.toInt() }.toIntArray()
//    Candidate().solution(pictureCnt,rcmCnt, rcm)
//
//}
//class Candidate {
//    var pictureCnt:Int = 0
//    var rcmCnt:Int = 0
//    lateinit var rcm:IntArray
//    fun solution(pictureCnt:Int,rcmCnt:Int,rcm:IntArray){
//        this.pictureCnt = pictureCnt
//        this.rcmCnt = rcmCnt
//        this.rcm = rcm
//        val pictures = HashMap<Int,IntArray>()
//        for (rcmIdx in rcm.indices){
//            if (pictures.keys.contains(rcm[rcmIdx])) pictures[rcm[rcmIdx]]?.let { it[0] = it[0]+1 }
//            else {
//                if (pictures.size >= pictureCnt) {
//                    val delist = pictures.entries.sortedWith(compareBy({ it.value[0] },{it.value[1]}))
//                    pictures.remove(delist[0].key)
//                    pictures[rcm[rcmIdx]] = intArrayOf(1,rcmIdx)
//                } else pictures[rcm[rcmIdx]] = intArrayOf(1,rcmIdx)
//            }
//        }
//        println(pictures.keys)
//    }
//
//}

//3
//9
//2 1 4 3 5 6 2 7 2

fun main(){
    Candidate().solution()

}
data class Student(val time:Int,val num:Int,val cnt:Int)

class Candidate(){
    var pictureSize = 0
    var recommendCnt = 0
    lateinit var recommend : IntArray
    fun solution(){
        val br = System.`in`.bufferedReader()
        val comparator = compareBy<Student>{it.cnt}.thenBy{it.time}
        val picture = PriorityQueue(comparator)

        pictureSize = br.readLine().toInt()
        recommendCnt = br.readLine().toInt()
        recommend = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        for (idx in recommend.indices){
                val find = picture.find { it.num== recommend[idx]}
                if(find != null){
                    picture.remove(find)
                    picture.add(Student(find.time,find.num,find.cnt+1))
                }else{
                    if (picture.size == pictureSize){
                        picture.poll()
                        picture.add(Student(idx,recommend[idx],1))
                    }else{
                        picture.add(Student(idx,recommend[idx],1))
                    }
                }
        }
        println(picture.sortedBy { it.num }.joinToString(" "){ "${it.num}" })
    }

}


//import java.util.PriorityQueue
//
//fun main() = with(System.`in`.bufferedReader()) {
//    val N = readLine().toInt()
//    val total = readLine().toInt()
//    val priorityQueue = PriorityQueue<Student>()
//
//    readLine().split(" ").map { it.toInt() }.forEachIndexed { time, number ->
//        val find = priorityQueue.find { it.number == number }
//        if (find != null) {
//            priorityQueue.remove(find)
//            priorityQueue.add(find.copy(rank = find.rank + 1))
//        } else {
//            if (priorityQueue.size < N) {
//                priorityQueue.add(Student(number, time))
//            } else {
//                priorityQueue.poll()
//                priorityQueue.add(Student(number, time))
//            }
//        }
//    }
//    print(priorityQueue.sortedBy { it.number }.joinToString(" ") { "${it.number}" })
//}
//
//data class Student(
//    val number: Int,
//    val time: Int,
//    val rank: Int = 1,
//) : Comparable<Student> {
//    override fun compareTo(other: Student): Int {
//        val comp1 = rank.compareTo(other.rank)
//        return if (comp1 == 0) {
//            time.compareTo(other.time)
//        } else {
//            comp1
//        }
//    }
//
//}
