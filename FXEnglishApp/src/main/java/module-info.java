module com.nda.fxenglishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.nda.fxenglishapp to javafx.fxml;
    exports com.nda.fxenglishapp;
}
