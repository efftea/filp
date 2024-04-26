import java.io.File

var arr = ArrayList<ArrayList<String>>()
val before_numbers: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
val after_numbers: Array<Int> = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
val arr_after = ArrayList<ArrayList<String>>()


fun listFilesInDirectory(directoryPath: String) {
    val directory = File(directoryPath)
    if (directory.exists() && directory.isDirectory) {
        val files = directory.listFiles()
        files?.forEach { file ->
            if (file.isFile) {
                readNum(directoryPath, file.name)
            }
        }
    } else {
        println("Указанная директория не существует или не является директорией.")
    }
}

fun readNum(dir: String, fileName: String) {
    val file = "$dir$fileName"
    val lines = File(file).readLines()
    val newList = ArrayList<String>()
    for (line in lines) {
        val act = line.split(" ").toTypedArray()
        newList.add(act[0])
    }
    val fn = fileName.dropLast(4)
    newList.add(fn)
    arr.add(newList)
}

fun score_befor(){
    for (row in arr) {
        for (i in 0 until row.size - 1) {
            if (row[i] == "0"){
                before_numbers[0] += 1
            }
            if (row[i] == "1"){
                before_numbers[1] += 1
            }
            if (row[i] == "2"){
                before_numbers[2] += 1
            }
            if (row[i] == "3"){
                before_numbers[3] += 1
            }
            if (row[i] == "4"){
                before_numbers[4] += 1
            }
            if (row[i] == "5"){
                before_numbers[5] += 1
            }
            if (row[i] == "6"){
                before_numbers[6] += 1
            }
            if (row[i] == "7"){
                before_numbers[7] += 1
            }
            if (row[i] == "8"){
                before_numbers[8] += 1
            }
            if (row[i] == "9"){
                before_numbers[9] += 1
            }
        }
    }
}

fun score_after(){
    for (row in arr_after) {
        for (i in 0 until row.size - 1) {
            if (row[i] == "0"){
                after_numbers[0] += 1
            }
            if (row[i] == "1"){
                after_numbers[1] += 1
            }
            if (row[i] == "2"){
                after_numbers[2] += 1
            }
            if (row[i] == "3"){
                after_numbers[3] += 1
            }
            if (row[i] == "4"){
                after_numbers[4] += 1
            }
            if (row[i] == "5"){
                after_numbers[5] += 1
            }
            if (row[i] == "6"){
                after_numbers[6] += 1
            }
            if (row[i] == "7"){
                after_numbers[7] += 1
            }
            if (row[i] == "8"){
                after_numbers[8] += 1
            }
            if (row[i] == "9"){
                after_numbers[9] += 1
            }
        }
    }
}

fun after_zeros(){
    after_numbers[0] = 0
    after_numbers[1] = 0
    after_numbers[2] = 0
    after_numbers[3] = 0
    after_numbers[4] = 0
    after_numbers[5] = 0
    after_numbers[6] = 0
    after_numbers[7] = 0
    after_numbers[8] = 0
    after_numbers[9] = 0
}

fun completion(min: Int, dir: String) {
    val oldDirImage = File("C:/Users/DaaNIK/IdeaProjects/ds_app/src/old_ds/images/")
    val newDirLabel = File("C:/Users/DaaNIK/IdeaProjects/ds_app/src/new_ds/labels/")
    val newDirImage = File("C:/Users/DaaNIK/IdeaProjects/ds_app/src/new_ds/images/")

    if (!newDirLabel.exists()) {
        newDirLabel.mkdirs()
    }
    if (!newDirImage.exists()) {
        newDirImage.mkdirs()
    }

    val direct = File(dir)
    oldDirImage.listFiles()?.forEach { file ->
        if (file.name == arr[0][2].plus(".jpg")) {
            val destFile = File(newDirImage, file.name)
            file.copyTo(destFile, overwrite = true)
            //file.delete()
        }
    }
    direct.listFiles()?.forEach { file ->
        if (file.name == arr[0][2].plus(".txt")) {
            val destFile = File(newDirLabel, file.name)
            file.copyTo(destFile, overwrite = true)
            //file.delete()
        }
    }



    arr_after.add(arr[0])
    var array = arr.drop(1).toTypedArray()

    score_after()
    while (after_numbers.any { it < min }) {
        after_zeros()
        score_after()
        val min_after = after_numbers.sortedArray().take(10).toTypedArray()
        val firstInd = after_numbers.indexOfFirst { it == min_after[0] }
        val secondInd = after_numbers.indexOfLast { it == min_after[1] }
        after_zeros()
        var k = 0
        var fk = 0
        var sk = 0
//        print(min_after[0].toString().plus(" "))
//        print(min_after[1].toString().plus(" "))
//        print(min_after[8].toString().plus(" "))
//        println(min_after[9].toString())
        loop@ while (k < 2) {
            if (after_numbers[secondInd] < min && after_numbers[firstInd] < min) {
                for ((index, row) in array.withIndex()) {
                    if ((row[0] == firstInd.toString() && row[1] == secondInd.toString()) or (row[1] == firstInd.toString() && row[0] == secondInd.toString())) {
                        val direct = File(dir)
                        oldDirImage.listFiles()?.forEach { file ->
                            if (file.name == row[2].plus(".jpg")) {
                                val destFile = File(newDirImage, file.name)
                                file.copyTo(destFile, overwrite = true)
                                //file.delete()
                            }
                        }
                        direct.listFiles()?.forEach { file ->
                            if (file.name == row[2].plus(".txt")) {
                                val destFile = File(newDirLabel, file.name)
                                file.copyTo(destFile, overwrite = true)
                                //file.delete()
                            }
                        }

                        arr_after.add(row)
                        array = array.sliceArray(0 until index) + array.sliceArray(index + 1 until array.size)
                        k = 2
                        break@loop
                    }
                }
                if (fk != 1) {
                    loopfk@ for ((index, row) in array.withIndex()) {
                        if ((row[0] == firstInd.toString() && row[1] != min_after[9].toString() && row[1] != min_after[8].toString()) or (row[1] == firstInd.toString() && row[0] != min_after[9].toString() && row[0] != min_after[8].toString())) {
                            val direct = File(dir)
                            oldDirImage.listFiles()?.forEach { file ->
                                if (file.name == row[2].plus(".jpg")) {
                                    val destFile = File(newDirImage, file.name)
                                    file.copyTo(destFile, overwrite = true)
                                    //file.delete()
                                }
                            }
                            direct.listFiles()?.forEach { file ->
                                if (file.name == row[2].plus(".txt")) {
                                    val destFile = File(newDirLabel, file.name)
                                    file.copyTo(destFile, overwrite = true)
                                    //file.delete()
                                }
                            }

                            arr_after.add(row)
                            array = array.sliceArray(0 until index) + array.sliceArray(index + 1 until array.size)
                            k += 1
                            fk = 1
                            if (after_numbers[secondInd] >= min) {
                                k = 2
                                sk = 1
                                break@loop
                            }
                            break@loopfk
                        }
                    }
                }
                if (sk != 1) {
                    loopsk@ for ((index, row) in array.withIndex()) {
                        if ((row[1] == secondInd.toString() && row[0] != min_after[9].toString() && row[0] != min_after[8].toString()) or (row[0] == secondInd.toString() && row[1] != min_after[9].toString() && row[1] != min_after[8].toString())) {
                            val direct = File(dir)
                            oldDirImage.listFiles()?.forEach { file ->
                                if (file.name == row[2].plus(".jpg")) {
                                    val destFile = File(newDirImage, file.name)
                                    file.copyTo(destFile, overwrite = true)
                                    //file.delete()
                                }
                            }
                            direct.listFiles()?.forEach { file ->
                                if (file.name == row[2].plus(".txt")) {
                                    val destFile = File(newDirLabel, file.name)
                                    file.copyTo(destFile, overwrite = true)
                                    //file.delete()
                                }
                            }

                            arr_after.add(row)
                            array = array.sliceArray(0 until index) + array.sliceArray(index + 1 until array.size)
                            k += 1
                            sk = 1
                            if (after_numbers[firstInd] >= min) {
                                k = 2
                                sk = 1
                                break@loop
                            }
                            break@loopsk
                        }
                    }
                }
            }
            if(sk == 0){if (after_numbers[secondInd] < min && after_numbers[firstInd] >= min) {
                loopsk@ for ((index, row) in array.withIndex()) {
                    if ((row[1] == secondInd.toString() && row[0] != min_after[9].toString() && row[0] != min_after[8].toString()) or (row[0] == secondInd.toString() && row[1] != min_after[9].toString() && row[1] != min_after[8].toString())) {
                        val direct = File(dir)
                        oldDirImage.listFiles()?.forEach { file ->
                            if (file.name == row[2].plus(".jpg")) {
                                val destFile = File(newDirImage, file.name)
                                file.copyTo(destFile, overwrite = true)
                            //file.delete()
                            }
                        }
                        direct.listFiles()?.forEach { file ->
                            if (file.name == row[2].plus(".txt")) {
                                val destFile = File(newDirLabel, file.name)
                                file.copyTo(destFile, overwrite = true)
                            //file.delete()
                            }
                        }
                        arr_after.add(row)
                        array = array.sliceArray(0 until index) + array.sliceArray(index + 1 until array.size)
                        k = 2
                        sk = 1
                        if (after_numbers[firstInd] >= min) {
                            sk = 1
                            break@loop
                        }
                        break@loopsk
                    }
                    }
                }
            }
            if(fk == 0){if (after_numbers[firstInd] < min && after_numbers[secondInd] >= min) {
                loopfk@ for ((index, row) in array.withIndex()) {
                    if ((row[0] == firstInd.toString() && row[1] != min_after[9].toString() && row[1] != min_after[8].toString()) or (row[1] == firstInd.toString() && row[0] != min_after[9].toString() && row[0] != min_after[8].toString())) {
                        val direct = File(dir)
                        oldDirImage.listFiles()?.forEach { file ->
                            if (file.name == row[2].plus(".jpg")) {
                                val destFile = File(newDirImage, file.name)
                                file.copyTo(destFile, overwrite = true)
                            //file.delete()
                            }
                        }
                        direct.listFiles()?.forEach { file ->
                            if (file.name == row[2].plus(".txt")) {
                                val destFile = File(newDirLabel, file.name)
                                file.copyTo(destFile, overwrite = true)
                            //file.delete()
                            }
                        }
                        arr_after.add(row)
                        array =
                            array.sliceArray(0 until index) + array.sliceArray(index + 1 until array.size)
                        k = 2
                        fk = 1
                        if (after_numbers[secondInd] >= min) {
                            sk = 1
                            break@loop
                        }
                        break@loopfk
                    }
                }
            }
            }

            after_zeros()
            score_after()
            if (after_numbers.any { it >= min }){
                k = 2
            }
        }
    }
    for (r in after_numbers) {
        print(" ".plus(r))
    }
    println()
}


fun main() {
    val dir = "C:/Users/DaaNIK/IdeaProjects/ds_app/src/old_ds/labels/"
    listFilesInDirectory(dir)
    score_befor()
    for (r in before_numbers) {
        print(" ".plus(r))
    }
    println()
    val min = before_numbers.min()
    println(min)
    completion(min, dir)
}