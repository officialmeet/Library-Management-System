import java.time.LocalDate;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    private LocalDate dueDate;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.dueDate = null;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public LocalDate getDueDate() { return dueDate; }

    public void setAvailable(boolean available) { isAvailable = available; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    @Override
    public String toString() {
        String status = isAvailable ? "AVAILABLE" : "CHECKED OUT (Due: " + dueDate + ")";
        return String.format("[%s] %s by %s - %s", isbn, title, author, status);
    }
}