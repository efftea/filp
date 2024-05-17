import java.lang.System.`in`
import java.util.*

class recursions {

    //Найти максимальную цифру числа. Рекурсия вверх.
    fun max(x: Int): Int = if (x < 10) x else {if(x%10 > max(x/10)) x%10 else max(x/10)}


    //Найти минимальную нечетную цифру числа. Рекурсия вверх.
    fun minOdd(x: Int): Int = if(x < 10) {if (x%2 != 0) x else 9} else {if ((x%10 < minOdd(x/10)) && ((x%10)%2 != 0)) x%10 else minOdd(x/10)}


    //Найти НОД двух чисел. Рекурсия вверх.
    fun gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)

    //Найти максимальную цифру числа. Хвостовая рекурсия.
    


    fun main() {
        val scanner = Scanner(System.`in`)
        val x: Int = scanner.nextInt()
        val y: Int = scanner.nextInt()
        println(gcd(x, y))
    }
}

fun main() = recursions().main()