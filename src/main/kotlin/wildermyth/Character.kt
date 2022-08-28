package wildermyth

import kotlinx.serialization.Transient

data class LegacyCharacter(val uuid: String, val snapshots: Array<Character>, val companyIds: List<String> = listOf()){
    val friendships = listOf<Friendship>()
}

data class Character(
    val uuid: String,
    val name: String,
    val aspects: List<Aspect> = listOf(),
    val temporal: Map<String, Int> = mapOf(),
    val history: List<HistoryEntry> = listOf(),
    val bio: String = "",
    val male: Boolean = false,
    val characterClass: CharacterClass = CharacterClass.WARRIOR,
    val age: Int = 0,
    val personality: Map<Personality, Int> = mapOf(),
    val family: Family = Family()
)
