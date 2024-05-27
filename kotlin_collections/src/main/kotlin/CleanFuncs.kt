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
}
    fun main(){
        var list = listOf<Int>(1,2,3,4)
        var list2 = listOf<Int>(1,2,3,4)
        var list3 = listOf<Int>(1,2,3,4)
        println(CleanFuncs().tripleList(list,list2,list3))
    }