package at.htlsaalfelden.ritterturnier.Personen.Waffen;

import javafx.scene.image.Image;

public abstract class Waffe {
    private final String bezeichnung;
    private final String waffenArt;

    public Waffe(String bezeichnung) {
        this.bezeichnung = bezeichnung;
        this.waffenArt = bezeichnung.substring(0,1);
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public String getWaffenArt() {
        return waffenArt;
    }

    @Override
    public String toString() {
        return bezeichnung;
    }

    public abstract Image getImage();
}
