package day4

import java.io.File

typealias Coordinate = Pair<Int, Int>

operator fun Coordinate.plus(other: Coordinate): Coordinate = first + other.first to second + other.second
operator fun Coordinate.times(factor: Int): Coordinate = first * factor to second * factor

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