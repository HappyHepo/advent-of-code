package de.happyhepo.adventofcode.day4

import de.happyhepo.adventofcode.Coordinate
import de.happyhepo.adventofcode.plus
import de.happyhepo.adventofcode.times
import java.io.File

fun getMatrix() = File("inputs/day4")
    .bufferedReader()
    .use { reader ->
        reader.lines()
            .map { line -> line.toCharArray() }
            .toList()
            .toTypedArray()
    }

fun assertChar(matrix: Array<CharArray>, coord: Coordinate, char: Char): Boolean =
    coord.first >= 0 && coord.second >= 0 && coord.first < matrix.size && matrix[coord.first].let {
        coord.second < it.size && it[coord.second] == char
    }

fun assertTerm(matrix: Array<CharArray>, coord: Coordinate, direction: Coordinate, term: String): Boolean =
    term.foldIndexed(true) { i, result, char ->
        result && assertChar(matrix = matrix, coord = coord + (direction * i), char = char)
    }