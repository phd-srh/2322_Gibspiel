public class ComputerSpieler_PD extends Spieler {
    private Spielbrett spielbrett;

    public ComputerSpieler_PD(Spielbrett spielbrett) {
        super("Computer PD");
        this.spielbrett = spielbrett;
    }

    @Override
    public int steineSetzen() {
        int aktuelleAnzahl = spielbrett.getAktuelleAnzahlSteine();

        int wasFehltNochZumGewinn = 100 - aktuelleAnzahl;
        // unfehlbare Gewinnstrategie
        while (wasFehltNochZumGewinn > 10) {
            wasFehltNochZumGewinn -= 11;
        }
        if (wasFehltNochZumGewinn > 0)
            return wasFehltNochZumGewinn;
        else
            return 1;
    }
}