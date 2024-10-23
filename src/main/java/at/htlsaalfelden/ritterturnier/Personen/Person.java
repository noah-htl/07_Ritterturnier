package at.htlsaalfelden.ritterturnier.Personen;

public class Person {
    private final String name;
    private final String telefonnummer;

    public Person(String name, String telefonnummer) {
        this.name = name;
        this.telefonnummer = telefonnummer;
    }

    public String getName() {
        return name;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        return getName().equals(person.getName()) && getTelefonnummer().equals(person.getTelefonnummer());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getTelefonnummer().hashCode();
        return result;
    }
}
