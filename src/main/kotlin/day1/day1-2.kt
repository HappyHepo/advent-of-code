package day1

fun main() {
    val (list1, list2) = getLists()

    val result = list1
        .sumOf { elem -> elem * list2.count { it == elem } }

    println(result)
}