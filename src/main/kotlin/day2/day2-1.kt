package day2

import kotlin.math.absoluteValue

fun main() {
    val result = getReports()
        .count { isSafe(it) }

    println(result)
}

fun isSafe(report: List<Int>): Boolean {
    var asc: Boolean? = null
    report.zipWithNext()
        .forEach { (prev, next) ->
            if (prev == next || (prev - next).absoluteValue > 3) {
                return false
            }
            asc?.let {
                if (it != prev < next) {
                    return false
                }
            } ?: run { asc = prev < next }
        }
    return true
}