package com.thoughtworks.kotlin_basic.util
private const val MAX_SEQUENCE_NUMBER = 18278 // ZZZ corresponds to 18278 in base-10

class ConvertToLabel {
    fun numberToColumnLabel(start: Int, count: Int): List<String> {

        if (start <= 0 || count <= 0) throw IllegalArgumentException("Parameters must be greater than zero")
        if (start > MAX_SEQUENCE_NUMBER) throw IllegalArgumentException("Starting sequence number exceeds the maximum allowed value")
        val columnLabels = mutableListOf<String>()

        for (i in 0 until count) {
            columnLabels.add(convertToLabel(start + i))
        }

        return columnLabels
    }

    private fun convertToLabel(number: Int): String {
        if (number <= 0) throw IllegalArgumentException("Number must be greater than zero")

        var num = number
        val label = StringBuilder()

        while (num > 0) {
            num-- // Adjust for 0-based index
            val char = ('A' + (num % 26))
            label.append(char)
            num /= 26
        }

        return label.reverse().toString()
    }

}