fun main() {

    fun carriedCaloriesByTopElves(input: List<String>, elvesNbr: Int): Int {
        var elves = mutableListOf<MutableList<Int>>()
        var tmp = mutableListOf<Int>()
        for (caloric in input) {
            if (caloric.isNotEmpty()) {
                tmp.add(caloric.toInt())
            } else {
                elves.add(tmp)
                tmp = mutableListOf()
            }
        }
        elves.add(tmp)

        return elves.map { it.sum() }.sortedDescending().slice(IntRange(0, elvesNbr-1)).sum()
    }

    fun part1(input: List<String>): Int {
        return carriedCaloriesByTopElves(input, 1)
    }

    fun part2(input: List<String>): Int {
        return carriedCaloriesByTopElves(input, 3)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 45000)
    println("Part 2: ${part2(input)}")
}
