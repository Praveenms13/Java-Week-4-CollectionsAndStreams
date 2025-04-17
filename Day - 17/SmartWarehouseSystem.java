import java.util.ArrayList;
import java.util.List;
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void showDetails();
}
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public void showDetails() {
        System.out.println("Electronics: " + getName() + ", Brand: " + brand);
    }
}
class Groceries extends WarehouseItem {
    private String expirationDate;

    public Groceries(String name, String expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }

    @Override
    public void showDetails() {
        System.out.println("Groceries: " + getName() + ", Expiration Date: " + expirationDate);
    }
}
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void showDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.showDetails();
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", "Samsung"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Milk", "2025-05-01"));
        groceriesStorage.addItem(new Groceries("Apples", "2025-04-30"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        System.out.println("=== Electronics ===");
        WarehouseUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\n=== Groceries ===");
        WarehouseUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\n=== Furniture ===");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}
