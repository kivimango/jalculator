package com.kivimango.jalculator;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JalculatorGui {

    JalculatorModel jalculatorModel = new JalculatorModelImpl();
    JFrame frame = initFrame();
    JTextField textField = initTextField();

    public JalculatorGui() {
        frame.add(textField, BorderLayout.NORTH);
        frame.add(initButtonsPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JFrame initFrame() {
        JFrame frame = new JFrame(Jalculator.APP_TITLE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        int xCord = (screenSize.width - frameSize.width) / 2;
        int yCord = (screenSize.height - frameSize.height) / 2;
        frame.setLocation(xCord, yCord);
        frame.setMinimumSize(new Dimension(250,300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5,5));

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if(('0' <= key && key <= '9') || key == '+' || key == '-' || key == '*' || key == '/' ) {
                    addTextToField(String.valueOf(key));
                } else if(key == '\n') {
                    calculate();
                } else if(key == '\b') {
                    removeLastCharacterFromTextField();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        return frame;
    }

    private JTextField initTextField() {
        JTextField tf = new JTextField("0");
        tf.setFocusable(false);
        return tf;
    }

    private JPanel initButtonsPanel() {
        JPanel numbersPanel = new JPanel();
        numbersPanel.setLayout(new GridLayout(5,3, 3, 3));

        for(int i =1; i<10; i++) {
            numbersPanel.add(createSimpleButton((String.valueOf(i))));
        }

        numbersPanel.add(createSimpleButton("+"));
        numbersPanel.add(createSimpleButton("0"));
        numbersPanel.add(createSimpleButton("-"));
        numbersPanel.add(createSimpleButton("*"));
        numbersPanel.add(createSimpleButton("/"));
        numbersPanel.add(createCalculateButton());

        return numbersPanel;
    }

    private JButton createSimpleButton(final String text) {
        JButton button = new JButton(text);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextToField(text);
            }
        });
        return button;
    }

    private JButton createCalculateButton() {
        JButton calcButton = new JButton("=");
        calcButton.setFocusable(false);
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        return calcButton;
    }

    private void calculate() {
        try {
            String input = textField.getText();
            if(input.startsWith("-")) {
                input = "0" + input;
            }
            int result = jalculatorModel.calculate(input);
            textField.setText(String.valueOf(result));
        } catch(NumberFormatException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch(ArithmeticException e) {
            JOptionPane.showMessageDialog(frame, "Division by zero!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeLastCharacterFromTextField() {
        if(!textField.getText().isEmpty()) {
            String value = textField.getText();
            value = value.substring(0, value.length()-1);
            textField.setText(value);
        }
    }

    private void addTextToField(String t) {
        textField.setText(textField.getText() + t);
    }
}