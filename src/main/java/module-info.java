module java {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;
    requires java.desktop;

    opens Controller to javafx.fxml;
    opens View to javafx.fxml;

    exports Controller;
    exports View;
}