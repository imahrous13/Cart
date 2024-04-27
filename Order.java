import java.util.ArrayList;
import java.util.List;

public class Order {
    private int customerId;
    private int orderId;
    private List<Product> products;
    private double totalPrice;

    
    public Order(int customerId, int orderId,  List<Product> products, double totalPrice) {
        this.customerId = Math.abs(customerId); 
        this.orderId = Math.abs(orderId); 
        this.products = products;
        this.totalPrice = Math.abs(totalPrice); 
    }

    
    public void printOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " (Price: $" + product.getPrice() + ")");
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}

