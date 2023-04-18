public class ComputerSpieler extends Spieler {
    private Spielbrett spielbrett;

    public ComputerSpieler(Spielbrett spielbrett) {
        super("Computer " + (int)(Math.random() * 100));
        this.spielbrett = spielbrett;
    }

    @Override
    public int steineSetzen() {
        int restlicheSteine = 100 - spielbrett.getAktuelleAnzahlSteine();
        if (restlicheSteine > 10)
            restlicheSteine = (int)(Math.random() * 10) + 1;

        System.out.println(getName() +  " spielt " + restlicheSteine + " Steine.");
        return restlicheSteine;
    }
}
