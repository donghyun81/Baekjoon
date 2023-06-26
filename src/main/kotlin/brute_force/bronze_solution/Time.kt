package brute_force.bronze_solution

fun main(){


}
class Time(private val hour:Int,private val countNumber:String) {
    fun play() : Int{
        var count = 0
        for(hour in 0..hour){
            for (minute in 0 until 60){
                for(second in 0 until 60){
                    if ("$hour$minute$second".contains(countNumber)) count++
                }
            }
        }
        return count
    }
}