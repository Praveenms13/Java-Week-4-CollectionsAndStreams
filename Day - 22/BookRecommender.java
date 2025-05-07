import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("BookRecommendation{title='%s', rating=%.2f}", title, rating);
    }
}

public class BookRecommender {

    public static List<List<BookRecommendation>> getTopBookRecommendations(List<Book> books) {
        List<BookRecommendation> topBooks = books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase("Science Fiction") && b.getRating() > 4.0)
                .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
                .sorted(Comparator.comparingDouble(BookRecommendation::rating).reversed())
                .limit(10)
                .collect(Collectors.toList());

        List<List<BookRecommendation>> pages = new ArrayList<>();
        for (int i = 0; i < topBooks.size(); i += 5) {
            pages.add(topBooks.subList(i, Math.min(i + 5, topBooks.size())));
        }

        return pages;
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.6),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.3),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.5),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.4),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.6),
                new Book("Blindsight", "Peter Watts", "Science Fiction", 4.0),
                new Book("Childhood's End", "Arthur C. Clarke", "Science Fiction", 4.2),
                new Book("Old Man's War", "John Scalzi", "Science Fiction", 4.3),
                new Book("1984", "George Orwell", "Dystopian", 4.4)
        );

        List<List<BookRecommendation>> pages = getTopBookRecommendations(books);

        for (int i = 0; i < pages.size(); i++) {
            System.out.println("Page " + (i + 1) + ":");
            pages.get(i).forEach(System.out::println);
            System.out.println();
        }
    }
}
