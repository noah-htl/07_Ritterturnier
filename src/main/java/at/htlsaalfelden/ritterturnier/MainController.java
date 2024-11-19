package at.htlsaalfelden.ritterturnier;

import at.htlsaalfelden.ritterturnier.Personen.*;
import at.htlsaalfelden.ritterturnier.Personen.Waffen.Lanze;
import at.htlsaalfelden.ritterturnier.Personen.Waffen.Schwert;
import at.htlsaalfelden.ritterturnier.Personen.Waffen.Waffe;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Teilnehmerliste teilnehmerliste;
    private Control lastError;


    @FXML
    public ListView<Person> listView;
    @FXML
    private BorderPane borderPane;
    @FXML
    private TextField name;
    @FXML
    private TextField rufname;
    @FXML
    private TextField nummer;
    @FXML
    private TextField id;
    @FXML
    private ComboBox<Waffe> comboBox;

    private void startCreating() {
        id.setText(String.valueOf(Ritter.getNextId()));
        clearError();

        listView.getItems().clear();
        teilnehmerliste.forEach(listView.getItems()::add);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        teilnehmerliste = new Teilnehmerliste();

        ObservableList<Waffe> list = comboBox.getItems();
        list.add(new Lanze());
        list.add(new Schwert());

        startCreating();
    }

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

    @FXML
    public void add(ActionEvent actionEvent) {
        Ritter ritter = null;
        try {
            ritter = new Ritter(name.getText(), nummer.getText(), rufname.getText(), comboBox.getValue());
        } catch (ValidationException e) {
            showError(e);
            return;
        }

        try {
            teilnehmerliste.addTeilnehmer(ritter);
        } catch (NameSchonVorhanden e) {
            showError(new ValidationException("name", "Name bereits verwendet"));
            return;
        }


        startCreating();
    }
}