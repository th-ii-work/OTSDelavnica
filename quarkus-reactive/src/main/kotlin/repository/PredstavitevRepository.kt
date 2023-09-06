package si.um.feri.repository

import io.quarkus.mongodb.panache.PanacheMongoRepository
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import jakarta.enterprise.context.ApplicationScoped
import si.um.feri.models.Predstavitev

@ApplicationScoped
class PredstavitevRepository: ReactivePanacheMongoRepository<Predstavitev> {
     fun pretakajVsePredstavitve(): Multi<Predstavitev> = streamAll()
     fun vrniVsePredstavitve(): Uni<List<Predstavitev>> = listAll()
     fun vrniPoNaslovu(naslov: String): Uni<Predstavitev> = find("title", naslov).firstResult<Predstavitev>()
}