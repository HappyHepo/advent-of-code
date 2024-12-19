package de.happyhepo.adventofcode.day5

import java.io.File

@Suppress("UNCHECKED_CAST")
fun getRulesAndUpdates() = File("inputs/day5")
    .bufferedReader()
    .use { reader ->
        reader.lines()
            .filter { it.isNotBlank() }
            .map { line ->
                Regex("""(\d+)\|(\d+)""").find(line)?.let {
                    it.groupValues[1].toInt() to it.groupValues[2].toInt()
                }
                    ?: line.split(",").map { it.toInt() }
            }
            .toList()
            .partition { it is Pair<*, *> }
            .let { it as Pair<List<Pair<Int, Int>>, List<List<Int>>> }
            .let { (ruleList, updateList) -> ruleList.groupBy({ it.first }) { it.second } to updateList }
    }

fun validateUpdate(rules: Map<Int, List<Int>>, update: List<Int>): Boolean =
    update.foldIndexed(true) { i, result, value ->
        result && rules[value]?.none { update.subList(0, i).contains(it) } ?: true
    }