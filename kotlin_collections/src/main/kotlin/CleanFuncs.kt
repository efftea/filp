import java.util.ListResourceBundle

class CleanFuncs(){
    tailrec fun arrayOP(m: List<Int>, f: (Int, Int) -> Int, i: Int = m.size, a: Int = 0): Int =
        if (i <= 0) a else arrayOP(m, f, i - 1, f(a, m[i - 1]))

    tailrec fun findInList(list: List<Int>, predicate: (Int) -> Boolean, index: Int = list.size): Boolean {
        if (index <= 0) {
            return false
        } else if (predicate(list[index - 1])) {
            return true
        } else {
            return findInList(list, predicate, index - 1)
        }
    }

    // Число элементов списка, которые могут быть квадратами другого числа
    fun squareList(list: List<Int>): Int {
        return arrayOP(list, { count, el ->
            if (findInList(list, { it == el * el })) count + 1 else count
        })
    }

    fun sumc(n: Int): Int = if (n < 10) n else (n % 10) + sumc(n / 10)
    fun countDel(n: Int): Int = (1..n).count { n % it == 0 }
    fun tripleList(list1: List<Int>, list2: List<Int>, list3: List<Int>): List<Triple<Int, Int, Int>> {
        return list1.sortedDescending()
            .mapIndexed { index, value ->
                Triple(
                    value,
                    list2.sortedBy { sumc(it) }[index],
                    list3.sortedByDescending { countDel(it) }[index]
                )
            }
    }

    // проверка является ли глобальным минимумом
    fun globMin(list: List<Int>,ind:Int):Boolean=if(list.sorted()[0]==list[ind]&&list.count { it==list[ind] }==1)true else false

    // нахождение двух наименьших
    tailrec fun twoMin(list: List<Int>, ind: Int = 0, i: Int = -1): List<Int> {
        if (i >= 0) return listOf(i, ind)
        else {
            if((list.sorted()[0] == list[ind])or(list.sorted()[1] == list[ind])) {
                if (list.sorted()[0] == list[ind]) return twoMin(list, ind + 1, ind)
                if (list.sorted()[1] == list[ind]) return twoMin(list, ind + 1, ind)
            }
            else return twoMin(list, ind+1, i)
        }
        return listOf(-1, -1)
    }

    //Нахождение всех элементов в интервале
    fun intervalAB(list: List<Int>,a: Int,b: Int): List<Int> {
        return list.sorted().subList(list.sorted().indexOfFirst{it==a},list.sorted().indexOfLast { it==b }+1)
    }

    //Нахождение все элементов которых нет в изначальном листе
    fun allCif(list: List<Int>,a: Int = list.sorted().min(),b: Int = list.sorted().max()): List<Int> {
        val range = (a..b).toList()
        return range.filterNot { it in list }
    }

    //Элементы между первым и последним максимальными
    fun subListMax(list: List<Int>): Set<Int> {
        val max = list.maxOrNull() ?: return emptySet()
        val firstMaxIndex = list.indexOf(max)
        val lastMaxIndex = list.lastIndexOf(max)
        if (firstMaxIndex == lastMaxIndex) return emptySet()
        return list.subList(firstMaxIndex + 1, lastMaxIndex).toSet()
    }

    // Колличество глобальных максимумов
    fun countGlobMax(list: List<Int>): Int {
        val maxValue = list.maxOrNull() ?: return 0
        return list.count { it == maxValue }
    }

}
    fun main(){
        var f = CleanFuncs()
        var list = listOf<Int>(0,9,1,2,3,4,9,8,8,9,0,0)
        println(f.countGlobMax(list))
    }