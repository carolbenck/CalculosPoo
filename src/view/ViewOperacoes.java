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
                if (valorTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(valorTxf, "Campo Valor Inicial Obrigatório");
                    valorTxf.requestFocus();
                    return;
                }
                if (descTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(valorTxf, "Campo Desconto Obrigatório");
                    descTxf.requestFocus();
                    return;
                }
                try {
                    double valor = Double.parseDouble(valorTxf.getText());
                    double desconto = Double.parseDouble(descTxf.getText());
                    if(valor <= 0){
                        JOptionPane.showMessageDialog(null, "O campo Valor Inicial deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (desconto< 0 || desconto > 100){
                        JOptionPane.showMessageDialog(descTxf, "O desconto deve estar entre 0 e 100%", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double valorDesconto = Operacoes.Desconto(valor, desconto);
                    resultTxf.setText(String.format("%.2f", valorDesconto));
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog( null, "Digite valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
                if (valorTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(valorTxf, "Campo Valor Inicial Obrigatório");
                    valorTxf.requestFocus();
                    return;
                }
                if (acrescimoTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(valorTxf, "Campo Acréscimo Obrigatório");
                    acrescimoTxf.requestFocus();
                    return;
                }
                try {
                    double valor = Double.parseDouble(valorTxf.getText());
                    double acrescimo = Double.parseDouble(acrescimoTxf.getText());
                    if(valor <= 0){
                        JOptionPane.showMessageDialog(null, "O campo Valor deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(acrescimo<0 || acrescimo >100){
                        JOptionPane.showMessageDialog(acrescimoTxf, "O acréscimo deve estar entre 0% e 100%", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double valorAcrescimo = Operacoes.Acrescimo(valor, acrescimo);
                    resultTxf.setText(String.format("%.2f", valorAcrescimo));
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Digite valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
                if (totalTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(totalTxf, "Campo Total Obrigatorio");
                    totalTxf.requestFocus();
                    return;
                }
                if (porcentagemTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(porcentagemTxf, "Campo Porcentagem Obrigatorio");
                    porcentagemTxf.requestFocus();
                    return;
                }
                try {
                    double valor = Double.parseDouble(totalTxf.getText());
                    double porcentagem = Double.parseDouble(porcentagemTxf.getText());
                    if(valor <= 0){
                        JOptionPane.showMessageDialog(null, "O campo Total deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (porcentagem < 0 || porcentagem > 100){
                        JOptionPane.showMessageDialog(porcentagemTxf, "A porcentagem deve estar entre 0 e 100%", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    double valorCorrespondente = Operacoes.Amostragem1(valor, porcentagem);
                    resultTxf.setText(String.format("%.2f", valorCorrespondente));
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Digite valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
                if (totalTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(totalTxf, "Campo Total Obrigatorio");
                    totalTxf.requestFocus();
                    return;
                }
                if (parteTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(parteTxf, "Campo Parte Obrigatorio");
                    parteTxf.requestFocus();
                    return;
                }
                try {
                    double total = Double.parseDouble(totalTxf.getText());
                    double parte = Double.parseDouble(parteTxf.getText());
                    if(total <= 0){
                        JOptionPane.showMessageDialog(totalTxf, "O campo Total deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        totalTxf.requestFocus();
                        return;
                    }
                    if (parte <=0 ){
                        JOptionPane.showMessageDialog(parteTxf, "O campo Parte deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        parteTxf.requestFocus();
                        return;
                    }
                    double valorCorrespondente = Operacoes.Amostragem2(total, parte);
                    resultTxf.setText(String.format("%.2f", valorCorrespondente));
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Digite valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
                if (valorATxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(valorATxf, "Campo Valor Original Obrigatorio");
                    valorATxf.requestFocus();
                    return;
                }
                if (pagueiBTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(pagueiBTxf, "Campo Valor com Desconto Obrigatorio");
                    pagueiBTxf.requestFocus();
                    return;
                }
                try {
                    double total = Double.parseDouble(valorATxf.getText());
                    double parte = Double.parseDouble(pagueiBTxf.getText());
                    if(total <= 0){
                        JOptionPane.showMessageDialog(valorATxf, "O campo Valor Original deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        valorATxf.requestFocus();
                        return;
                    }
                    if (parte <=0 ){
                        JOptionPane.showMessageDialog(pagueiBTxf, "O campo Valor com Desconto deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        pagueiBTxf.requestFocus();
                        return;
                    }
                    double valorDesconto = Operacoes.ValorA(total, parte);
                    resultTxf.setText(String.format("%.2f", valorDesconto));
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Digite valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
                if (valorInicialTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(valorInicialTxf, "Campo Valor Inicial Obrigatorio");
                    valorInicialTxf.requestFocus();
                    return;
                }
                if (valorFinalTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(valorFinalTxf, "Campo Valor Final Obrigatorio");
                    valorFinalTxf.requestFocus();
                    return;
                }
                try {
                    double valorInicial = Double.parseDouble(valorInicialTxf.getText());
                    double valorFinal = Double.parseDouble(valorFinalTxf.getText());
                    if(valorInicial <= 0){
                        JOptionPane.showMessageDialog(valorInicialTxf, "O campo Valor Inicial deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        valorInicialTxf.requestFocus();
                        return;
                    }
                    if (valorFinal <=0 ){
                        JOptionPane.showMessageDialog(valorFinalTxf, "O campo Valor Final deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        valorFinalTxf.requestFocus();
                        return;
                    }
                    double valorDiferenca = Operacoes.Delta(valorInicial, valorFinal);
                    resultTxf.setText(String.format("%.2f", valorDiferenca));
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Digite valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
                if (valorFinalTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(valorFinalTxf, "Campo Valor Final Obrigatorio");
                    valorFinalTxf.requestFocus();
                    return;
                }
                if (valorDescontoTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(valorDescontoTxf, "Campo Desconto Obrigatorio");
                    valorDescontoTxf.requestFocus();
                    return;
                }
                try {
                double valorFinal = Double.parseDouble(valorFinalTxf.getText());
                double valorDesconto = Double.parseDouble(valorDescontoTxf.getText());
                if (valorFinal <= 0){
                    JOptionPane.showMessageDialog(valorFinalTxf, "O campo Valor Final deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    valorFinalTxf.requestFocus();
                    return;
                }
                if(valorDesconto < 0 || valorDesconto > 100){
                    JOptionPane.showMessageDialog(valorDescontoTxf, "O desconto deve estar entre 0 e 100%", "Erro", JOptionPane.ERROR_MESSAGE);
                    valorDescontoTxf.requestFocus();
                    return;
                }
                double valorInicial = Operacoes.ValorOriginal(valorFinal, valorDesconto);
                resultTxf.setText(String.format("%.2f", valorInicial));
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Digite valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
                if (aTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(aTxf, "Campo A Obrigatorio");
                    aTxf.requestFocus();
                    return;
                }
                if (bTxf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(bTxf, "Campo B Obrigatorio");
                    bTxf.requestFocus();
                    return;
                }
                if (r1Txf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(r1Txf, "Campo R1 Obrigatorio");
                    r1Txf.requestFocus();
                    return;
                }
                try {
                    double valorA = Double.parseDouble(aTxf.getText());
                    double valorB = Double.parseDouble(bTxf.getText());
                    double valorR1 = Double.parseDouble(r1Txf.getText());
                    if (valorA <= 0){
                        JOptionPane.showMessageDialog(aTxf, "O campo A deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        aTxf.requestFocus();
                        return;
                    }
                    if(valorB <= 0){
                        JOptionPane.showMessageDialog(bTxf, "O campo B deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        bTxf.requestFocus();
                        return;
                    }
                    if(valorR1 <= 0){
                        JOptionPane.showMessageDialog(r1Txf, "O campo R1 deve conter valores positivos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        r1Txf.requestFocus();
                        return;
                    }
                    double valorR2 = Operacoes.RegraTres(valorA, valorB, valorR1);
                    r2Txf.setText(String.format("%.2f", valorR2));
                }
                catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, "Digite valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
