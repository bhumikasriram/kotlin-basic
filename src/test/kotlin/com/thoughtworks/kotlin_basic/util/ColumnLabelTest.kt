package com.thoughtworks.kotlin_basic.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import kotlin.test.assertFailsWith

class ColumnLabelTest {
    var label=ConvertToLabel()

    @Test
    fun testSingleLabel() {
        assertEquals(listOf("A"), label.numberToColumnLabel(1, 1))
        assertEquals(listOf("Z"), label.numberToColumnLabel(26, 1))
    }

    @Test
    fun testMultipleLabels() {
        assertEquals(listOf("A", "B", "C"), label.numberToColumnLabel(1, 3))
        assertEquals(listOf("Z", "AA", "AB"), label.numberToColumnLabel(26, 3))
        assertEquals(listOf("AA", "AB", "AC"), label.numberToColumnLabel(27, 3))
        assertEquals(listOf("ZZ", "AAA", "AAB"), label.numberToColumnLabel(702, 3))
    }

    @Test
    fun testInvalidInputs() {
        assertFailsWith<IllegalArgumentException> {
            label.numberToColumnLabel(0, 1)
        }
        assertFailsWith<IllegalArgumentException> {
            label.numberToColumnLabel(1, 0)
        }
        assertFailsWith<IllegalArgumentException> {
            label.numberToColumnLabel(-1, 2)
        }
        assertFailsWith<IllegalArgumentException> {
            label.numberToColumnLabel(1, -1)
        }
    }

    @Test
    fun testUpperLimit() {
        // The upper limit in this case can be assumed up to 3 characters, i.e., ZZZ (18278 in base-10)
        assertEquals(listOf("ZZZ"), label.numberToColumnLabel(18278, 1))

        assertFailsWith<IllegalArgumentException> {
            label.numberToColumnLabel(2000000, 1) // This should throw an error as it exceeds "ZZZ"
        }
    }
}
