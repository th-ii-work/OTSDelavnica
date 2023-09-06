package si.um.feri

import java.util.Random
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType

@Path("/reactive-todo")
class ReactiveTODOResource {

    // TODO: Ustvari Uni, ki vrne niz "Pozdravljeni na delavnici OTS 2023."
    val uspehUni: Uni<String> = TODO()

    // TODO: Ustvari Uni, ki vrne neuspeh z napako RuntimeException("Oops!")
    val neuspehUni: Uni<String> = TODO()

    // TODO spremenljivko sekcije spremeni tako, da bo namesti seznama nizov Multi<String>
    val sekcije = listOf(
        "9:15 – 10:30 IZZIVI PRIHODNOSTI",
        "10:50 – 12:30 DEVOPS V PRAKSI",
        "13:50 – 15:30 INOVATIVNI PRISTOPI K RAZVOJU MOBILNIH IN SPLETNIH REŠITEV",
        "15:50 – 17:30 KIBERNETSKA VARNOST IN KAKOVOST",
        "9:00 – 10:15 PREKO TEORIJE V PRAKSO",
        "10:35 – 12:15 PODATKOVNE TEHNOLOGIJE",
        "13:30 – 15:10 UMETNA INTELIGENCA - POTENCIAL IN PRAKTIČNE IZKUŠNJE",
        "15:20 DELAVNICE"
    )

    val uspehAliNeuspeh = {
        if(Random().nextBoolean()){
            uspehUni
        }
        else{
            neuspehUni
        }
    }


    @GET
    @Path("/uni-uspeh")
    @Produces(MediaType.TEXT_PLAIN)
    fun uniUspeh(): Uni<String> {
        // TODO: Naroči se na uspešen Uni element in vrni rezultat.
        return TODO()
    }

    @GET
    @Path("/uni-neuspeh")
    @Produces(MediaType.TEXT_PLAIN)
    fun uniNeuspeh(): Uni<String> {
        // TODO: uprabi spremenljivo uspehAliNeuspeh se naročite na Uni in vrnite uspešen rezultat ali napako
        return TODO()
    }

    @Path("/sekcije")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // TODO: ustvari reaktivno končno točko, ki reaktivno vrne seznam sekcij z uporabo Multi<>
    fun multiOperatorji(): Multi<String> {
        //TODO 1 naroči se na Multi element sekcije in z uporabo metode map() vse zapise pretvori v majhne črke
        //TODO 2 subscribe() dopolni tako, da filtriraš (obdržiš) le nize, ki se začnejo z "13"
        //TODO 3 subsrcibe() dopolni tako, da z uporabo metode transform() vsem elementom na začetek dodaš niz "Sekcija: "
        //TODO 4 vrni preostale nize
        return TODO()
    }


}