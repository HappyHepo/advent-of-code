package de.happyhepo.adventofcode.day5

fun main() {
    val (rules, updates) = getRulesAndUpdates()

    val result = updates.filter { validateUpdate(rules, it) }
        .sumOf { it[(it.size / 2)] }

    println(result)
}