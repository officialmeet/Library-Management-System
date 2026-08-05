import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<Book> borrowedBooks;
    private double unpaidFines;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.unpaidFines = 0.0;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public double getUnpaidFines() { return unpaidFines; }

    public void addFine(double amount) { this.unpaidFines += amount; }
    public void payFine(double amount) { this.unpaidFines = Math.max(0, this.unpaidFines - amount); }

    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }
}