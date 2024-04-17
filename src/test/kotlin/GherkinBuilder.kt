import kotlin.test.assertEquals

infix fun Calculator.hasFirstNumber(amount: Int){
    firstNumber = amount
}
infix fun Calculator.hasSecondNumber(amount: Int){
    secondNumber = amount
}

fun ScenarioBuilder.numbersAreAdded(){
    subject.add()
}

infix fun Calculator.shouldHaveResult(amount: Int){
    assertEquals(amount, result)
}

class ScenarioBuilder(val description: String){
    val subject: Calculator = Calculator()
    private val thens = mutableListOf<(Calculator) -> Unit>()

    fun and(condition: (Calculator) -> Unit) = given(condition)
    fun given(condition: (Calculator) -> Unit){
        condition(subject)
    }

    fun where(condition: (Calculator) -> Unit){
        condition(subject)
    }

    fun then(condition: (Calculator) -> Unit){
        thens.add(condition)
    }

    fun run(){
        thens.forEach { it(subject) }
    }
}

fun scenario(description: String, customizer: ScenarioBuilder.() -> Unit) {
    ScenarioBuilder(description).apply(customizer).run()
}