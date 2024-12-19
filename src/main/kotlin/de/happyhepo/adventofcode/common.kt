package de.happyhepo.adventofcode

typealias Coordinate = Pair<Int, Int>

operator fun Coordinate.plus(other: Coordinate): Coordinate = first + other.first to second + other.second
operator fun Coordinate.times(factor: Int): Coordinate = first * factor to second * factor

inline fun <reified T> Array<Array<T>>.deepCopyOf() = Array(size) { get(it).copyOf() }
fun <T> Array<Array<T>>.getOrNull(coordinate: Coordinate): T? =
    getOrNull(coordinate.first)?.getOrNull(coordinate.second)

enum class Direction(val delta: Coordinate) {
    N(-1 to 0),
    NE(-1 to 1),
    E(0 to 1),
    SE(1 to 1),
    S(1 to 0),
    SW(1 to -1),
    W(0 to -1),
    NW(-1 to -1),
    O(0 to 0);

    fun turn90() = when (this) {
        N -> E
        NE -> SE
        E -> S
        SE -> SW
        S -> W
        SW -> NW
        W -> N
        NW -> NE
        O -> O
    }
}
