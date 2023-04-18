import java.util.Scanner;

public class Gibspiel {

    /*
     * Ein Spiel für 2 Spieler.
     * Jeder Spieler kann 1-10 Elemente auf einem Spielbrett plazieren,
     * selbst gewählt, mindestens eins, maximal 10 Elemente.
     * Welcher Spieler das 100. Element hinlegt, hat gewonnen.
     * Das Spiel beginnt mit einer zufälligen Anzahl von Elementen (< 30),
     * die bereits auf dem Spielbrett liegen.
     *
     * Benutzen Sie das Konzept der Vererbung, um wahlweise einen
     * menschlichen oder computergesteuerten Spieler teilnehmen zu lassen
     * (0, 1 oder 2 Computerspieler).
     *
     * Verwenden Sie am Anfang eine schwache KI für den computergesteuerten
     * Spieler.
     *
     * Notwendige Klassen:
     * - Spieler
     *   - MenschSpieler
     *   - ComputerSpieler
     * - Spielbrett
     */

    // geteilte Variablen (Attribute, statisch -> globale Variable)
    private static final Scanner eingabe = new Scanner(System.in);
    private static final Spieler[] spieler = new Spieler[2];

    private static void spielerAnzahlAuswahl(Spielbrett spielbrett) {
        int anzahlSpieler;
        do {
            System.out.print("Wieviele menschliche Spieler (0-2)? ");
            anzahlSpieler = eingabe.nextInt();
            eingabe.nextLine();
        } while (anzahlSpieler < 0 || anzahlSpieler > 2);
        for (int i=0; i<2; i++) {
            if (i >= anzahlSpieler) {
                if (i==0)
                    spieler[i] = new ComputerSpielerSchwer(spielbrett);
                else
                    spieler[i] = new ComputerSpieler_PD(spielbrett);
            }
            else {
                System.out.print("Name des Spieler " + (i+1) + ": ");
                String name = eingabe.nextLine();
                spieler[i] = new MenschSpieler(name);
            }
        }
    }

    public static void main(String[] args) {
        Spielbrett spielbrett = new Spielbrett();
        spielerAnzahlAuswahl(spielbrett);

        int aktuellerSpieler = 0;
        spielbrett.startSpiel();
        while (true) {
            System.out.print("Steine auf dem Brett: ");
            System.out.println(spielbrett.getAktuelleAnzahlSteine());

            boolean gültigerZug = false;
            int anzahlSteine;
            do {
                anzahlSteine = spieler[aktuellerSpieler].steineSetzen();
                gültigerZug = spielbrett.macheZug( anzahlSteine );
                if ( ! gültigerZug )
                    System.out.println("Ungültiger Zug, bitte nochmal versuchen!");
            } while ( ! gültigerZug );

            if (spielbrett.hatGewonnen()) {
                System.out.println(spieler[aktuellerSpieler].getName()
                        + " hat gewonnen");
                break;
            }

            // wechsel zwischen 0 und 1
            aktuellerSpieler = 1 - aktuellerSpieler;
            // das gleiche wie:
//            aktuellerSpieler++;
//            if (aktuellerSpieler >= 2) aktuellerSpieler = 0;
        }
    }
}
