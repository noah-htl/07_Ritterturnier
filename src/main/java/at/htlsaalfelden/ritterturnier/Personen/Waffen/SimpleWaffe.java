package at.htlsaalfelden.ritterturnier.Personen.Waffen;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.lang.reflect.Field;

public abstract class SimpleWaffe extends Waffe{
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

    @Override
    public Image getImage() {
        return new Image(getImageStream());
    }

    protected InputStream getImageStream() {
        String name = getImageName();
        return SimpleWaffe.class.getResourceAsStream(name);
    }

    protected String getImageName() {
        return this.getClass().getSimpleName() + ".png"; // Bilder von Freepic.com
    }
}
