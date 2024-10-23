module at.htlsaalfelden.ritterturnier {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlsaalfelden.ritterturnier to javafx.fxml;
    exports at.htlsaalfelden.ritterturnier;
}