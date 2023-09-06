package si.um.feri.models

import org.bson.types.ObjectId
import io.quarkus.mongodb.panache.common.MongoEntity
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity

@MongoEntity(collection="predstavitve")
 class Predstavitev {
    var id: ObjectId? = null
    lateinit var title: String
    lateinit var authors: List<String>
    lateinit var abstract: String
}
