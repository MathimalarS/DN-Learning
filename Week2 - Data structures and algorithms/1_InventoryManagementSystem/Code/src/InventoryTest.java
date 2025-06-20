public class InventoryTest {
    public static void main(String[] args) {
        System.out.println("Welcome to the Inventory Management System!\n");

        Inventory inventory = new Inventory();
        Product laptop = new Product("P001", "Laptop", 50, 1200.00);
        Product smartphone = new Product("P002", "Smartphone", 200, 800.00);
        Product tablet = new Product("P003", "Tablet", 150, 400.00);

        inventory.addProduct(laptop);
        inventory.addProduct(smartphone);
        inventory.addProduct(tablet);

        inventory.displayAllProducts();

        System.out.println("Updating Smartphone details...");
        smartphone.setPrice(750.00);
        smartphone.setQuantity(180);
        inventory.updateProduct(smartphone);

        System.out.println("Removing Tablet from inventory...");
        inventory.removeProduct("P003");

        inventory.displayAllProducts();

        System.out.println("Thank you for using the Inventory Management System!");
    }
}
