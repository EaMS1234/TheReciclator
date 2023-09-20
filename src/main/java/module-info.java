module thereciclator {
    requires javafx.controls;
    requires javafx.fxml;

    opens thereciclator to javafx.fxml;
    exports thereciclator;
}
