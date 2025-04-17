import java.util.ArrayList;
import java.util.List;
interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    public void showDetails() {
        System.out.println("Product: " + name + ", Price: " + price + ", Category: " + category.getCategoryName());
    }

    public T getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

class Catalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void displayCatalog() {
        for (Product<? extends Category> product : products) {
            product.showDetails();
        }
    }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("The Alchemist", 15.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 25.50, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 499.99, new GadgetCategory());

        Catalog catalog = new Catalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        System.out.println("=== Before Discount ===");
        catalog.displayCatalog();

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 15);

        System.out.println("\n=== After Discount ===");
        catalog.displayCatalog();
    }
}
