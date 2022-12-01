fun main() {

    fun carriedCaloriesByTopElfs(input: List<String>, elfsNbr: Int): Int {
        var elfs = mutableListOf<MutableList<Int>>()
        var tmp = mutableListOf<Int>()
        for (caloric in input) {
            if (caloric.isNotEmpty()) {
                tmp.add(caloric.toInt())
            } else {
                elfs.add(tmp)
                tmp = mutableListOf()
            }
        }
        elfs.add(tmp)

        return elfs.map { it.sum() }.sortedDescending().slice(IntRange(0, elfsNbr-1)).sum()
    }

    fun part1(input: List<String>): Int {
        return carriedCaloriesByTopElfs(input, 1)
    }

    fun part2(input: List<String>): Int {
        return carriedCaloriesByTopElfs(input, 3)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 45000)
    println("Part 2: ${part2(input)}")
}
