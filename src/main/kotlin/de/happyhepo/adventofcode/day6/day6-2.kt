package de.happyhepo.adventofcode.day6

import de.happyhepo.adventofcode.Coordinate
import de.happyhepo.adventofcode.Direction
import de.happyhepo.adventofcode.deepCopyOf

fun main() {
    val field = getField()
    val original = field.deepCopyOf()
    val guard = Guard.find(field)
    val start = guard.position
    while (tryMove(field, guard)) {
    }
    print(field.flatMapIndexed { outer, line ->
        line.mapIndexedNotNull { inner, fieldType ->
            if (fieldType == FieldType.Visited && outer to inner != start) outer to inner else null
        }
    }
        .count {
            isLoop(
                field = original.deepCopyOf().apply {
                    this[it.first][it.second] = FieldType.Obstacle
                },
                guard = Guard(start, Direction.N)
            )
        })
}

fun isLoop(field: Array<Array<FieldType>>, guard: Guard): Boolean {
    val visited = mutableListOf<Pair<Coordinate, Direction>>()
    while (tryMove(field, guard)) {
        if (visited.contains(guard.position to guard.direction)) {
            return true
        } else {
            visited.add(guard.position to guard.direction)
        }
    }
    return false
}