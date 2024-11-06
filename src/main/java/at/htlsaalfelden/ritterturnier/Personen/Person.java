package at.htlsaalfelden.ritterturnier.Personen;

public class Person {
    private final String name;
    private final String telefonnummer;

    public Person(String name, String nummer) throws ValidationException {
        if(name == null || name.isEmpty()) {
            throw new ValidationException("name", "Der Name muss existieren");
        }
        if(nummer == null || nummer.isEmpty()) {
            throw new ValidationException("nummer","Die Telefonnummer muss existieren");
        }
        this.name = name;
        this.telefonnummer = nummer;
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

    @Override
    public String toString() {
        return "Name: " + name + "\nTelefonnummer" + telefonnummer;
    }
}
