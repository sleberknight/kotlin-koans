package v_builders

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class _37_String_And_Map_Builders {
    @Test fun testBuildMap() {
        val map = task37()
        val expected = HashMap<Int, String>()
        for (i in 0..10) {
            expected[i] = "$i"
        }
        assertEquals("Map should be filled with the right values", expected, map)
    }

    @Test fun testBuildString() {
        val result = buildStringExample()
        val builder = StringBuilder("Numbers: ")
        for (i in 1..10) {
            builder.append(i)
        }
        val expected = builder.toString()
        assertEquals(expected, result)
    }

    @Test fun testAnotherLambdaWithReceiverExampleUsingSets() {
        fun buildSet(builder: MutableSet<String>.() -> Unit): Set<String> {
            val set : MutableSet<String> = mutableSetOf()

            set.builder()

            return set
        }

        val result = buildSet {
            add("one")
            add("one")
            add("one")
            add("one")
            add("three")
            addAll(listOf("one", "two", "three", "four"))
        }

        assertEquals(setOf("one", "two", "three", "four"), result)
    }
}