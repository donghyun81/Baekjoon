package silver


fun main(){
    val br = System.`in`.bufferedReader()
    val word = br.readLine()
    var isIn = false
    var answer = StringBuilder()
    var temp = StringBuilder()
    for (i in word){
        if (!isIn){
            if (i == '<'){
                isIn = true
                answer.append(temp.reverse())
                temp.clear()
                answer.append(i)
            }
            else{
                if (i == ' '){
                    answer.append(temp.reverse())
                    answer.append(' ')
                    temp.clear()
                } else temp.append(i)
            }
        }
        else{
            answer.append(i)
            if (i =='>') isIn = false
        }
    }
    println(answer.append(temp.reverse()))
}


class WordRevert {
}