package de.skymatic.javafxtest;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

/**
 * Test App for JavaFX Bug
 */
public class App extends Application {

	private static final String PROBLEMATIC_CHAR = "\uD83C\uDF40"; //pile of poo emoji
	private static final String tmpDir = System.getProperty("java.io.tmpdir");

	private static Path workingDir;
	private static Path expectedFile;

	@Override
	public void start(Stage stage) {
		var fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(workingDir.toFile());
		var chosenFile = fileChooser.showOpenDialog(stage);
		if (chosenFile != null) {
			if (!chosenFile.toPath().equals(expectedFile)) {
				throw new IllegalStateException("Chosen path is not correct: " + chosenFile.getPath());
			}
		}
		stage.close();
		System.exit(0);
	}

	private static void prepare() throws IOException {
		var dir = Files.createDirectories(Path.of(tmpDir).resolve(UUID.randomUUID()+"/" + PROBLEMATIC_CHAR));
		workingDir = dir.getParent();
		expectedFile = Files.createFile(dir.resolve("foo"));
	}

	public static void main(String[] args) throws IOException {
		assert tmpDir != null;
		prepare();
		assert workingDir != null;
		launch();
	}


}