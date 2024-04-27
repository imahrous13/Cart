
public abstract class Product {
    private int productId;
    private String name;
    private double price;

    
    public Product(int productId, String name, double price) {
        this.productId = Math.abs(productId); 
        this.name = name;
        this.price = Math.abs(price);
    }

    
    public abstract void displayDetails();

    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = Math.abs(productId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.abs(price);
    }
}
