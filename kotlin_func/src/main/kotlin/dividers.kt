import java.lang.System.`in`
import java.util.*

class dividers{

    //Найти количество делителей числа, не делящихся на 3. Хвостовая рекурсия.
    tailrec fun dTail(x: Int, z: Int): Int = if (z == 1) 1  else { if ((x%z == 0) && (z%3 != 0)) 1 + dTail(x, z - 1) else dTail(x, z - 1) }

    //Найти колличество общих делителей двух чисел. Хвостовая рекурсия.
    tailrec fun countDTail(x: Int, y: Int, z: Int): Int = if (z == 0) 0 else { if ((x%z == 0) && (y%z == 0)) 1 + countDTail(x, y, z - 1) else countDTail(x, y, z - 1) }


    fun oneFunc(x:Int,f:(Int, Int)->Int):Int= f(x, x-1)

    fun funcUp(x:Int, z:Int, f:(Int, Int, Int)->Int, f2:(Int)->Int, f3:(Int)->Int): Int = if (z == 1) 0 else {
        if((x%z == 0) && (f(z, f2(x), z-1) == 1) && (f(z, f3(x), z-1) > 1)) z + funcUp(x, z-1, f, f2, f3)
        else funcUp(x, z-1, f, f2, f3)
    }

    fun main() {
        val scanner = Scanner(`in`)
        val x: Int = scanner.nextInt()
//        val y: Int = scanner.nextInt()
        println(funcUp(x, x-1,::countDTail, simple_func()::sumc, simple_func()::mulc))
//        println(countDTail(x, y,x-1))
    }
}

fun main() = dividers().main()