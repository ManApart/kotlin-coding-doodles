class Calculator(
    var firstNumber: Int = 0,
    var secondNumber: Int = 0
) {
    var result = 0
    
    fun add() {
        result = firstNumber + secondNumber
    }
}

