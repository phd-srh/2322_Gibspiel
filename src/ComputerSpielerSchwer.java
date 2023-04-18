public class ComputerSpielerSchwer extends Spieler{
    private Spielbrett spielbrett;

    public ComputerSpielerSchwer(Spielbrett spielbrett) {
        super("Computer ars1992");
        this.spielbrett = spielbrett;
    }

    @Override
    public int steineSetzen() {
        System.out.println("Am Zug: KI Schwer " + getName());

        int[] j = new int[]{100, 89, 78, 67, 56, 45, 34, 23, 12, 1};
        for (int wert: j){
            for (int i = 1; i <= 10 ; i++) {
                if (spielbrett.getAktuelleAnzahlSteine() + i == wert)
                    return i;
            }
        }
        return 1;
    }
}