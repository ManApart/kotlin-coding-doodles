import java.awt.Color

class Past(val events: List<String>)

class YoungPerson(val name: String, val eyeColor: Color, var age: Int, val past: Past){
    fun age(years: Int){
        this.age += years
    }
}