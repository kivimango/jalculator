package com.kivimango.jalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jalculator {
    public static final String APP_TITLE = "Jalculator";

    static JalculatorModel jalculator = new JalculatorModelImpl();

    public static void main(String[] args) throws IOException {
        /**
        System.out.print("Input your math expression: ");
        String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int result = jalculator.calculate(line);
        System.out.println("Result: " + result);
         */
        JalculatorGui gui = new JalculatorGui();
    }
}
