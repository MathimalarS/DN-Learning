import java.util.Arrays;
import java.util.Comparator;

public class Library {

    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] sortedBooks, String targetTitle) {
        int low = 0;
        int high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = sortedBooks[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (cmp == 0) {
                return sortedBooks[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book(2, "To Kill a Mockingbird", "Harper Lee"),
                new Book(3, "1984", "George Orwell"),
                new Book(4, "Pride and Prejudice", "Jane Austen"),
                new Book(5, "Moby Dick", "Herman Melville")
        };

        String searchTitle = "1984";

        System.out.println("Performing linear search for: " + searchTitle);
        Book foundBook = linearSearch(books, searchTitle);
        System.out.println(foundBook != null ? "Found: " + foundBook : "Book not found.");

        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\nPerforming binary search for: " + searchTitle);
        foundBook = binarySearch(sortedBooks, searchTitle);
        System.out.println(foundBook != null ? "Found: " + foundBook : "Book not found.");
    }
}
