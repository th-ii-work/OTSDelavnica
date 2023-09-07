fun main() {
    val udelezenciKonference = mutableListOf(
        UdelezenecKonferenceNon("Janez", "Novak", 3),
        UdelezenecKonferenceNon("Maja", "Kovač", 2),
        UdelezenecKonferenceNon("Luka", "Horvat", 1),
        UdelezenecKonferenceNon("Ana", "Krajnc", 4)
    )

    // Filtriranje udeležencev z visokim številom preteklih udeležb z zanko
    val visokoUdelezeni = mutableListOf<UdelezenecKonferenceNon>()
    for (udelezenec in udelezenciKonference) {
        if (udelezenec.preteklaUdelezba >= 3) {
            visokoUdelezeni.add(udelezenec)
        }
    }
    println("Udeleženci z visokim številom preteklih udeležb: $visokoUdelezeni")

}


