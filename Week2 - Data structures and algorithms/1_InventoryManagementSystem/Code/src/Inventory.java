import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Added product: " + product);
    }

    public void updateProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
            System.out.println("Updated product: " + product);
        } else {
            System.out.println("Oops! No product found with ID: " + product.getProductId());
        }
    }

    public void removeProduct(String productId) {
        Product removed = products.remove(productId);
        if (removed != null) {
            System.out.println("Removed product: " + removed);
        } else {
            System.out.println("No product found with ID: " + productId);
        }
    }

    public Product findProductById(String productId) {
        return products.get(productId);
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("The inventory is currently empty.");
            return;
        }
        System.out.println("\n--- Inventory List ---");
        for (Product product : products.values()) {
            System.out.println(product);
        }
        System.out.println("----------------------\n");
    }
}
