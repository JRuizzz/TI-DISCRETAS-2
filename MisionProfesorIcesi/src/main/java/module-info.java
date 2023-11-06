module com.example.misionprofesoricesi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.misionprofesoricesi to javafx.fxml;
    exports com.example.misionprofesoricesi.ui;
    opens com.example.misionprofesoricesi.ui to javafx.fxml;
    exports com.example.misionprofesoricesi.control;
    opens com.example.misionprofesoricesi.control to javafx.fxml;
    exports com.example.misionprofesoricesi.util;
    opens com.example.misionprofesoricesi.util to javafx.fxml;
}