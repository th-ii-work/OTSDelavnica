import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import kotlinx.datetime.LocalDate
import org.eclipse.microprofile.openapi.annotations.Operation

@Path("/conferences")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ConferenceResource {

    @Inject
    lateinit var conferenceService: ConferenceService

    @GET
    @Operation(summary = "Vrne seznam vseh konferenc")
    fun getAllConferences(): List<Conference> = conferenceService.getAllConferences()

    @GET
    @Path("/{id}")
    @Operation(summary = "Vrne konferenco glede na ID")
    fun getConferenceById(@PathParam("id") id: Long): Conference? = conferenceService.getConferenceById(id)

    @POST
    @Operation(summary = "Ustvari novo konferenco")
    fun createConference(@Valid conference: Conference): Response {
        val createdConference = conferenceService.createConference(conference)
        return Response.status(Response.Status.CREATED).entity(createdConference).build()
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Posodobi konferenco glede na ID")
    fun updateConference(@PathParam("id") id: Long, @Valid updatedConference: Conference): Response {
        return conferenceService.updateConference(id, updatedConference)?.let {
            Response.ok(it).build()
        } ?: Response.status(Response.Status.NOT_FOUND).build()
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Izbriše konferenco glede na ID")
    fun deleteConference(@PathParam("id") id: Long): Response {
        return if (conferenceService.deleteConference(id)) {
            Response.noContent().build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @GET
    @Path("/filter")
    @Operation(summary = "Filtrira konference po začetnem datumu")
    fun filterConferences(@QueryParam("startDate") startDate: String): List<Conference> {
        val parsedStartDate = LocalDate.parse(startDate)
        return conferenceService.filterConferencesByStartDate(parsedStartDate)
    }

    // TODO Get request za filtriranje konferenc po različnih kriterijih (npr. začetni datum) -> uncomment
    /*
    @GET
    @Path("/filterHighOrder")
    @Operation(summary = "Filtrira konference po različnih kriterijih")
    fun filterConferences(
        @QueryParam("startDate") startDate: String?,
        @QueryParam("futureOnly") futureOnly: Boolean?
    ): List<Conference> {
        val allConferences = conferenceService.getAllConferences()

        // Filtriranje na podlagi začetnega datuma, če je parameter prisoten
        val filteredConferences = if (!startDate.isNullOrEmpty()) {
            val parsedStartDate = LocalDate.parse(startDate)
            conferenceService.filterConferences(allConferences) { conference ->
                conference.startDate?.let { it > parsedStartDate } ?: false
            }
        } else {
            allConferences
        }

        // Filtriranje glede na futureOnly parameter
        val filteredByFuture = if (futureOnly == true) {
            val currentDate = LocalDate.parse(
                Instant.fromEpochMilliseconds(System.currentTimeMillis())
                    .toLocalDateTime(TimeZone.currentSystemDefault()).date.toString()
            )
            filteredConferences.filter { conference ->
                conference.startDate?.let { it >= currentDate } ?: false
            }
        } else {
            filteredConferences
        }

        // Dodatni filtri glede na potrebe

        return filteredByFuture
    }
     */
}