import kotlinx.datetime.LocalDate

data class Conference(
    var id: Long? = null,
    var name: String? = null,
    var startDate: LocalDate? = null,
    var endDate: LocalDate? = null
)