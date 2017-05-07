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

        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println("Operations: " + Arrays.toString(operations));

        int[] numbersConverted = convert(numbers);

        System.out.println("Result: " + calculate(operations, numbersConverted));
    }

    private static int[] convert(String[] numbers) {
        int[] numbersConverted = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.valueOf(numbers[i]);
        }
        System.out.print(Arrays.toString(numbersConverted));
        return numbersConverted;
    }

    private static int calculate(String[] operations, int[] numbers) {
        int length = operations.length;
        int index = 1;
        while (index < length) {
            if ("*".equals(operations[index])) {
                numbers[index - 1] = numbers[index - 1] * numbers[index];
                for (int j = 1; j < length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j] = operations[j + 1];
                }
                for (int j = 1; j < length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j] = operations[j + 1];
                }
                length--;
            } else if ("/".equals(operations[index])) {
                numbers[index - 1] = numbers[index - 1] / numbers[index];
                for (int j = 1; j < length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j] = operations[j + 1];
                }
                length--;
            } else {
                index++;
            }
        }

        index = 1;
        while (index < length) {
            if ("+".equals(operations[index])) {
                numbers[index - 1] = numbers[index - 1] + numbers[index];
                for (int j = 1; j < length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j] = operations[j + 1];
                }
                length--;
            } else if ("-".equals(operations[index])) {
                numbers[index - 1] = numbers[index - 1] - numbers[index];
                for (int j = 1; j < length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                    operations[j] = operations[j + 1];
                }
                length--;
            } else {
                index++;
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        launch(args);
    }
}
