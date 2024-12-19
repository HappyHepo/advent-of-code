package de.happyhepo.adventofcode.day1

import kotlin.math.absoluteValue

fun main() {
    val (list1, list2) = getLists()
    val ordered1 = list1.sorted()
    val ordered2 = list2.sorted()

    val result = ordered1.zip(ordered2)
        .sumOf { (a, b) -> (a - b).absoluteValue }

    println(result)
}