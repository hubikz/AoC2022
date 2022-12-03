enum class Shape {
    ROCK, PAPER, SCISSORS
}
enum class Result {
    LOSE, DRAW, WIN
}
const val LOST_POINTS = 0
const val DRAW_POINTS = 3
const val WON_POINTS = 6

fun main() {
    // A for Rock, B for Paper, and C for Scissors
    // X for Rock, Y for Paper, and Z for Scissors
    // 1 for Rock, 2 for Paper, and 3 for Scissors
    // 0 lose 3 draw 6 win
    val elfShapes = mapOf<String, Shape>("A" to Shape.ROCK, "B" to Shape.PAPER, "C" to Shape.SCISSORS)
    val myShapes = mapOf<String, Shape>("X" to Shape.ROCK, "Y" to Shape.PAPER, "Z" to Shape.SCISSORS)
    val expectedResult = mapOf("X" to Result.LOSE, "Y" to Result.DRAW, "Z" to Result.WIN)

    val defeats = mapOf(Shape.ROCK to Shape.SCISSORS, Shape.SCISSORS to Shape.PAPER, Shape.PAPER to Shape.ROCK)
    val shapePoints = mapOf(Shape.ROCK to 1, Shape.PAPER to 2, Shape.SCISSORS to 3)

    fun part1(input: List<String>): Int {
        return input.sumOf {
            val (left, right) = it.split(" ")
            val elfShape = elfShapes.getValue(left)
            val myShape: Shape = myShapes.getValue(right)

            val gamePoints = when (elfShape) {
                myShape -> {
                    DRAW_POINTS
                }
                defeats.getValue(myShape) -> {
                    WON_POINTS
                }
                else -> {
                    LOST_POINTS
                }
            }
            gamePoints + shapePoints.getValue(myShape)
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            val (left, right) = it.split(" ")
            val elfShape = elfShapes.getValue(left)

            when (expectedResult.getValue(right)) {
                Result.DRAW -> {
                    DRAW_POINTS + shapePoints.getValue(elfShape)
                }
                Result.LOSE -> {
                    LOST_POINTS + shapePoints.getValue(defeats.getValue(elfShape))
                }
                else -> {
                    WON_POINTS + shapePoints.getValue(defeats.entries.associate{ e -> e.value to e.key}.getValue(elfShape))
                }
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 12)
    println("Part 2: ${part2(input)}")
}
