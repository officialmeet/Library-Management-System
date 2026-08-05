import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> catalog = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    private static final double DAILY_FINE_RATE = 2.50; 

    public void addBook(Book book) {
        catalog.put(book.getIsbn(), book);
        System.out.println("Book added to catalog: " + book.getTitle());
    }

    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println("Member registered: " + member.getName());
    }

    public boolean checkOutBook(String memberId, String isbn) {
        Member member = members.get(memberId);
        Book book = catalog.get(isbn);

        if (member == null || book == null) {
            System.out.println("Error: Invalid Member ID or ISBN.");
            return false;
        }

        if (member.getUnpaidFines() > 10.00) {
            System.out.println("Checkout blocked: Member has unpaid fines exceeding $10.00!");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Checkout failed: " + book.getTitle() + " is currently checked out.");
            return false;
        }

        // Issue book for 14 days
        book.setAvailable(false);
        book.setDueDate(LocalDate.now().plusDays(14));
        member.borrowBook(book);
        System.out.printf("Success: '%s' checked out to %s. Due Date: %s%n", 
                          book.getTitle(), member.getName(), book.getDueDate());
        return true;
    }

    public boolean returnBook(String memberId, String isbn, LocalDate actualReturnDate) {
        Member member = members.get(memberId);
        Book book = catalog.get(isbn);

        if (member == null || book == null || !member.getBorrowedBooks().contains(book)) {
            System.out.println("Error: Return processing failed. Check details.");
            return false;
        }

        // Calculate Overdue Fine
        if (actualReturnDate.isAfter(book.getDueDate())) {
            long daysOverdue = ChronoUnit.DAYS.between(book.getDueDate(), actualReturnDate);
            double fine = daysOverdue * DAILY_FINE_RATE;
            member.addFine(fine);
            System.out.printf("OVERDUE NOTICE: Book returned %d days late. Fine of $%.2f applied to %s.%n", 
                              daysOverdue, fine, member.getName());
        }

        book.setAvailable(true);
        book.setDueDate(null);
        member.returnBook(book);
        System.out.println("Book successfully returned: " + book.getTitle());
        return true;
    }

    public void displayCatalog() {
        System.out.println("\n=== CURRENT LIBRARY CATALOG ===");
        for (Book b : catalog.values()) {
            System.out.println(b);
        }
    }
}