package at.htlsaalfelden.ritterturnier.Personen;

public class Knappe extends Person{
    private final int ausbildungsgrad;

    public Knappe(String name, String telefonnummer, int ausbildungsgrad) {
        super(name, telefonnummer);

        this.ausbildungsgrad = ausbildungsgrad;
    }

    public int getAusbildungsgrad() {
        return ausbildungsgrad;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Knappe knappe)) return false;
        if (!super.equals(o)) return false;

        return getAusbildungsgrad() == knappe.getAusbildungsgrad();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getAusbildungsgrad();
        return result;
    }
}
