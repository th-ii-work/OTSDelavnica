import jakarta.inject.Singleton
import kotlinx.datetime.LocalDate

@Singleton
class ConferenceService {

    private val conferences: MutableMap<Long, Conference> = mutableMapOf()
    private var currentId: Long = 1

    init {
        // Dodajte nekaj konferenc v init bloku
        val conference1 =
            Conference(name = "OTS 2015", startDate = LocalDate(2015, 6, 25), endDate = LocalDate(2015, 6, 27))
        val conference2 =
            Conference(name = "OTS 2016", startDate = LocalDate(2016, 6, 10), endDate = LocalDate(2016, 6, 12))
        val conference3 =
            Conference(name = "OTS 2017", startDate = LocalDate(2017, 6, 10), endDate = LocalDate(2017, 6, 12))
        val conference4 =
            Conference(name = "OTS 2018", startDate = LocalDate(2018, 6, 10), endDate = LocalDate(2018, 6, 12))
        val conference5 =
            Conference(name = "OTS 2022", startDate = LocalDate(2022, 9, 10), endDate = LocalDate(2022, 9, 11))
        val conference6 =
            Conference(name = "OTS 2023", startDate = LocalDate(2023, 9, 6), endDate = LocalDate(2023, 9, 7))

        createConference(conference1)
        createConference(conference2)
        createConference(conference3)
        createConference(conference4)
        createConference(conference5)
        createConference(conference6)
    }

    fun getAllConferences(): List<Conference> {
        return conferences.values.toList()
    }

    fun getConferenceById(id: Long): Conference? {
        return conferences[id]
    }

    fun createConference(conference: Conference): Conference {
        val id = currentId++
        val newConference = conference.copy(id = id)
        conferences[id] = newConference
        return newConference
    }

    fun updateConference(id: Long, updatedConference: Conference): Conference? {
        return conferences[id]?.let { existingConference ->
            val updated = existingConference.copy(
                name = updatedConference.name,
                startDate = updatedConference.startDate,
                endDate = updatedConference.endDate
            )
            conferences[id] = updated
            updated
        }
    }

    fun deleteConference(id: Long): Boolean {
        return conferences.remove(id) != null
    }

    fun filterConferencesByStartDate(startDate: LocalDate): List<Conference> {
        return conferences.values.filter { it.startDate?.compareTo(startDate) == 1 }
    }

    // TODO Dodajte funkcijo filterConferences, ki bo sprejela seznam konferenc in funkcijo, ki bo vrnila true ali false

}