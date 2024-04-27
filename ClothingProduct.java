
public class ClothingProduct extends Product {
    private String size;
    private String fabric;

   
    public ClothingProduct(int productId, String name, double price, String size, String fabric) {
        super(productId, name, price); 
        this.fabric = fabric;
    }

    
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    
    @Override
    public void displayDetails() {
        System.out.println("Clothing Product Details:");
        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Size: " + size);
        System.out.println("Fabric: " + fabric);
    }
}
