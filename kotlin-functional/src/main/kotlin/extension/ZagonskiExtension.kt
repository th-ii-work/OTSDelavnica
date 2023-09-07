fun main() {
    val udelezenciKonference = listOf(
        UdelezenecKonference("Janez", "Novak", 3),
        UdelezenecKonference("Maja", "Kovač", 6),
        UdelezenecKonference("Luka", "Horvat", 3),
        UdelezenecKonference("Ana", "Krajnc", 1)
    )

    // Izračun povprečnega števila sodelovanj z uporabo extension funkcije
    val povprecnaSodelovanja = udelezenciKonference.izracunajPovprecnoSodelovanjeExtension()
    println("Povprečno število sodelovanj: $povprecnaSodelovanja")

    // TODO Filtriranje visoko sodelujočih udeležencev z uporabo extension funkcije

    // Preslikava seznama udeležencev v seznam imen z uporabo extension funkcije
    val imenaUdelezencev = udelezenciKonference.preslikajExtension { "${it.ime} ${it.priimek}" }
    println("Seznam imen udeležencev: $imenaUdelezencev")

    // Sprememba števila sodelovanj udeleženca z uporabo extension funkcije
    val noviUdelezenciKonference = udelezenciKonference.spremeniSteviloSodelovanjExtension("Janez Novak", 6)
    println("Seznam udeležencev po spremembi števila sodelovanj: $noviUdelezenciKonference")
}

// Extension funkcija za izračun povprečnega števila sodelovanj
fun List<UdelezenecKonference>.izracunajPovprecnoSodelovanjeExtension(): Double {
    return this.sumOf { it.steviloSodelovanj }.toDouble() / this.size
}

// TODO Extension funkcija za filtriranje seznama udeležencev

// Extension funkcija za preslikavo seznama udeležencev v seznam imen
fun List<UdelezenecKonference>.preslikajExtension(preslikava: (UdelezenecKonference) -> String): List<String> {
    return this.map(preslikava)
}

// Extension funkcija za spreminjanje števila sodelovanj udeleženca
fun List<UdelezenecKonference>.spremeniSteviloSodelovanjExtension(
    imePriimek: String,
    novoStevilo: Int
): List<UdelezenecKonference> {
    return this.map { udelezenec ->
        if ("${udelezenec.ime} ${udelezenec.priimek}" == imePriimek) {
            udelezenec.copy(steviloSodelovanj = novoStevilo)
        } else {
            udelezenec
        }
    }
}