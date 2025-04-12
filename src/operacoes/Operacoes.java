package operacoes;

import javax.swing.*;
import java.security.SecureRandom;

public class Operacoes {
    public static double Desconto (double a, double b) {
        return a  - (a * (b / 100));
    }
    public static double Acrescimo (double a, double b) {
        return a + (a * (b / 100));
    }
    public static double Amostragem1 (double a, double b) {
        return a * (b/100);
    }
    public static double Amostragem2 (double a, double b) {
        return (a / b) * 100;
    }
    public static double ValorA (double a, double b) {
        return ((a - b) / a) * 100;
    }
    public static double Delta (double a, double b) {
        return ((b - a) / a) * 100;
    }
    public static double ValorOriginal (double a, double b) {
        return (a * 100 / (100 - b));
    }
    public static double RegraTres(double a, double b, double c) {
        return (b * c) / a;
    }
    public static String GeradorSenha (int tamanho, JCheckBox maiusculas, JCheckBox minusculas, JCheckBox numeros, JCheckBox simbolos) {
        StringBuilder caracteres = new StringBuilder();

        if (maiusculas.isSelected()) caracteres.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (minusculas.isSelected()) caracteres.append("abcdefghijklmnopqrstuvwxyz");
        if (numeros.isSelected()) caracteres.append("0123456789");
        if (simbolos.isSelected()) caracteres.append("!@#$%&*");

        if (caracteres.length() == 0) return "Selecione ao menos uma opção";

        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }
}

