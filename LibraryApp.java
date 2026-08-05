import java.time.LocalDate;

public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   ENTERPRISE LIBRARY MANAGEMENT SYSTEM   ");
        System.out.println("==========================================");

        Library lib = new Library();

        // Add Books
        lib.addBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch"));
        lib.addBook(new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman"));
        lib.addBook(new Book("978-0132350884", "Clean Code", "Robert C. Martin"));

        // Register Members
        lib.registerMember(new Member("MEM-101", "Alex Mercer"));
        lib.registerMember(new Member("MEM-102", "Elena Rostova"));

        // Display Initial Catalog
        lib.displayCatalog();

        // Perform Checkout
        System.out.println("\n--- Executing Transactions ---");
        lib.checkOutBook("MEM-101", "978-0134685991");

        // Simulate Overdue Return (Returned 20 days later instead of 14)
        System.out.println("\n--- Processing Return ---");
        LocalDate simulatedReturnDate = LocalDate.now().plusDays(20);
        lib.returnBook("MEM-101", "978-0134685991", simulatedReturnDate);

        // Display Updated Catalog
        lib.displayCatalog();
    }
}