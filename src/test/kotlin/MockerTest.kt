import kotlin.test.Test
import kotlin.test.assertTrue

class MockerTest {
    @Test
    fun lotsOMocks(){
        val builder = MockBuilder()
        val transformer = MockTransformer()
        val polisher = MockPolisher()

        doServiceThing(builder, transformer, polisher)

        assertTrue(builder.assertCalled())
        assertTrue(transformer.assertCalled())
        assertTrue(polisher.assertCalled())
    }
}