package day01

import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("day01/Day01")
    println(part1(input))
    println(part2(input))
}

private fun part1(input: List<String>): Int {
    val elvenInventories = elvenInventoriesFrom(input)
    return elvenInventories.max()
}

fun part2(input: List<String>): Int {
    val elvenInventories = elvenInventoriesFrom(input)
    return elvenInventories
        .sortedDescending()
        .take(3)
        .sum()
}

private fun elvenInventoriesFrom(input: List<String>): List<Int> {
    val elvenInventories = mutableListOf<Int>()
    var currentInventory = 0
    input.forEach {
        if (it.isBlank()) {
            elvenInventories.add(currentInventory)
            currentInventory = 0
        } else {
            val currentValue = it.toInt()
            currentInventory += currentValue
        }
    }
    elvenInventories.add(currentInventory)
    return elvenInventories
}
