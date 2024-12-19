package de.happyhepo.adventofcode.day4

import de.happyhepo.adventofcode.Direction

fun main() {
    val matrix = getMatrix()

    val result = matrix.indices.sumOf { x ->
        matrix[x].indices.sumOf { y ->
            Direction.entries.count {
                assertTerm(matrix = matrix, coord = x to y, direction = it.delta, term = "XMAS")
            }
        }
    }
    println(result)
}