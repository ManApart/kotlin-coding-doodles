import kotlin.test.Test

class GherkinBuilderExample {

    @Test
    fun firstTest() {
        scenario("Add two numbers") {
            given { it hasFirstNumber 50 }
            and { it hasSecondNumber 70 }
            where { numbersAreAdded() }
            then { it shouldHaveResult 120 }
        }
    }
}