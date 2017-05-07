package com.kivimango.jalculator;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main extends Application {

    JalculatorModel jalculator = new JalculatorModelImpl();

    @Override
    public void start(Stage primaryStage) throws Exception{
        /**
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
         */

        System.out.print("Input your math expression: ");
        String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int result = jalculator.calculate(line);
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
