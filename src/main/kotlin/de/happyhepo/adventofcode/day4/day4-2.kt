package de.happyhepo.adventofcode.day4

import de.happyhepo.adventofcode.Coordinate
import de.happyhepo.adventofcode.plus
import de.happyhepo.adventofcode.times

fun main() {
    val matrix = getMatrix()

    val result = matrix.indices.sumOf { x ->
        matrix[x].indices.count { y ->
           assertXMas(matrix = matrix, aCoord = x to y)
        }
    }
    println(result)
}

fun assertXMas(matrix: Array<CharArray>, aCoord: Coordinate): Boolean =
    assertChar(matrix = matrix, coord = aCoord, 'A') && listOf(-1,1).sumOf { dx ->
        listOf(-1,1).count { dy ->
            assertTerm(matrix = matrix, coord = aCoord + ((dx to dy) * -1), direction = dx to dy, term = "MAS")
        }
    } == 2