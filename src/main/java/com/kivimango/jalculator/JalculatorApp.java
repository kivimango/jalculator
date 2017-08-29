package com.kivimango.jalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * A simple calculator GUI app using the logic.
 *
 * @author kivimango
 * @version 1.0
 * @since 1.0
 */

public class JalculatorApp extends Application {

    private static final String APP_TITLE = "Jalculator";
    private static final String APP_VERSION = " v1.0";

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(APP_TITLE + APP_VERSION);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
        stage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view.fxml") );
        Parent root = loader.load();
        Scene scene = new Scene(root);

        loadFontAndStyle(scene);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Loading the custom Digital counter 7 font.
     * Note: if the path to the custom font file contains a space, it wont build
     * Use the programmatically way to load a font.
     * @param scene the scene
     */

    private void loadFontAndStyle(Scene scene) {
        Font.loadFont(getClass().getResourceAsStream("/digital_counter_7.ttf"), 14);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
