package de.skymatic.javafxtest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
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
		var textInputFiled = new TextField();
		textInputFiled.setPromptText("Test text field: Enter anything you want.");
		var button = new Button("Test Button");
		button.setOnAction(actionEvent -> {
			var fileChooser = new FileChooser();
			var file = fileChooser.showOpenDialog(stage);
			if( file != null){
				System.out.println(file.getPath());
			}
		});
		var vbox = new VBox(label, textInputFiled, button);
		vbox.setPadding(new Insets(20));
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(10);

		var text = new Text("子貢問曰：有一言而可以終身行之者乎？子曰：其恕乎！己所不欲、勿施於人。"); //https://en.wikipedia.org/wiki/Confucius
		var quoteBox = new HBox(text);
		quoteBox.setAlignment(Pos.BOTTOM_RIGHT);
		HBox.setMargin(text, new Insets(20));

		var stackPane = new StackPane(quoteBox, vbox);
		var scene = new Scene(stackPane, 640, 480);
		stage.setScene(scene);
		stage.setTitle("JavaFX Test App");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}