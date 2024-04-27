import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements ActionListener {
    private JTextField customerIdField, nameField, addressField;
    private JComboBox<String> productComboBox;
    private JButton addButton, placeOrderButton;
    private JTextArea orderTextArea;
    private Cart cart;

    private String[] productNames = {"Samsung smartphone", "T-shirt", "OOP book"};

    public MainGUI() {
        setTitle("Shopping Cart");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdLabel.setBounds(50, 50, 100, 30);
        add(customerIdLabel);

        customerIdField = new JTextField();
        customerIdField.setBounds(160, 50, 200, 30);
        add(customerIdField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(160, 100, 200, 30);
        add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 150, 100, 30);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(160, 150, 200, 30);
        add(addressField);

        JLabel productLabel = new JLabel("Select Product:");
        productLabel.setBounds(50, 200, 100, 30);
        add(productLabel);

        productComboBox = new JComboBox<>(productNames);
        productComboBox.setBounds(160, 200, 200, 30);
        add(productComboBox);

        addButton = new JButton("Add to Cart");
        addButton.setBounds(380, 200, 100, 30);
        addButton.addActionListener(this);
        add(addButton);

        placeOrderButton = new JButton("Place Order");
        placeOrderButton.setBounds(50, 250, 150, 30);
        placeOrderButton.addActionListener(this);
        add(placeOrderButton);

        orderTextArea = new JTextArea();
        orderTextArea.setBounds(50, 300, 430, 150);
        orderTextArea.setEditable(false);
        add(orderTextArea);

        cart = new Cart(0, 0); 
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String selectedProduct = (String) productComboBox.getSelectedItem();
            switch (selectedProduct) {
                case "Samsung smartphone":
                    cart.addProduct(new ElectronicProduct(1, "smartphone", 599.9, "Samsung", 1));
                    break;
                case "T-shirt":
                    cart.addProduct(new ClothingProduct(2, "T-shirt", 19.99, "Medium", "Cotton"));
                    break;
                case "OOP book":
                    cart.addProduct(new BookProduct(3, "OOP", 39.99, "O’Reilly", "X Publications"));
                    break;
            }
            updateOrderTextArea();
        } else if (e.getSource() == placeOrderButton) {
            double totalPrice = cart.calculatePrice();
            Order order = new Order(Integer.parseInt(customerIdField.getText()), 1, cart.getProducts(), totalPrice);
            orderTextArea.setText("\nOrder placed for customer " + Integer.parseInt(customerIdField.getText()) + ". Total price: $" + String.format("%.2f", totalPrice));
        }
    }

    private void updateOrderTextArea(){
        orderTextArea.setText("Products in Cart:\n");
        for (Product product : cart.getProducts()) {
            orderTextArea.append("- " + product.getName() + " ($" + product.getPrice() + ")\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI MainGUI = new MainGUI();
            MainGUI.setVisible(true);
        });
    }
}
