import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class App extends JFrame {
    Container c;
    JLabel labNumber, labAnswer;
    JTextField txtNumber;
    JButton btnFind;

    App() {
        c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        labNumber = new JLabel("Enter a number:");
        txtNumber = new JTextField(10);


        btnFind = new JButton("Find Square");
        labAnswer = new JLabel("");

        Font inputFont = new Font("TIMES NEW ROMAN", Font.PLAIN, 18);
        Font resultFont = new Font("TIMES NEW ROMAN", Font.BOLD, 24);

        labNumber.setFont(inputFont);
        txtNumber.setFont(inputFont);
        btnFind.setFont(inputFont);
        labAnswer.setFont(resultFont);

        inputPanel.add(labNumber);
        inputPanel.add(txtNumber);
        inputPanel.add(btnFind);

        resultPanel.add(labAnswer);

        
        inputPanel.setBackground(new Color(62, 109, 181));  
        resultPanel.setBackground(new Color(230, 230, 230));  

        c.add(inputPanel, BorderLayout.CENTER);
        c.add(resultPanel, BorderLayout.SOUTH);

        ActionListener a = (ae) -> {
        labAnswer.setText("");
            try {
                double num = Double.parseDouble(txtNumber.getText());
                double res = num * num;
                String msg = "Square = " + String.format("%.2f", res);
                labAnswer.setText(msg);
            } catch (NumberFormatException e) {
                labAnswer.setText("Please enter valid numbers");
            }

        };
        btnFind.addActionListener(a);

        setTitle("Square Finder App");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class P1 {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new App();
        });
    }
}
