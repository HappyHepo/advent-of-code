package day1

import java.io.File

fun getLists(): Pair<MutableList<Int>, MutableList<Int>> {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    File("inputs/day1")
        .bufferedReader()
        .use { reader ->
            reader.lines()
                .map { line -> line.split("   ").let { it[0].toInt() to it[1].toInt() } }
                .forEach { (a, b) ->
                    list1.addLast(a)
                    list2.addLast(b)
                }
        }
    return list1 to list2
}