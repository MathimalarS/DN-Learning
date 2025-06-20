public class OrderSorter {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        System.out.println("Starting Bubble Sort...");

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() < orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
        System.out.println("Bubble Sort completed.");
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() >= pivot.getTotalPrice()) {
                i++;
                swap(orders, i, j);
            }
        }
        swap(orders, i + 1, high);
        return i + 1;
    }

    private static void swap(Order[] orders, int i, int j) {
        Order temp = orders[i];
        orders[i] = orders[j];
        orders[j] = temp;
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order("O001", "Alice", 250.75),
                new Order("O002", "Bob", 450.50),
                new Order("O003", "Charlie", 150.00),
                new Order("O004", "Diana", 300.20),
                new Order("O005", "Evan", 500.00)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        Order[] bubbleSortedOrders = orders.clone();
        bubbleSort(bubbleSortedOrders);
        System.out.println("Orders after Bubble Sort (by total price descending):");
        printOrders(bubbleSortedOrders);

        Order[] quickSortedOrders = orders.clone();
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("Orders after Quick Sort (by total price descending):");
        printOrders(quickSortedOrders);
    }
}
