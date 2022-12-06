import java.io.File

fun main() {

    fun base(input: String, orderTaken: (moved: List<String>) -> List<String>): String {
        val (creates, moves: String) = input.split("\n\n")
        val zm = mutableListOf<MutableList<String>>()
        creates.lines().last().chunked(4).map{ it.trim() }.map {
            zm.add(mutableListOf())
        }
        creates.lines().take(creates.lines().size-1).map {
            it.chunked(4).withIndex().map { (index, value ) -> if (value.trim().isNotEmpty()) zm[index].add(value.trim('[', ']', ' ')) }
        }

        for (move in moves.lines()) {
            val result = move.split(" ")
            val nbr = result[1].toInt()
            val from = result[3].toInt()-1
            val to = result[5].toInt()-1

            zm[to].addAll(0, orderTaken(zm[from].take(nbr)))
            zm[from] = zm[from].drop(nbr).toMutableList()
        }

        return zm.joinToString("") { it[0] }
    }

    fun part1(input: String): String {
        return base(input) { orderTaken -> orderTaken.reversed() }
    }

    fun part2(input: String): String {
        return base(input) { orderTaken -> orderTaken }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/Day05_test.txt").readText()
    check(part1(testInput) == "CMZ")

    val input = File("src/Day05.txt").readText()
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == "MCD")
    println("Part 2: ${part2(input)}")
}
