package silver

//100
//10 20 23 34 55 30 22 19 12 45 23 44 34 38
fun main(){
    val br = System.`in`.bufferedReader()
    val money = br.readLine().toInt()
    val stockPriceFlow = br.readLine().split(" ").map { it.toInt() }
    println( MiracleTradingTricks(money,stockPriceFlow).bnp())
    println(MiracleTradingTricks(money,stockPriceFlow).trading33())


}

class MiracleTradingTricks(private val money:Int,private val stockPriceFlow :List<Int>) {
    //bnp 돈이 가능할때마다 구매
    fun bnp():Int{
        var stockCnt = 0
        var tmpMoney = money
        for (stockPriceIdx in stockPriceFlow.indices){
            while(tmpMoney >= stockPriceFlow[stockPriceIdx]) {
                stockCnt++
                tmpMoney -= stockPriceFlow[stockPriceIdx]
            }
        }
        return stockCnt*stockPriceFlow.last() + tmpMoney
    }

    //33매매 3일 연속 상승 3일째 모두 판매 3일 연속 하락 3일째 모두 구매
    fun trading33():Int{
        var stockCnt = 0
        var tmpMoney = money
        var isHigh = false
        var highCnt = 0
        var lowCnt = 0
        for(stockIdx in 1 until stockPriceFlow.size){
            val prvStock = stockPriceFlow[stockIdx-1]
            val curStock =stockPriceFlow[stockIdx]
            if (prvStock < curStock){
                highCnt++
                lowCnt = 0
            }
            else if(prvStock > curStock) {
                lowCnt++
                highCnt = 0
            }
            else continue
            if (lowCnt >= 3) {
                while(tmpMoney >= stockPriceFlow[stockIdx]) {
                    stockCnt++
                    tmpMoney -= stockPriceFlow[stockIdx]
                }
            }
            if (highCnt >=3) {
                tmpMoney += stockCnt*curStock
                stockCnt = 0
            }
        }
        return stockCnt*stockPriceFlow.last() + tmpMoney
    }

}