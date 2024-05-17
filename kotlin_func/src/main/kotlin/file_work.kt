import java.lang.System.`in`
import java.util.*
import recursions.*
import java.io.File
import kotlin.reflect.KFunction
import kotlin.reflect.*

var arr = ArrayList<ArrayList<String>>()

// Получение строк из файла.
fun FileInDirectory(filePath: String) {
    val lines = File(filePath).readLines()
    for (line in lines) {
        val newList = ArrayList<String>()
        val act = line.split(" ").toTypedArray()
        for(q in act){
            newList.add(q)
        }
        arr.add(newList)
    }
}

// Получение функции по имени
fun getFunc(name: String): KFunction<Int>? {
    val Recursion = recursions()
    val funcs = mapOf(
        "max" to Recursion::max,
        "minOdd" to Recursion::minOdd,
        "gcd" to Recursion::gcd,
        "maxTail" to Recursion::maxTail,
        "minOddTail" to Recursion::minOddTail,
        "gcdTail" to Recursion::gcdTail
    )
    return funcs[name]
}


fun main() {
    val scanner = Scanner(System.`in`)
    val dir: String = scanner.next()
    val f: String = dir + "q_1.txt"
    val out: String = dir + "a_1.txt"
    FileInDirectory(f)
    File(out).writeText("")
    for (row in arr){
        val func = getFunc(row.last())
        println(func)
        if (row.size == 2)
            File(out).appendText((row[0]+" "+row[1]+" "+func!!.call(row[0].toInt())+"\n").toString())
        if (row.size == 3)
            File(out).appendText((row[0]+" "+row[1]+" "+row[2]+" "+func!!.call(row[0].toInt(), row[1].toInt())+"\n").toString())
        if (row.size == 4)
            File(out).appendText((row[0]+" "+row[1]+" "+row[2]+" "+row[3] +" "+func!!.call(row[0].toInt(), row[1].toInt(), row[2].toInt())+"\n").toString())
    }
}