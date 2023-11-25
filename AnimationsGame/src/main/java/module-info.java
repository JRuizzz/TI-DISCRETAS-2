module com.example.animationsgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animationsgame to javafx.fxml;
    exports com.example.animationsgame;
    exports com.example.animationsgame.control;
    opens com.example.animationsgame.control to javafx.fxml;
    exports com.example.animationsgame.model;
    opens com.example.animationsgame.model to javafx.fxml;
    opens com.example.animationsgame.screens to javafx.fxml;
    exports com.example.animationsgame.screens;
}