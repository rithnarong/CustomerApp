import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerApp extends JFrame {
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton prevButton, nextButton;
    private int currentIndex = 0;

    private Customer[] customers = {
            new Customer(1, "Chenda", "Sovisal", "092888999"),
            new Customer(2, "Kom", "Lina", "092000999"),
            new Customer(3, "Chan", "Seyha", "092777666")
    };

    public CustomerApp() {
        setTitle("Customer");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Labels and Text fields
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        idField = new JTextField(15);
        idField.setEditable(false);
        add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Last Name:"), gbc);

        gbc.gridx = 1;
        lastNameField = new JTextField(15);
        lastNameField.setEditable(false);
        add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("First Name:"), gbc);

        gbc.gridx = 1;
        firstNameField = new JTextField(15);
        firstNameField.setEditable(false);
        add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        phoneField = new JTextField(15);
        phoneField.setEditable(false);
        add(phoneField, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel();
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(buttonPanel, gbc);

        // Button Actions
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateFields();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < customers.length - 1) {
                    currentIndex++;
                    updateFields();
                }
            }
        });

        // Initial data
        updateFields();

        // Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateFields() {
        Customer customer = customers[currentIndex];
        idField.setText(String.valueOf(customer.getId()));
        lastNameField.setText(customer.getLastName());
        firstNameField.setText(customer.getFirstName());
        phoneField.setText(customer.getPhone());

        prevButton.setEnabled(currentIndex > 0);
        nextButton.setEnabled(currentIndex < customers.length - 1);
    }

    public static void main(String[] args) {
        new CustomerApp();
    }
}

class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String phone;

    public Customer(int id, String lastName, String firstName, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }
}
