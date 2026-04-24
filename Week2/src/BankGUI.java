import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BankGUI {
    private static double balance = 0.0;

    public static void main(String[] args){
        JFrame frame = new JFrame("Bank GUI");
        frame.setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Bank Application", SwingConstants.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel amountLabel = new JLabel("Enter Current Balance: ");
        JTextField amountField = new JTextField(10);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10 , 10));

        JButton depositButton = new JButton("Deposit");
        JButton withdrawalButton = new JButton("WithDrawal");
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawalButton);

        JLabel resultLabel = new JLabel("Balance: $0.00", SwingConstants.CENTER);
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.add(resultLabel, BorderLayout.SOUTH);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if(amount <= 0){
                        resultLabel.setText("Enter a deposit greater than 0.");
                    }else {
                        balance += amount;
                        resultLabel.setText("Balance: $" + balance);
                    }
                    amountField.setText("");
                }catch (NumberFormatException exception){
                    resultLabel.setText("Enter a valid number.");
                }
            }
        });

        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if(amount <= 0){
                        resultLabel.setText("Enter a withdrawal greater than 0.");
                    }else if(amount > balance){
                        resultLabel.setText("Insufficient funds. Withdrawal denied. Balance: $" + balance);
                    }else {
                        balance -= amount;
                        resultLabel.setText("Balance: $" + balance);
                    }
                    amountField.setText("");
                }catch (NumberFormatException exception){
                    resultLabel.setText("Enter a valid number.");
                }
            }
        });

        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
