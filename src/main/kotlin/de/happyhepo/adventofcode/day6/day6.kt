package de.happyhepo.adventofcode.day6

import de.happyhepo.adventofcode.Coordinate
import de.happyhepo.adventofcode.Direction
import de.happyhepo.adventofcode.getOrNull
import de.happyhepo.adventofcode.plus
import java.io.File

fun getField() = File("inputs/day6")
    .bufferedReader()
    .use { reader ->
        reader.lines()
            .map { line ->
                line.map {
                    when (it) {
                        '#' -> FieldType.Obstacle
                        '.' -> FieldType.Unvisited
                        else -> FieldType.Visited
                    }
                }
                    .toList()
                    .toTypedArray()
            }
            .toList()
            .toTypedArray()
    }

fun tryMove(field: Array<Array<FieldType>>, guard: Guard): Boolean =
    when (field.getOrNull(guard.lookingAt)) {
        FieldType.Obstacle -> {
            guard.turn()
            true
        }

        FieldType.Unvisited, FieldType.Visited -> {
            guard.move()
            field[guard.position.first][guard.position.second] = FieldType.Visited
            true
        }

        null -> false
    }

class Guard(
    position: Coordinate,
    direction: Direction
) {
    var position = position
        private set
    var direction = direction
        private set
    val lookingAt
        get() = position + direction.delta

    fun move() {
        position = lookingAt
    }

    fun turn() {
        direction = direction.turn90()
    }

    companion object {
        fun find(field: Array<Array<FieldType>>): Guard = Guard(
            field.mapIndexedNotNull { outer, line ->
                line.indexOf(FieldType.Visited)
                    .let { if (it == -1) null else outer to it }
            }.first(),
            Direction.N
        )
    }
}

enum class FieldType {
    Obstacle,
    Unvisited,
    Visited
}
