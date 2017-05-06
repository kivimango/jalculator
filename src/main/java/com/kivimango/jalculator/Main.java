package com.kivimango.jalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main extends Application {

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

        String[] operations = line.split("[0-9]+");
        String[] numbers = line.split("[" + Pattern.quote("+-*/") + "]");

        System.out.print("Numbers: " + Arrays.toString(numbers));
        System.out.print("Operations: " + Arrays.toString(operations));

        int[] numbersConverted = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.valueOf(numbers[i]);
        }

        System.out.print(Arrays.toString(numbersConverted));

        int result = numbersConverted[0];

        // Use 1.7 compiler or Java 7 else it wont compile

        for(int i = 1; i < operations.length; i++) {
            switch(operations[i]) {
                case "+" :
                    result = result + numbersConverted[i];
                    break;
                case "-" :
                    result = result - numbersConverted[i];
                    break;
                case "*" :
                    result = result * numbersConverted[i];
                    break;
                case "/" :
                    result = result / numbersConverted[i];
                    break;
            }
        }

        System.out.print("The result : " + result);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
