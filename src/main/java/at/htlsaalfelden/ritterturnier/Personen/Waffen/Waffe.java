package at.htlsaalfelden.ritterturnier.Personen.Waffen;

public abstract class Waffe {
    private final String bezeichnung;

    public Waffe(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }
}
