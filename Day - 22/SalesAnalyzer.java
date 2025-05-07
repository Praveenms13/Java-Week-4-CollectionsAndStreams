import java.util.*;
import java.util.stream.Collectors;

class Sale {
    String productId;
    int quantity;
    double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return String.format("ProductSales{productId='%s', totalRevenue=%.2f}", productId, totalRevenue);
    }

    public String getProductId() {
        return productId;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}

public class SalesAnalyzer {

    public static List<ProductSales> getTopProductSales(List<Sale> sales) {
        Map<String, Double> revenueMap = sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .collect(Collectors.groupingBy(
                        Sale::getProductId,
                        Collectors.summingDouble(s -> s.getQuantity() * s.getPrice())
                ));

        return revenueMap.entrySet().stream()
                .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P1", 15, 10.0),
                new Sale("P2", 5, 25.0),
                new Sale("P1", 12, 10.0),
                new Sale("P3", 20, 5.0),
                new Sale("P4", 30, 2.0),
                new Sale("P5", 11, 50.0),
                new Sale("P6", 50, 1.0),
                new Sale("P7", 8, 100.0)
        );

        List<ProductSales> topSales = getTopProductSales(sales);

        System.out.println("Top 5 Products by Revenue:");
        topSales.forEach(System.out::println);
    }
}
