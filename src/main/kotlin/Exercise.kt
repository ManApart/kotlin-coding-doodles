import java.time.LocalDateTime

data class Rep(val weight: Int, val count: Int = 1, var completed: Boolean = false)

data class Exercise(val name: String, val reps: List<Rep>)

data class Day(val name: String, val date: LocalDateTime = LocalDateTime.now(), val exercises: List<Exercise>) {
    fun isComplete(): Boolean {
        return exercises.all { exercise -> exercise.reps.all { it.completed } }
    }

    fun copy(): Day {
        return Day(name, LocalDateTime.now(), exercises.map { exercise ->
            Exercise(exercise.name, exercise.reps.map { rep ->
                Rep(rep.weight, rep.count, false)
            })
        })
    }
}