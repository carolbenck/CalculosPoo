package view;
import operacoes.Operacoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculosWindow extends JFrame {
    private JLabel titulo;
    private JButton desc, incrementar, amostragem1, amostragem2, valorA, delta, valorOriginal, regraTres, geradorSenha;

    public CalculosWindow() {
        setSize(800, 700);
        setTitle("Calculos");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        ComponentesCriar();
        setVisible(true);
    }
    private void ComponentesCriar() {
        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setBackground(new Color(6, 36, 35));
        pnlPrincipal.setBounds(0, 0, 800, 50);
        getContentPane().add(pnlPrincipal);
        pnlPrincipal.setLayout(null);
        titulo = new JLabel("Escolha o Tipo de Cálculo");
        titulo.setBounds(0,0,800,50);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.white);
        pnlPrincipal.add(titulo);
        desc = new JButton("Aplicar Desconto em um Valor");
        desc.setBounds(190, 80, 400, 50);
        desc.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(desc);
        desc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOperacoes("Desconto");
            }
        });
        incrementar = new JButton("Incrementar % a um Valor");
        incrementar.setBounds(190, 140, 400, 50);
        incrementar.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(incrementar);
        incrementar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOperacoes("Incremento");
            }
        });
        amostragem1 = new JButton("Amostragem - Quanto X% representa de Y");
        amostragem1.setBounds(190, 200, 400, 50);
        amostragem1.setBackground(Color.LIGHT_GRAY);
        amostragem1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOperacoes("Amostragem1");
            }
        });
        getContentPane().add(amostragem1);
        amostragem2 = new JButton("Amostragem 2 - Quanto X representa de Y");
        amostragem2.setBounds(190, 260, 400, 50);
        amostragem2.setBackground(Color.LIGHT_GRAY);
        amostragem2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOperacoes("Amostragem2");
            }
        });
        getContentPane().add(amostragem2);
        valorA = new JButton("Valor era A e paguei B, qual foi o desconto%?");
        valorA.setBounds(190, 320, 400, 50);
        valorA.setBackground(Color.LIGHT_GRAY);
        valorA.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOperacoes("ValorA");
            }
        });
        getContentPane().add(valorA);
        delta = new JButton("Variação Delta (%) - diferença % entre valores");
        delta.setBounds(190, 380, 400, 50);
        delta.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(delta);
        delta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOperacoes("Delta");
            }
        });
        valorOriginal = new JButton("Qual era o Valor Original?");
        valorOriginal.setBounds(190, 440, 400, 50);
        valorOriginal.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(valorOriginal);
        valorOriginal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOperacoes("ValorOriginal");
            }
        });
        regraTres = new JButton("Regra de Tres");
        regraTres.setBounds(190, 500, 400, 50);
        regraTres.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(regraTres);
        regraTres.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOperacoes("RegraTres");
            }
        });
        geradorSenha = new JButton("Gerador de Senha");
        geradorSenha.setBounds(190, 560, 400, 50);
        geradorSenha.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(geradorSenha);
        geradorSenha.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewOperacoes("Gerador");
            }
        });

  }}
