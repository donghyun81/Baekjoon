package bronze

import java.lang.StringBuilder

//3
//asvdge ef ofmdofn
//xvssc kxvbv
//hull full suua pmlu
//fun main(){
//    val alphabets = "abcdefghijklmnopqrstuvwxyz"
//    val decryption = "wghuvijxpqrstacdebfklmnoyz"
//    val br = System.`in`.bufferedReader()
//    repeat(br.readLine().toInt()){
//        val passWord = br.readLine().split(" ").map {
//            val a = StringBuilder()
//            for (i in it){
//                a.append(alphabets[decryption.indexOf(i)])
//            }
//            a
//        }
//        println(passWord.joinToString(" "))
//    }
//}

fun main(){
        val br = System.`in`.bufferedReader()
    repeat(br.readLine().toInt()){
        val word = br.readLine().replace(" ","").groupingBy { it }.eachCount().entries.sortedByDescending { it.value }
        if (word.size>1 && word[0].value == word[1].value) println("?")
        else println(word[0].key)
    }
}

class Decryption {

}