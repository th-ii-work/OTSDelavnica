package si.um.feri

import jakarta.ws.rs.Path
import java.util.Random
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import si.um.feri.models.Predstavitev
import si.um.feri.repository.PredstavitevRepository

@Path("/reactive-primer")
class ReactivePrimerResource {
    @Inject
    lateinit var predstavitevRepository: PredstavitevRepository

    @Path("/pretakaj-predstavitve")
    @GET
    fun pretakajVsePredstavitve(): Multi<Predstavitev> = predstavitevRepository.pretakajVsePredstavitve()

    @Path("/predstavitve")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun vrniVsePredstavitve() : Uni<List<Predstavitev>> = predstavitevRepository.vrniVsePredstavitve()

    @Path("/predstavitev/{naslov}")
    @GET
    fun vrniPredstavitevPoNaslovu(@PathParam("naslov") naslov: String) : Uni<Predstavitev> = predstavitevRepository.vrniPoNaslovu(naslov)

}