import java.util.*
import kotlin.collections.HashSet

open class car(
    val number: String,
    val type: String,
    val year: String,
    val modelEngine: String,
) : Comparable<car> {

    companion object {
        private val numberPattern = Regex("^[А-Яа-я][А-Яа-я]\\d{3}[А-Яа-я]")
    }

    init {
        validatenumber(number)
    }

    override fun toString(): String {
        return "Паспорт тс: '$number', тип кузова: '$type', дата выпуска: ${year}, тип двигателя: ${modelEngine}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as car

        if (number != other.number) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = number.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }

    override fun compareTo(other: car): Int {
        val numbertypeComparison = compareValuesBy(this, other, { it.number }, { it.type })
        if (numbertypeComparison != 0) return numbertypeComparison

        val yearComparison = year.compareTo(other.year)
        if (yearComparison != 0) return yearComparison

        return modelEngine.compareTo(other.modelEngine)
    }

    private fun validatenumber(number: String) {
        if (!numberPattern.matches(number)) {
            throw IllegalArgumentException("Неверный серийный номер: $number")
        }
    }

}

fun main(){
    val m: MutableList<car> = mutableListOf()
    val u1=car("ХГ005М","Легковая","1999", "Бензин")
    val u2=car("ХГ005М","Грузовая","1999", "Дизель")
    val u3=car("ХГ005М","Легковая","2015", "Бензин")
    val u4=car("ХГ005Г","Легковая","1999", "Бензин")
    m.add(u1)
    m.add(u2)
    m.add(u3)
    m.add(u4)
    for (x in m) println(x.toString())
    println("-------------------------------------------------------------------------------")
    m.sort()
    for (x in m) println(x.toString())
    println("-------------------------------------------------------------------------------")
    val h: HashSet<car> = hashSetOf()
    h.add(u1)
    h.add(u2)
    h.add(u3)
    h.add(u4)
    for (x in h) println(x.toString())
    println("-------------------------------------------------------------------------------")
    val t: TreeSet<car> = TreeSet()
    t.add(u1)
    t.add(u2)
    t.add(u3)
    t.add(u4)
    for (x in t) println(x.toString())
}