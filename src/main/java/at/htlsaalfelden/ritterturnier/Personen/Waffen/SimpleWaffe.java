package at.htlsaalfelden.ritterturnier.Personen.Waffen;

import java.lang.reflect.Field;

public class SimpleWaffe extends Waffe{
    public SimpleWaffe() {
        super("Platzhalter");
        try {
            Field field = Waffe.class.getDeclaredField("bezeichnung");
            field.setAccessible(true);
            field.set(this, this.getClass().getSimpleName());
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
