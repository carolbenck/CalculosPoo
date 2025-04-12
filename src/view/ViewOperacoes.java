package view;

import operacoes.Operacoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewOperacoes extends JFrame {

    public ViewOperacoes(String tipoOperacao) {
        setSize(290, 210);
        setTitle("Calculo de " + tipoOperacao);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        switch (tipoOperacao) {
            case "Desconto":
                telaDesconto();
                break;
            case "Incremento":
                telaIncremento();
                break;
            case "Amostragem1":
                telaAmostragem1();
                break;
            case "Amostragem2":
                telaAmostragem2();
                break;
            case "ValorA":
                telaValorA();
                break;
            case "Delta":
                telaDelta();
                break;
            case "ValorOriginal":
                telaValorOriginal();
                break;
            case "RegraTres":
                telaRegraTres();
                break;
            case "Gerador":
                telaGerador();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Operação não reconhecida.");
        }
        setVisible(true);
    }
    private void telaDesconto() {
        JLabel lblTxt, lblValor, lblDesconto, lblResult, lblPercent;
        JTextField valorTxf, descTxf, resultTxf;
        JButton calc;
        lblTxt = new JLabel("Aplicar Desconto % num Valor");
        lblTxt.setBounds(20, 10, 300, 20);
        add(lblTxt);
        lblValor = new JLabel("Valor inicial R$ (a)");
        lblValor.setBounds(20, 40, 120, 20);
        lblValor.setForeground(Color.RED);
        lblValor.setHorizontalAlignment(JLabel.RIGHT);
        add(lblValor);

        valorTxf = new JTextField();
        valorTxf.setBounds(150, 40, 100, 20);
        valorTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        valorTxf.setBackground(new Color(255, 240, 240));
        valorTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(valorTxf);

        lblDesconto = new JLabel("% desconto (b) ");
        lblDesconto.setBounds(20, 70, 120, 20);
        lblDesconto.setForeground(Color.BLUE);
        lblDesconto.setHorizontalAlignment(JLabel.RIGHT);
        add(lblDesconto);

        descTxf = new JTextField();
        descTxf.setBounds(150, 70, 100, 20);
        descTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        descTxf.setHorizontalAlignment(JTextField.RIGHT);
        descTxf.setBackground(new Color(230, 250, 255));
        add(descTxf);

        lblPercent = new JLabel("%");
        lblPercent.setBounds(255, 70, 20, 20);
        lblPercent.setForeground(Color.BLUE);
        add(lblPercent);

        lblResult = new JLabel("Resultado ");
        lblResult.setBounds(40, 100, 100, 20);
        lblResult.setHorizontalAlignment(JLabel.RIGHT);
        add(lblResult);

        resultTxf = new JTextField();
        resultTxf.setBounds(150, 100, 100, 20);
        resultTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        resultTxf.setEditable(false);
        resultTxf.setFocusable(false);
        resultTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(resultTxf);

        calc = new JButton("Calcular");
        calc.setBounds(35, 130, 210, 25);
        calc.setBackground(Color.LIGHT_GRAY);
        calc.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        add(calc);
        calc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(valorTxf.getText());
                double desconto = Double.parseDouble(descTxf.getText());
                double valorDesconto = Operacoes.Desconto(valor, desconto);
                resultTxf.setText(" "+valorDesconto);
            }
        });
    }

    private void telaIncremento() {
        JLabel lblTxt, lblValor, lblAcrescimo, lblResult, lblPercent;
        JTextField valorTxf, acrescimoTxf, resultTxf;
        JButton calc;
        lblTxt = new JLabel("Incrementar % a um Valor");
        lblTxt.setBounds(20, 10, 300, 20);
        add(lblTxt);
        lblValor = new JLabel("Valor inicial R$ (a)");
        lblValor.setBounds(20, 40, 120, 20);
        lblValor.setForeground(Color.RED);
        lblValor.setHorizontalAlignment(JLabel.RIGHT);
        add(lblValor);

        valorTxf = new JTextField();
        valorTxf.setBounds(150, 40, 100, 20);
        valorTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        valorTxf.setBackground(new Color(255, 240, 240));
        valorTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(valorTxf);

        lblAcrescimo = new JLabel("% acréscimo (b)");
        lblAcrescimo.setBounds(20, 70, 120, 20);
        lblAcrescimo.setForeground(Color.BLUE);
        lblAcrescimo.setHorizontalAlignment(JLabel.RIGHT);
        add(lblAcrescimo);

        acrescimoTxf = new JTextField();
        acrescimoTxf.setBounds(150, 70, 100, 20);
        acrescimoTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        acrescimoTxf.setHorizontalAlignment(JTextField.RIGHT);
        acrescimoTxf.setBackground(new Color(230, 250, 255));
        add(acrescimoTxf);

        lblPercent = new JLabel("%");
        lblPercent.setBounds(255, 70, 20, 20);
        lblPercent.setForeground(Color.BLUE);
        add(lblPercent);

        lblResult = new JLabel("Resultado");
        lblResult.setBounds(40, 100, 100, 20);
        lblResult.setHorizontalAlignment(JLabel.RIGHT);
        add(lblResult);

        resultTxf = new JTextField();
        resultTxf.setBounds(150, 100, 100, 20);
        resultTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        resultTxf.setEditable(false);
        resultTxf.setFocusable(false);
        resultTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(resultTxf);
        calc = new JButton("Calcular");
        calc.setBounds(35, 130, 210, 25);
        calc.setBackground(Color.LIGHT_GRAY);
        calc.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        add(calc);
        calc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(valorTxf.getText());
                double acrescimo = Double.parseDouble(acrescimoTxf.getText());
                double valorAcrescimo = Operacoes.Acrescimo(valor, acrescimo);
                resultTxf.setText(" "+valorAcrescimo);
            }
        });
    }

    private void telaAmostragem1() {
        JLabel lblTxt, lblTotal, lblPorcentagem, lblResult, lblPercent;
        JTextField totalTxf, porcentagemTxf, resultTxf;
        JButton calc;
        lblTxt = new JLabel("Amostragem - Quanto X% representa de Y");
        lblTxt.setBounds(20, 10, 300, 20);
        add(lblTxt);
        lblTotal = new JLabel("Total (a)");
        lblTotal.setBounds(20, 40, 120, 20);
        lblTotal.setForeground(Color.RED);
        lblTotal.setHorizontalAlignment(JLabel.RIGHT);
        add(lblTotal);

        totalTxf = new JTextField();
        totalTxf.setBounds(150, 40, 100, 20);
        totalTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        totalTxf.setBackground(new Color(255, 240, 240));
        totalTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(totalTxf);

        lblPorcentagem = new JLabel("Porcentagem (b)");
        lblPorcentagem.setBounds(20, 70, 120, 20);
        lblPorcentagem.setForeground(Color.BLUE);
        lblPorcentagem.setHorizontalAlignment(JLabel.RIGHT);
        add(lblPorcentagem);

        porcentagemTxf = new JTextField();
        porcentagemTxf.setBounds(150, 70, 100, 20);
        porcentagemTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        porcentagemTxf.setHorizontalAlignment(JTextField.RIGHT);
        porcentagemTxf.setBackground(new Color(230, 250, 255));
        add(porcentagemTxf);

        lblPercent = new JLabel("%");
        lblPercent.setBounds(255, 70, 20, 20);
        lblPercent.setForeground(Color.BLUE);
        add(lblPercent);

        lblResult = new JLabel("Corresponde a");
        lblResult.setBounds(40, 100, 100, 20);
        lblResult.setHorizontalAlignment(JLabel.RIGHT);
        add(lblResult);

        resultTxf = new JTextField();
        resultTxf.setBounds(150, 100, 100, 20);
        resultTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        resultTxf.setEditable(false);
        resultTxf.setFocusable(false);
        resultTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(resultTxf);

        calc = new JButton("Calcular");
        calc.setBounds(35, 130, 210, 25);
        calc.setBackground(Color.LIGHT_GRAY);
        calc.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        add(calc);
        calc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(totalTxf.getText());
                double porcentagem = Double.parseDouble(porcentagemTxf.getText());
                double valorCorrespondente = Operacoes.Amostragem1(valor, porcentagem);
                resultTxf.setText(" "+valorCorrespondente);
            }
        });
    }
    private void telaAmostragem2() {
        JLabel lblTxt, lblTotal, lblParte, lblResult, lblPercent;
        JTextField totalTxf, parteTxf, resultTxf;
        JButton calc;
        lblTxt = new JLabel("Amostragem - Quanto X representa de Y");
        lblTxt.setBounds(20, 10, 300, 20);
        add(lblTxt);
        lblTotal = new JLabel("Total (a)");
        lblTotal.setBounds(20, 40, 120, 20);
        lblTotal.setForeground(Color.RED);
        lblTotal.setHorizontalAlignment(JLabel.RIGHT);
        add(lblTotal);

        totalTxf = new JTextField();
        totalTxf.setBounds(150, 40, 100, 20);
        totalTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        totalTxf.setBackground(new Color(255, 240, 240));
        totalTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(totalTxf);

        lblParte = new JLabel("Parte (b) ");
        lblParte.setBounds(20, 70, 120, 20);
        lblParte.setForeground(Color.BLUE);
        lblParte.setHorizontalAlignment(JLabel.RIGHT);
        add(lblParte);

        parteTxf = new JTextField();
        parteTxf.setBounds(150, 70, 100, 20);
        parteTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        parteTxf.setHorizontalAlignment(JTextField.RIGHT);
        parteTxf.setBackground(new Color(230, 250, 255));
        add(parteTxf);

        lblPercent = new JLabel("%");
        lblPercent.setBounds(255, 100, 20, 20);
        add(lblPercent);

        lblResult = new JLabel("Corresponde a %");
        lblResult.setBounds(20, 100, 120, 20);
        lblResult.setHorizontalAlignment(JLabel.RIGHT);
        add(lblResult);

        resultTxf = new JTextField();
        resultTxf.setBounds(150, 100, 100, 20);
        resultTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        resultTxf.setEditable(false);
        resultTxf.setFocusable(false);
        resultTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(resultTxf);

        calc = new JButton("Calcular");
        calc.setBounds(35, 130, 210, 25);
        calc.setBackground(Color.LIGHT_GRAY);
        calc.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        add(calc);
        calc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double total = Double.parseDouble(totalTxf.getText());
                double parte = Double.parseDouble(parteTxf.getText());
                double valorCorrespondente = Operacoes.Amostragem2(total, parte);
                resultTxf.setText(String.format("%.2f", valorCorrespondente));
            }
        });
    }
    private void telaValorA(){
        JLabel lblTxt, lblValorA, lblPagueiB, lblResult, lblPercent;
        JTextField valorATxf, pagueiBTxf, resultTxf;
        JButton calc;
        lblTxt = new JLabel("Valor era A e eu paguei B, qual foi o desconto%?");
        lblTxt.setBounds(20, 10, 250, 20);
        add(lblTxt);
        lblValorA = new JLabel("Valor original (a)");
        lblValorA.setBounds(20, 40, 120, 20);
        lblValorA.setForeground(Color.RED);
        lblValorA.setHorizontalAlignment(JLabel.RIGHT);
        add(lblValorA);

        valorATxf = new JTextField();
        valorATxf.setBounds(150, 40, 100, 20);
        valorATxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        valorATxf.setBackground(new Color(255, 240, 240));
        valorATxf.setHorizontalAlignment(JTextField.RIGHT);
        add(valorATxf);

        lblPagueiB = new JLabel("Valor c/ desconto (b)");
        lblPagueiB.setBounds(20, 70, 120, 20);
        lblPagueiB.setForeground(Color.BLUE);
        lblPagueiB.setHorizontalAlignment(JLabel.RIGHT);
        add(lblPagueiB);

        pagueiBTxf = new JTextField();
        pagueiBTxf.setBounds(150, 70, 100, 20);
        pagueiBTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        pagueiBTxf.setHorizontalAlignment(JTextField.RIGHT);
        pagueiBTxf.setBackground(new Color(230, 250, 255));
        add(pagueiBTxf);

        lblPercent = new JLabel("%");
        lblPercent.setBounds(255, 100, 20, 20);
        add(lblPercent);

        lblResult = new JLabel("% desconto ");
        lblResult.setBounds(20, 100, 120, 20);
        lblResult.setHorizontalAlignment(JLabel.RIGHT);
        add(lblResult);

        resultTxf = new JTextField();
        resultTxf.setBounds(150, 100, 100, 20);
        resultTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        resultTxf.setEditable(false);
        resultTxf.setFocusable(false);
        resultTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(resultTxf);

        calc = new JButton("Calcular");
        calc.setBounds(35, 130, 210, 25);
        calc.setBackground(Color.LIGHT_GRAY);
        calc.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        add(calc);
        calc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double total = Double.parseDouble(valorATxf.getText());
                double parte = Double.parseDouble(pagueiBTxf.getText());
                double valorDesconto = Operacoes.ValorA(total, parte);
                resultTxf.setText(String.format("%.2f", valorDesconto));
            }
        });
    }
    private void telaDelta(){
        JLabel lblTxt, lblValorInicial, lblValorFinal, lblResult, lblPercent;
        JTextField valorInicialTxf, valorFinalTxf, resultTxf;
        JButton calc;
        lblTxt = new JLabel("Variação Delta (%) - diferença % entre valores");
        lblTxt.setBounds(20, 10, 300, 20);
        add(lblTxt);
        lblValorInicial = new JLabel("Valor inicial (a)");
        lblValorInicial.setBounds(20, 40, 120, 20);
        lblValorInicial.setForeground(Color.RED);
        lblValorInicial.setHorizontalAlignment(JLabel.RIGHT);
        add(lblValorInicial);

        valorInicialTxf = new JTextField();
        valorInicialTxf.setBounds(150, 40, 100, 20);
        valorInicialTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        valorInicialTxf.setBackground(new Color(255, 240, 240));
        valorInicialTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(valorInicialTxf);

        lblValorFinal = new JLabel("Valor final (b)");
        lblValorFinal.setBounds(20, 70, 120, 20);
        lblValorFinal.setHorizontalAlignment(JLabel.RIGHT);
        lblValorFinal.setForeground(Color.BLUE);
        add(lblValorFinal);

        valorFinalTxf = new JTextField();
        valorFinalTxf.setBounds(150, 70, 100, 20);
        valorFinalTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        valorFinalTxf.setHorizontalAlignment(JTextField.RIGHT);
        valorFinalTxf.setBackground(new Color(230, 250, 255));
        add(valorFinalTxf);

        lblPercent = new JLabel("%");
        lblPercent.setBounds(255, 100, 20, 20);
        add(lblPercent);

        lblResult = new JLabel("Diferença %");
        lblResult.setBounds(20, 100, 120, 20);
        lblResult.setHorizontalAlignment(JLabel.RIGHT);
        add(lblResult);

        resultTxf = new JTextField();
        resultTxf.setBounds(150, 100, 100, 20);
        resultTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        resultTxf.setEditable(false);
        resultTxf.setFocusable(false);
        resultTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(resultTxf);

        calc = new JButton("Calcular");
        calc.setBounds(35, 130, 210, 25);
        calc.setBackground(Color.LIGHT_GRAY);
        calc.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        add(calc);
        calc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double valorInicial = Double.parseDouble(valorInicialTxf.getText());
                double valorFinal = Double.parseDouble(valorFinalTxf.getText());
                double valorDiferenca = Operacoes.Delta(valorInicial, valorFinal);
                resultTxf.setText(String.format("%.2f", valorDiferenca));
            }
        });
    }
    private void telaValorOriginal(){
        JLabel lblTxt, lblValorFinal, lblDesconto, lblResult, lblPercent;
        JTextField valorFinalTxf, valorDescontoTxf, resultTxf;
        JButton calc;
        lblTxt = new JLabel("Qual era o valor original?");
        lblTxt.setBounds(20, 10, 300, 20);
        add(lblTxt);
        lblValorFinal = new JLabel("Valor final R$ (a)");
        lblValorFinal.setBounds(20, 40, 120, 20);
        lblValorFinal.setForeground(Color.RED);
        lblValorFinal.setHorizontalAlignment(JLabel.RIGHT);
        add(lblValorFinal);

        valorFinalTxf = new JTextField();
        valorFinalTxf.setBounds(150, 40, 100, 20);
        valorFinalTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        valorFinalTxf.setBackground(new Color(255, 240, 240));
        valorFinalTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(valorFinalTxf);

        lblDesconto = new JLabel("% desconto (b)");
        lblDesconto.setBounds(20, 70, 120, 20);
        lblDesconto.setForeground(Color.BLUE);
        lblDesconto.setHorizontalAlignment(JLabel.RIGHT);
        add(lblDesconto);

        valorDescontoTxf = new JTextField();
        valorDescontoTxf.setBounds(150, 70, 100, 20);
        valorDescontoTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        valorDescontoTxf.setHorizontalAlignment(JTextField.RIGHT);
        valorDescontoTxf.setBackground(new Color(230, 250, 255));
        add(valorDescontoTxf);

        lblPercent = new JLabel("%");
        lblPercent.setBounds(255, 70, 20, 20);
        lblPercent.setForeground(Color.BLUE);
        add(lblPercent);

        lblResult = new JLabel("Valor inicial");
        lblResult.setBounds(20, 100, 120, 20);
        lblResult.setHorizontalAlignment(JLabel.RIGHT);
        add(lblResult);

        resultTxf = new JTextField();
        resultTxf.setBounds(150, 100, 100, 20);
        resultTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        resultTxf.setEditable(false);
        resultTxf.setFocusable(false);
        resultTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(resultTxf);

        calc = new JButton("Calcular");
        calc.setBounds(35, 130, 210, 25);
        calc.setBackground(Color.LIGHT_GRAY);
        calc.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        add(calc);
        calc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double valorFinal = Double.parseDouble(valorFinalTxf.getText());
                double valorDesconto = Double.parseDouble(valorDescontoTxf.getText());
                double valorInicial = Operacoes.ValorOriginal(valorFinal, valorDesconto);
                resultTxf.setText(String.format("%.2f", valorInicial));
            }
        });

    }
    private void telaRegraTres(){
        JLabel lblTxt, lblA, lblB, lblIgual1, lblIgual2, lblR1, lblR2;
        JTextField aTxf, bTxf, r1Txf, r2Txf;
        JButton calc;
        lblTxt = new JLabel("Regra de três");
        lblTxt.setBounds(20, 10, 300, 20);
        add(lblTxt);
        lblA = new JLabel("a:");
        lblA.setBounds(20, 40, 120, 20);
        lblA.setForeground(Color.RED);
        add(lblA);

        aTxf = new JTextField();
        aTxf.setBounds(35, 40, 80, 20);
        aTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        aTxf.setBackground(new Color(255, 240, 240));
        aTxf.setHorizontalAlignment(JTextField.RIGHT);
        add(aTxf);

        lblB = new JLabel("b: ");
        lblB.setBounds(20, 70, 120, 20);
        lblB.setForeground(Color.BLUE);
        add(lblB);

        bTxf = new JTextField();
        bTxf.setBounds(35, 70, 80, 20);
        bTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        bTxf.setHorizontalAlignment(JTextField.RIGHT);
        bTxf.setBackground(new Color(230, 250, 255));
        add(bTxf);

        lblIgual1 = new JLabel("=");
        lblIgual1.setBounds(130, 40, 20, 20);
        add(lblIgual1);

        lblIgual2 = new JLabel("=");
        lblIgual2.setBounds(130, 70, 20, 20);
        add(lblIgual2);

        lblR1 = new JLabel("r1: ");
        lblR1.setBounds(150, 40, 120, 20);
        lblR1.setForeground(Color.GREEN);
        add(lblR1);

        r1Txf = new JTextField();
        r1Txf.setBounds(170, 40, 80, 20);
        r1Txf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        r1Txf.setBackground(new Color(235, 255, 215));
        r1Txf.setHorizontalAlignment(JTextField.RIGHT);
        add(r1Txf);

        lblR2 = new JLabel("r2:");
        lblR2.setBounds(150, 70, 20, 20);
        lblR2.setForeground(Color.GRAY);
        add(lblR2);

        r2Txf = new JTextField();
        r2Txf.setBounds(170, 70, 80, 20);
        r2Txf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        r2Txf.setOpaque(false);
        r2Txf.setHorizontalAlignment(JTextField.RIGHT);
        add(r2Txf);


        calc = new JButton("Calcular");
        calc.setBounds(35, 110, 210, 25);
        calc.setBackground(Color.LIGHT_GRAY);
        calc.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        add(calc);
        calc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                double valorA = Double.parseDouble(aTxf.getText());
                double valorB = Double.parseDouble(bTxf.getText());
                double valorR1 = Double.parseDouble(r1Txf.getText());
                double valorR2 = Operacoes.RegraTres(valorA, valorB, valorR1);
                r2Txf.setText(String.format("%.2f", valorR2));
            }
        });
    }
    private void telaGerador (){
        JLabel lblTxt, lblTamanho;
        JCheckBox maiusculas, minusculas, numeros, simbolos;
        JSpinner tamanho;
        JTextField senhaTxf;
        JButton btnGerar;

        lblTxt = new JLabel("Gerador de Senha ");
        lblTxt.setBounds(20, 10, 300, 20);
        add(lblTxt);

        maiusculas = new JCheckBox("Maiúsculas");
        maiusculas.setBounds(20, 40, 100, 20);
        add(maiusculas);

        minusculas = new JCheckBox("Minúsculas");
        minusculas.setBounds(150, 40, 100, 20);
        add(minusculas);

        numeros = new JCheckBox("Números");
        numeros.setBounds(20, 70, 100, 20);
        add(numeros);

        simbolos = new JCheckBox("Simbolos");
        simbolos.setBounds(150, 70, 120, 20);
        add(simbolos);

        lblTamanho = new JLabel("Tamanho");
        lblTamanho.setBounds(20, 100, 100, 20);
        add(lblTamanho);

        tamanho = new JSpinner();
        tamanho.setBounds(90, 100, 50, 20);
        add(tamanho);

        btnGerar = new JButton("Gerar");
        btnGerar.setBounds(160, 100, 100, 20);
        add(btnGerar);
        senhaTxf = new JTextField();
        senhaTxf.setBounds(20, 130, 240, 20);
        senhaTxf.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.gray));
        senhaTxf.setFocusable(false);
        add(senhaTxf);
        btnGerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tamanhoSt = (int) tamanho.getValue();
                String senha = Operacoes.GeradorSenha(tamanhoSt, maiusculas, minusculas, numeros, simbolos);
                senhaTxf.setText(" "+senha);
            }
        });
    }
}
