package gherkin

import Calculator
import kotlin.test.assertEquals

infix fun Calculator.hasFirstNumber(amount: Int) {
    firstNumber = amount
}

infix fun Calculator.hasSecondNumber(amount: Int) {
    secondNumber = amount
}

fun ScenarioBuilder<Calculator>.numbersAreAdded() = subject.add()

infix fun Calculator.shouldHaveResult(amount: Int) = assertEquals(amount, result)

fun scenario(description: String, customizer: ScenarioBuilder<Calculator>.() -> Unit) {
    ScenarioBuilder(Calculator(), description).apply(customizer).run()
}