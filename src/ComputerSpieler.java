public class ComputerSpieler extends Spieler {
    private Spielbrett spielbrett;

    public ComputerSpieler(Spielbrett spielbrett) {
        super("Computer");
        this.spielbrett = spielbrett;
    }

    @Override
    public int steineSetzen() {
        int restlicheSteine = 100 - spielbrett.getAktuelleAnzahlSteine();
        if (restlicheSteine > 10)
            restlicheSteine = (int)(Math.random() * 10) + 1;

        System.out.println("Computer spielt " + restlicheSteine + " Steine.");
        return restlicheSteine;
    }
}
