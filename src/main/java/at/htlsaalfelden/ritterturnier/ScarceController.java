package at.htlsaalfelden.ritterturnier;

import at.htlsaalfelden.ritterturnier.Personen.Knappe;
import at.htlsaalfelden.ritterturnier.Personen.ValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

public class ScarceController implements Initializable {
    @FXML
    public TextField nummer;
    @FXML
    public TextField name;
    @FXML
    public Slider ausbildungsgrad;
    @FXML
    public BorderPane borderPane;

    private Knappe knappe;

    public Knappe getKnappe() {
        return knappe;
    }

    @FXML
    public void close(ActionEvent actionEvent) {
        clearError();
        try {
            knappe = new Knappe(name.getText(), nummer.getText(), (int) ausbildungsgrad.getValue());
        } catch (ValidationException e) {
            showError(e);
            return;
        }

        Stage stage = (Stage) nummer.getScene().getWindow();
        stage.close();
    }

    private Control lastError;

    private void showError(ValidationException e) {
        Field field = null;
        try {
            field = this.getClass().getDeclaredField(e.getObject());
        } catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex);
        }
        field.setAccessible(true);
        Object o = null;
        try {
            o = field.get(this);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        if(o instanceof Control control) {
            if(lastError != null) {
                lastError.setBorder(null);
            }
            control.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS)));
            borderPane.setCenter(new Label(e.getMessage()));
            lastError = control;
        } else {
            throw new RuntimeException("Not a Control field");
        }
    }

    private void clearError() {
        if(lastError != null) {
            lastError.setBorder(null);
        }
        lastError = null;
        borderPane.setCenter(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearError();
    }
}
