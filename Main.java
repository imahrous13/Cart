import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElectronicProduct smartphone = new ElectronicProduct(1, "smartphone", 599.9, "Samsung", 1);

        ClothingProduct tShirt = new ClothingProduct(2, "T-shirt", 19.99, "Medium", "Cotton");

        BookProduct oopBook = new BookProduct(3, "OOP", 39.99, "O’Reilly", "X Publications");

        System.out.println("Our available products are \n -Samsung smartphone  with one year warranty for 599.9 $");
        System.out.println(" -Cotton T-shirt for 19.99 $");
        System.out.println(" -OOP book by O’Reilly for 39.99 $ \n");

        
        System.out.print("Enter your customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter your address: ");
        String customerAddress = scanner.nextLine();

        
        Customer customer = new Customer(customerId, customerName, customerAddress);

        
        
        System.out.print("\n How many products do you want to order? \n");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); 

        
        Cart cart = new Cart(customer.getCustomerId(), numProducts);


        System.out.println("\nEnter your order by writing one of those (smartphone, T-shirt, or OOP book \n");
        
        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
            

            
            Product product;
            switch (productName.toLowerCase()) {
                case "smartphone":
                    product = smartphone;
                    break;
                case "t-shirt":
                    product = tShirt;
                    break;
                case "oop":
                    product = oopBook;
                    break;
                default:
                    System.out.println("Invalid product name. Skipping this product.");
                    continue;
            }

            cart.addProduct(product);
        }

        
        System.out.print("\n Do you want to place an order? (yes/no): ");
        String orderChoice = scanner.next().toLowerCase();
        if (orderChoice.equals("yes")) {
            
            double totalPrice = cart.calculatePrice();

            
            Order order = new Order(customer.getCustomerId(), 1, cart.getProducts(), totalPrice);

            
            order.printOrderInfo();
        } else {
            System.out.println("Order not placed. Thank you!");
        }
    }
}
