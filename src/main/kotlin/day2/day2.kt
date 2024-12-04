package day2

import java.io.File

fun getReports(): List<List<Int>> =
    File("inputs/day2")
        .bufferedReader()
        .use { reader ->
            reader.lines()
                .map { line -> line.split(" ").map { it.toInt() } }
                .toList()
        }
