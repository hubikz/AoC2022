fun main() {
    // a..z ->  1..25
    // A..Z -> 26..52
    fun charToPriority(char: Char): Int {
        return Character.getNumericValue(char) - 9 + if (Character.isUpperCase(char)) 26 else 0
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { items ->
            val halfIndex = items.length / 2
            val compartment1 = items.toCharArray(0, halfIndex)
            val compartment2 = items.toCharArray(halfIndex)

            val element = compartment1.first { compartment2.contains(it) }
            charToPriority(element)
        }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf {
            val (first, second, third) = it

            val element = first.first { char -> second.contains(char) && third.contains(char) }
            charToPriority(element)
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 70)
    println("Part 2: ${part2(input)}")
}
