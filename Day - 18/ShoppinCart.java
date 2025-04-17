import java.util.*;

class ShoppingCart {
    private HashMap<String, Double> productPriceMap = new HashMap<>();
    private LinkedHashMap<String, Double> cartOrderMap = new LinkedHashMap<>();

    public void addProduct(String productName, double price) {
        productPriceMap.put(productName, price);
        cartOrderMap.put(productName, price);
    }

    public void displayCartInOrder() {
        for (Map.Entry<String, Double> entry : cartOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    public void displayCartSortedByProductName() {
        TreeMap<String, Double> sortedProducts = new TreeMap<>(productPriceMap);
        for (Map.Entry<String, Double> entry : sortedProducts.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    public void displayCartSortedByPrice() {
        List<Map.Entry<String, Double>> list = new ArrayList<>(productPriceMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Double> entry : list) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }
}

public class ShoppinCart {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Apple", 1.20);
        cart.addProduct("Banana", 0.80);
        cart.addProduct("Orange", 1.50);
        cart.addProduct("Mango", 2.00);

        System.out.println("Cart in order of addition:");
        cart.displayCartInOrder();

        System.out.println("\nCart sorted by product name:");
        cart.displayCartSortedByProductName();

        System.out.println("\nCart sorted by product price:");
        cart.displayCartSortedByPrice();
    }
}
