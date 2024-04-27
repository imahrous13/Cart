
public class BookProduct extends Product {
    private String author;
    private String publisher;

    
    public BookProduct(int productId, String name, double price, String author, String publisher) {
        super(productId, name, price); 
        this.author = author;
        this.publisher = publisher;
    }

    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    
    @Override
    public void displayDetails() {
        System.out.println("Book Product Details:");
        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
    }
}
