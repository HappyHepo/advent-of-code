package de.happyhepo.adventofcode.day6

fun main() {
    val field = getField()
    val guard = Guard.find(field)
    while (tryMove(field, guard)) {
    }
    print(field.sumOf { line ->
        line.count { it == FieldType.Visited }
    })
}