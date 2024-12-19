package de.happyhepo.adventofcode.day3

import java.io.File
import java.util.stream.Collectors

fun main() {
    val result = File("inputs/day3")
        .bufferedReader()
        .use { reader ->
            val enabled = reader.lines().collect(Collectors.joining())
                .replace(DO_DONT_REGEX, "")
            MUL_REGEX.findAll(enabled)
                .sumOf { it.groupValues[1].toInt() * it.groupValues[2].toInt() }
        }
    println(result)
}
