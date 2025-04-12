package main;
import view.CalculosWindow;

import javax.swing.*;
import java.awt.*;

import static javax.swing.UIManager.getSystemLookAndFeelClassName;

public class CalculosMain {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Label.font", new Font("Segoe UI", Font.CENTER_BASELINE, 10));
            UIManager.put("Button.font", new Font("Segoe UI", Font.CENTER_BASELINE, 12));
            UIManager.put("TextField.font", new Font("Segoe UI", Font.CENTER_BASELINE, 12));
            UIManager.put("CheckBox.font", new Font("Segoe UI", Font.CENTER_BASELINE, 12));

            new CalculosWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
