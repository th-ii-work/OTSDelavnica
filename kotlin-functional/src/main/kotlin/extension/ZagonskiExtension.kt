fun main() {
    val udelezenciKonference = listOf(
        UdelezenecKonference("Janez", "Novak", 3),
        UdelezenecKonference("Maja", "Kovač", 6),
        UdelezenecKonference("Luka", "Horvat", 3),
        UdelezenecKonference("Ana", "Krajnc", 1)
    )

    // Filtriranje visoko sodelujočih udeležencev z uporabo extension funkcije
    //val visokoSodelujoci = udelezenciKonference.filtrirajExtension { it.steviloSodelovanj >= 3 }
    //println("Visoko sodelujoči udeleženci: $visokoSodelujoci")

}

// TODO Extension funkcija za filtriranje seznama udeležencev

