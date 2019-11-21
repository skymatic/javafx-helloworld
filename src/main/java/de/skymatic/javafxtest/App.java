package de.skymatic.javafxtest;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var button = new Button("Test Button");
        var vbox = new VBox(label, button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        var scene = new Scene(vbox, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}