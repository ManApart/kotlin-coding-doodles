class Calculator(var firstNumber: Int, var secondNumber: Int)

//Test Helper functions
infix fun Calculator.hasFirstNumber(amount: Int){
}
infix fun Calculator.hasSecondNumber(amount: Int){
}
fun numbersAreAdded(){
}

infix fun Calculator.shouldHaveResult(amount: Int){
}

class ScenarioBuilder(val description: String){
    fun given(condition: (Calculator) -> Unit){
    }
    fun and(condition: (Calculator) -> Unit){
    }
    fun where(condition: (Calculator) -> Unit){
    }
    fun then(condition: (Calculator) -> Unit){
    }

    fun run(){
        //Compiles the given,whens and then, runs asserts as part of the then
    }
}

fun scenario(description: String, customizer: ScenarioBuilder.() -> Unit) {
    ScenarioBuilder(description).apply(customizer).run()
}