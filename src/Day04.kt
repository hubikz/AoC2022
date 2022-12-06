fun main() {

    fun pairElves(it: String): Pair<List<Int>, List<Int>> {
        val (left, right) = it.split(",")
        val (leftStart, leftStop) = left.split("-")
        val (rightStart, rightStop) = right.split("-")

        val leftRange = (leftStart.toInt()..leftStop.toInt()).toList()
        val rightRange = (rightStart.toInt()..rightStop.toInt()).toList()
        return Pair(leftRange, rightRange)
    }

    fun part1(input: List<String>): Int {
        val result = input.map {
            val (leftRange, rightRange) = pairElves(it)

            if (leftRange.containsAll(rightRange) || rightRange.containsAll(leftRange)) 1 else 0
        }

        return result.sum()
    }

    fun part2(input: List<String>): Int {
        val result = input.map {
            val (leftRange, rightRange) = pairElves(it)

            if (leftRange.firstOrNull { section -> rightRange.contains(section) } != null) 1 else 0
        }

        return result.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 4)
    println("Part 2: ${part2(input)}")
}
