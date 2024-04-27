import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int customerId;
    private int nProducts;
    private List<Product> products; 

    
    public Cart(int customerId, int nProducts) {
        this.customerId = Math.abs(customerId); 
        this.nProducts = Math.abs(nProducts); 
        this.products = new ArrayList<>(nProducts); 
    }

    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getNProducts() {
        return nProducts;
    }

    public void setNProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    
    public void addProduct(Product product) {
        products.add(product);
    }

    
    public void removeProduct(Product product) {
        products.remove(product);
    }

    
    public double calculatePrice() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    
    public void placeOrder() {
        System.out.println("Order placed for customer " + customerId + ". Total price: $" + calculatePrice());
    }
}
