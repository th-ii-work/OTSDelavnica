fun main() {
    val udelezenciKonference = mutableListOf(
        UdelezenecKonferenceNon("Janez", "Novak", 3),
        UdelezenecKonferenceNon("Maja", "Kovač", 2),
        UdelezenecKonferenceNon("Luka", "Horvat", 1),
        UdelezenecKonferenceNon("Ana", "Krajnc", 4)
    )

    // Izračun povprečnega števila preteklih udeležb z zanko
    var skupnoUdelezb = 0
    for (udelezenec in udelezenciKonference) {
        skupnoUdelezb += udelezenec.preteklaUdelezba
    }
    val povprecnaUdelezba = skupnoUdelezb.toDouble() / udelezenciKonference.size
    println("Povprečno število preteklih udeležb: $povprecnaUdelezba")

    // TODO Filtriranje udeležencev z visokim številom preteklih udeležb z zanko

    //println("Udeleženci z visokim številom preteklih udeležb: $visokoUdelezeni") TODO uncomment

    // Preslikava seznama udeležencev v seznam imen z zanko
    val imenaUdelezencev = mutableListOf<String>()
    for (udelezenec in udelezenciKonference) {
        imenaUdelezencev.add("${udelezenec.ime} ${udelezenec.priimek}")
    }
    println("Imena udeležencev: $imenaUdelezencev")

    // Sprememba števila preteklih udeležb za udeleženca z uporabo nečiste funkcije
    spremeniUdelezbo(udelezenciKonference, "Janez Novak", 4)
    println("Udeleženci konference po spremembi udeležbe: $udelezenciKonference")
}

// Nečista funkcija za spremembo števila preteklih udeležb za udeleženca
fun spremeniUdelezbo(udelezenci: MutableList<UdelezenecKonferenceNon>, polnoIme: String, novaUdelezba: Int) {
    for (udelezenec in udelezenci) {
        if ("${udelezenec.ime} ${udelezenec.priimek}" == polnoIme) {
            udelezenec.preteklaUdelezba = novaUdelezba
            return // Izhod iz zanke po najdenem udeležencu
        }
    }
}
