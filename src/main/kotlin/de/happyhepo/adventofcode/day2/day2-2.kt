package de.happyhepo.adventofcode.day2

import kotlin.math.absoluteValue

fun main() {
    val result = getReports()
        .count { report ->
            firstUnsafeIndex(report)?.let {
                if (firstUnsafeIndex(report.filterIndexed { i, _ -> i != it }) == null
                    || firstUnsafeIndex(report.filterIndexed { i, _ -> i != it + 1 }) == null
                    || firstUnsafeIndex(report.filterIndexed { i, _ -> i != it - 1 }) == null)
                    null
                else it
            } == null
        }

    println(result)
}

fun firstUnsafeIndex(report: List<Int>): Int? {
    var asc: Boolean? = null
    report.zipWithNext()
        .forEachIndexed { i, (prev, next) ->
            if (prev == next || (prev - next).absoluteValue > 3) {
                return i
            }
            asc?.let {
                if (it != prev < next) {
                    return i
                }
            } ?: run { asc = prev < next }
        }
    return null
}