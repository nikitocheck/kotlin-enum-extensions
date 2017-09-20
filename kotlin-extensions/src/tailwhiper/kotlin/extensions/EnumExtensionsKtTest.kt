package tailwhiper.kotlin.extensions

import org.junit.Assert.assertEquals
import org.junit.Test


class EnumExtensionsKtTest {

    private enum class TestEnum {FIRST, LAST }

    @Test
    fun valueOfFindsIgnoreCase() {
        assertEquals(valueOfIgnoreCase<TestEnum>("First"), TestEnum.FIRST)
    }

    @Test
    fun valueOfReturnsDefault() {
        assertEquals(valueOf<TestEnum>("no enum", TestEnum.FIRST), TestEnum.FIRST)
    }
    @Test
    fun valueOfFindsByOrdinal() {
        assertEquals(valueOf<TestEnum>(0,TestEnum.LAST), TestEnum.FIRST)
    }

    @Test
    fun valueOfByOrdinalReturnsDefault() {
        assertEquals(valueOf<TestEnum>(100, TestEnum.LAST), TestEnum.LAST)
    }

    @Test
    fun valueOfReturnsFound() {
        assertEquals(valueOf<TestEnum>("LAST", TestEnum.LAST), TestEnum.LAST)
    }


    @Test
    fun valueOfWithConditionFindsCondition() {
        assertEquals(valueOfWithCondition<TestEnum> { it.ordinal == 0 }, TestEnum.FIRST)
    }

    @Test
    fun valueOfWithConditionFoundNothing() {
        assertEquals(valueOfWithCondition<TestEnum> { it.ordinal == 3 }, null)
    }

    @Test
    fun valueOfWithConditionFoundNothingReturnsDefault() {
        assertEquals(valueOfWithCondition<TestEnum>({ it.ordinal == 3 }, TestEnum.LAST), TestEnum.LAST)
    }

}