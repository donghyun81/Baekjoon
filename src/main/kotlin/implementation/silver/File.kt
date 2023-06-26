package silver

class File {
}

fun main(){
    val br = System.`in`.bufferedReader()
    val fileCount = br.readLine().toInt()
    val files = List(fileCount){br.readLine().split(".")[1]}
    val result = files.groupingBy { it }.eachCount()
    for(i in result.keys.sorted()) println("$i ${result[i]}")
}


