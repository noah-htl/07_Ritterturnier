package at.htlsaalfelden.ritterturnier.Personen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Teilnehmerliste {
    private final List<Person> teilnehmer = new ArrayList<>();

    public void addTeilnehmer(Person person) throws NameSchonVorhanden{
        if(teilnehmer.stream().anyMatch(p -> p.getName().equals(person.getName()))) {
            throw new NameSchonVorhanden("Name schon vorhanden");
        }
        teilnehmer.add(person);
    }

    public String listeAlleTeilnehmer() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Person p : teilnehmer) {
            stringBuilder.append(p).append("\n");
        }

        return stringBuilder.toString();
    }

    public List<Person> alleMitWaffenart(String waffenart) {
        return teilnehmer.stream().filter(person -> {
            if(person instanceof Ritter ritter) {
                return ritter.getWaffe() != null && ritter.getWaffe().getWaffenArt().equals(waffenart);
            }
            return false;
        }).toList();
    }
}
