fun main() {

    fun part1(input: List<String>): Int {
        val elvenInventories = elvenInventoriesFrom(input)
        return elvenInventories.maxBy { it.value }.value
    }

    fun part2(input: List<String>): Int {
        val elvenInventories = elvenInventoriesFrom(input)

        return elvenInventories.values
            .sortedDescending()
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

private fun elvenInventoriesFrom(input: List<String>): MutableMap<Int, Int> {
    val elvenInventories = mutableMapOf<Int, Int>()
    var currentElvId = 1
    var currentInventory = 0
    input.forEach {
        if (it.isBlank()) {
            elvenInventories[currentElvId] = currentInventory
            currentElvId++
            currentInventory = 0
        } else {
            val currentValue = it.toInt()
            currentInventory += currentValue
        }
    }
    elvenInventories[currentElvId] = currentInventory
    return elvenInventories
}
