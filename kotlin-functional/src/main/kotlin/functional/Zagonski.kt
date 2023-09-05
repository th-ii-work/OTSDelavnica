fun main() {
    val udelezenciKonference = listOf(
        UdelezenecKonference("Janez", "Novak", 3),
        UdelezenecKonference("Maja", "Kovač", 6),
        UdelezenecKonference("Luka", "Horvat", 3),
        UdelezenecKonference("Ana", "Krajnc", 1)
    )

    // Čista funkcija za izračun povprečnega števila sodelovanj
    val povprecnaSodelovanja = izracunajPovprecnoSodelovanje(udelezenciKonference)
    println("Povprečno število sodelovanj: $povprecnaSodelovanja")

    // TODO Uporaba funkcije prvega reda za filtriranje udeležencev z visokim številom sodelovanj

    // Uporaba funkcije prvega reda za preslikavo seznama udeležencev v seznam imen
    val imenaUdelezencev = preslikajSeznam(udelezenciKonference) { udelezenec -> "${udelezenec.ime} ${udelezenec.priimek}" }
    println("Seznam imen udeležencev: $imenaUdelezencev")

}

// Čista funkcija za izračun povprečnega števila sodelovanj
fun izracunajPovprecnoSodelovanje(seznam: List<UdelezenecKonference>): Double {
    val skupnoSodelovanj = seznam.sumOf { it.steviloSodelovanj }
    return skupnoSodelovanj.toDouble() / seznam.size
}

// TODO Implementacija funkcije prvega reda za filtriranje seznama udeležencev

// Uporaba funkcije prvega reda za preslikavo seznama udeležencev
fun preslikajSeznam(seznam: List<UdelezenecKonference>, preslikava: (UdelezenecKonference) -> String): List<String> {
    return seznam.map(preslikava)
}


