import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora Visual");
        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextField campo1 = new JTextField();
        campo1.setBounds(50, 30, 100, 30);

        JTextField campo2 = new JTextField();
        campo2.setBounds(200, 30, 100, 30);


        String[] operacoes = {"+ Soma", "- Subtração", "* Multiplicação", "/ Divisão"};
        JComboBox<String> operacaoBox = new JComboBox<>(operacoes);
        operacaoBox.setBounds(50, 80, 250, 30);


        JButton botao = new JButton("Calcular");
        botao.setBounds(100, 130, 150, 30);


        JLabel resultado = new JLabel("Resultado: ");
        resultado.setBounds(50, 180, 250, 30);


        botao.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(campo1.getText());
                double num2 = Double.parseDouble(campo2.getText());
                String operacao = (String) operacaoBox.getSelectedItem();
                double res = 0;

                switch (operacao) {
                    case "+ Soma":
                        res = num1 + num2;
                        break;
                    case "- Subtração":
                        res = num1 - num2;
                        break;
                    case "* Multiplicação":
                        res = num1 * num2;
                        break;
                    case "/ Divisão":
                        if (num2 == 0) {
                            resultado.setText("Erro: divisão por zero!");
                            return;
                        }
                        res = num1 / num2;
                        break;
                }

                resultado.setText("Resultado: " + res);

            } catch (NumberFormatException ex) {
                resultado.setText("Digite números válidos!");
            }
        });


        frame.add(campo1);
        frame.add(campo2);
        frame.add(operacaoBox);
        frame.add(botao);
        frame.add(resultado);


        frame.setVisible(true);
    }
}
