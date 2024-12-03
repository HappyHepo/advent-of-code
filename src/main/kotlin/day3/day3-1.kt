package day3

import java.io.File

fun main() {
    val result = File("input/day3")
        .bufferedReader()
        .use { reader ->
            reader.lines().toList()
                .flatMap { line -> MUL_REGEX.findAll(line) }
                .sumOf { it.groupValues[1].toInt() * it.groupValues[2].toInt() }
        }
    println(result)
}