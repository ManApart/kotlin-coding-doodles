package gherkin

class ScenarioBuilder<Subject>(val subject: Subject, val description: String){
    private val thens = mutableListOf<(Subject) -> Unit>()

    fun given(condition: (Subject) -> Unit){
        condition(subject)
    }
    fun and(condition: (Subject) -> Unit) = given(condition)
    fun where(condition: (Subject) -> Unit) = given(condition)
    fun then(condition: (Subject) -> Unit) = given(condition)

    fun run(){
        thens.forEach { it(subject) }
    }
}