fun main() {

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day00_test")
    check(part1(testInput) == 0)

    val input = readInput("Day00")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 12)
    println("Part 2: ${part2(input)}")
}
