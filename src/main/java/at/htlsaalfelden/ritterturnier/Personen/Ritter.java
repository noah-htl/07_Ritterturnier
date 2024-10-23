package at.htlsaalfelden.ritterturnier.Personen;

import at.htlsaalfelden.ritterturnier.Personen.Waffen.Waffe;

import java.util.Objects;

public final class Ritter extends Person {
    private final String rufname;
    private Knappe knappe;
    private Waffe waffe;
    private final int id;

    private static int ID;

    public Ritter(String name, String telefonnummer, String rufname) {
        super(name, telefonnummer);
        this.rufname = rufname;
        this.id = ID++;
    }

    public String getRufname() {
        return rufname;
    }

    public int getId() {
        return id;
    }

    public Knappe getKnappe() {
        return knappe;
    }

    public void setKnappe(Knappe knappe) {
        this.knappe = knappe;
    }

    public Waffe getWaffe() {
        return waffe;
    }

    public void setWaffe(Waffe waffe) {
        this.waffe = waffe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ritter ritter)) return false;
        if (!super.equals(o)) return false;

        return getId() == ritter.getId() && getRufname().equals(ritter.getRufname()) && Objects.equals(knappe, ritter.knappe);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getRufname().hashCode();
        result = 31 * result + Objects.hashCode(knappe);
        result = 31 * result + getId();
        return result;
    }
}
