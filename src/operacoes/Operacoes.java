package operacoes;

import javax.swing.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        SecureRandom random = new SecureRandom();
        List<Character> senhaTemp = new ArrayList<>();
        int categoriasSelect = 0;

        if (tamanho <= 0) {
            JOptionPane.showMessageDialog(null, "Tamanho inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            return "";
        }

        if (maiusculas.isSelected()) categoriasSelect++;
        if (minusculas.isSelected()) categoriasSelect++;
        if (numeros.isSelected()) categoriasSelect++;
        if (simbolos.isSelected()) categoriasSelect++;

        if (categoriasSelect == 0) {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos uma opção", "Erro", JOptionPane.ERROR_MESSAGE);
            return "";
        }

        if (tamanho < categoriasSelect) {
            JOptionPane.showMessageDialog(null, "Tamanho mínimo: " + categoriasSelect, "Erro", JOptionPane.ERROR_MESSAGE);
            return "";
        }
        if (maiusculas.isSelected()) {
            String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            caracteres.append(letrasMaiusculas);
            senhaTemp.add(letrasMaiusculas.charAt(random.nextInt(letrasMaiusculas.length())));
        }
        if (minusculas.isSelected()) {
            String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
            caracteres.append(letrasMinusculas);
            senhaTemp.add(letrasMinusculas.charAt(random.nextInt(letrasMinusculas.length())));
        }
        if (numeros.isSelected()) {
            String numerinhos = "0123456789";
            caracteres.append(numerinhos);
            senhaTemp.add(numerinhos.charAt(random.nextInt(numerinhos.length())));
        }
        if (simbolos.isSelected()) {
            String simbolosEspeciais = "!@#$%&*";
            caracteres.append(simbolosEspeciais);
            senhaTemp.add(simbolosEspeciais.charAt(random.nextInt(simbolosEspeciais.length())));
        }
        while (senhaTemp.size() < tamanho) {
            int index = random.nextInt(caracteres.length());
            senhaTemp.add(caracteres.charAt(index));
        }

        Collections.shuffle(senhaTemp, random);
        StringBuilder senha = new StringBuilder();
        for (char c : senhaTemp) {
            senha.append(c);
        }

        return senha.toString();
    }
}

