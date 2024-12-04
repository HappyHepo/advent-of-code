package day4

fun main() {
    val matrix = getMatrix()

    val result = matrix.indices.sumOf { x ->
        matrix[x].indices.sumOf { y ->
            (-1..1).sumOf { dx ->
                (-1..1).count { dy ->
                    assertTerm(matrix = matrix, coord = x to y, direction = dx to dy, term = "XMAS")
                }
            }
        }
    }
    println(result)
}