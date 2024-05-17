import java.util.*


class projecteuler{

    fun sumPow(x: Int): Int = if (x<10) { Math.pow(x.toDouble(), 5.toDouble()).toInt() } else {Math.pow((x%10).toDouble(), 5.toDouble()).toInt() + sumPow(x/10)}


    tailrec fun powTail(x: Int): Int =  if (x > 5 * Math.pow(9.toDouble(),5.toDouble()).toInt()) {0} else { if (x == sumPow(x)) { x + powTail(x+1)} else {powTail(x+1)} }


    fun main() {
        val x: Int = 2
        println(powTail(x))
    }
}



fun main() = projecteuler().main()