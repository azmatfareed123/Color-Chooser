module com.mycompany.colorchooser {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.colorchooser to javafx.fxml;
    exports com.mycompany.colorchooser;
}
