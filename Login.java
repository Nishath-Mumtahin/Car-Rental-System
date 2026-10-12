import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {

    // Rental rate constants
    final int TOYOTA_RATE = 3000;
    final int HONDA_RATE = 3500;
    final int BMW_RATE = 7000;
    final int MERCEDES_RATE = 9000;

    Login() {

        setSize(650, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 235, 242));

        JLabel text = new JLabel("Welcome to Our Car Rental");
        text.setBounds(150, 30, 350, 35);
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setFont(new Font("Segoe UI", Font.BOLD, 24));
        text.setForeground(new Color(150, 45, 80));
        add(text);

        JLabel name = new JLabel("Customer Name:");
        name.setFont(new Font("Segoe UI", Font.BOLD, 14));
        name.setForeground(new Color(150, 45, 80));
        add(name);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(200, 90, 280, 32);
        add(nameTextField);

        JLabel car = new JLabel("Select Car:");
        car.setBounds(30, 130, 120, 25);
        add(car);

        String[] cars = {
                "Toyota Corolla - Tk 3000/day",
                "Honda Civic - Tk 3500/day",
                "BMW X5 - Tk 7000/day",
                "Mercedes C-Class - Tk 9000/day"
        };

        JComboBox<String> carBox = new JComboBox<>(cars);
        carBox.setBounds(200, 140, 280, 32);
        add(carBox);

        JLabel days = new JLabel("Rental Days:");
        days.setBounds(30, 180, 120, 25);
        add(days);

        JTextField daysTextField = new JTextField();
        daysTextField.setBounds(200, 190, 280, 32);
        add(daysTextField);

        JButton rentButton = new JButton("Rent Car");
        rentButton.setBounds(200, 270, 130, 40);
        rentButton.setBackground(new Color(236, 112, 145));
        rentButton.setForeground(Color.WHITE);
        rentButton.setFocusPainted(false);
        add(rentButton);

        JButton clear = new JButton("Clear");
        clear.setBounds(350, 270, 130, 40);
        clear.setBackground(new Color(236, 112, 145));
        clear.setForeground(Color.WHITE);
        clear.setFocusPainted(false);
        add(clear);

        // Rent Button
        rentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    String customerName = nameTextField.getText().trim();

                    // Name validation
                    if (customerName.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter your name.");
                        return;
                    }

                    // Days validation
                    int days = Integer.parseInt(daysTextField.getText());

                    if (days <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Rental days must be greater than 0.");
                        return;
                    }

                    String selectedCar = (String) carBox.getSelectedItem();

                    int rate = 0;

                    if (selectedCar.contains("Toyota"))
                        rate = TOYOTA_RATE;
                    else if (selectedCar.contains("Honda"))
                        rate = HONDA_RATE;
                    else if (selectedCar.contains("BMW"))
                        rate = BMW_RATE;
                    else if (selectedCar.contains("Mercedes"))
                        rate = MERCEDES_RATE;
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Invalid car selected.");
                        return;
                    }

                    int totalRent = rate * days;

                    String receipt =
                            "=========== CONFIRMATION SLIP ===========\n\n" +
                                    "Customer : " + customerName + "\n" +
                                    "Car : " + selectedCar + "\n" +
                                    "Rental Days : " + days + "\n" +
                                    "Rent Per Day : Tk " + rate + "\n\n" +
                                    "Total Bill : Tk " + totalRent + "\n\n" +
                                    "Status : Confirmed\n\n" +
                                    "Thank you for choosing our service!";

                    JOptionPane.showMessageDialog(
                            null,
                            receipt,
                            "Rental Confirmation",
                            JOptionPane.INFORMATION_MESSAGE);

                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a valid number for rental days.");
                }

            }
        });

        // Clear Button
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                nameTextField.setText("");
                daysTextField.setText("");
                carBox.setSelectedIndex(0);

            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}