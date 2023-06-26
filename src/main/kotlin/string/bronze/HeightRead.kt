package bronze

class HeightRead {

}

//ABCDE
//abcde
//01234
//FGHIJ
//fghij
fun main(){
    val br = System.`in`.bufferedReader()
    val board = Array(5){br.readLine()}
    val max = board.maxOf { it.length }
    for (i in 0..max){
        for(j in 0..4){
            if (board[j].length  <= i) continue
            print(board[j][i])
        }
    }
}