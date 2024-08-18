import com.thoughtworks.kotlin_basic.util.ConvertToLabel

fun main() {
    println("Enter the starting sequence number:")
    val start = readLine()?.toIntOrNull()
    val label=ConvertToLabel()

    println("Enter the number of results:")
    val count = readLine()?.toIntOrNull()

    if (start == null || count == null || start <= 0 || count <= 0) {
        println("Invalid input. Please enter positive integers.")
        return
    }

    try {
        val result = label.numberToColumnLabel(start, count)
        println("Generated column labels: ${result.joinToString(", ")}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
