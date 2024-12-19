package de.happyhepo.adventofcode.day5

fun main() {
    val (rules, updates) = getRulesAndUpdates()

    val result = updates.filter { !validateUpdate(rules, it) }
        .map { fixOrder(rules, it) }
        .sumOf { it[(it.size / 2)] }

    println(result)
}

fun fixOrder(rules: Map<Int, List<Int>>, update: List<Int>): List<Int> {
    val output = mutableListOf<Int>()
    update.forEach { value ->
        val before = (rules[value]?.filter { output.contains(it) } ?: listOf())
        output.indexOfFirst { before.contains(it) }
            .let { if (it == -1) output.add(value) else output.add(it, value) }
    }
    return output
}
