package client.GUI;

import javax.swing.*;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Verifiers {

     protected static InputVerifier doubleVerifier = new InputVerifier() {
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;
            return Pattern.matches("[0-9.]+", textField.getText());
        }

        public boolean shouldYieldFocus(JComponent source, JComponent target) {
            return verify(source);
        }
    };
    protected static InputVerifier intVerifier = new InputVerifier() {
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;
            return Pattern.matches("[0-9]+", textField.getText());
        }

        public boolean shouldYieldFocus(JComponent source, JComponent target) {
            return verify(source);
        }
    };

    protected static InputVerifier nameVerifier = new InputVerifier() {
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;
            return Pattern.matches("[а-яА-Я]+", textField.getText());
        }

        public boolean shouldYieldFocus(JComponent source, JComponent target) {
            return verify(source);
        }
    };


    protected static InputVerifier dateVerifier = new InputVerifier() {
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;
            if(textField.getText().equals(""))return true;
            boolean flag =true;
            try{
                LocalDate.parse(textField.getText());
            }catch (Exception e){flag=false;}
            return flag;
        }

        public boolean shouldYieldFocus(JComponent source, JComponent target) {
            return verify(source);
        }
    };



}
