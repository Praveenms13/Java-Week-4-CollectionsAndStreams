import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealName();
    boolean isValid();
}

class VegetarianMeal implements MealPlan {
    private String name;

    public VegetarianMeal(String name) {
        this.name = name;
    }

    public String getMealName() {
        return name;
    }

    public boolean isValid() {
        return name != null && name.toLowerCase().contains("veg");
    }
}

class VeganMeal implements MealPlan {
    private String name;

    public VeganMeal(String name) {
        this.name = name;
    }

    public String getMealName() {
        return name;
    }

    public boolean isValid() {
        return name != null && name.toLowerCase().contains("vegan");
    }
}

class KetoMeal implements MealPlan {
    private String name;

    public KetoMeal(String name) {
        this.name = name;
    }

    public String getMealName() {
        return name;
    }

    public boolean isValid() {
        return name != null && name.toLowerCase().contains("keto");
    }
}

class HighProteinMeal implements MealPlan {
    private String name;

    public HighProteinMeal(String name) {
        this.name = name;
    }

    public String getMealName() {
        return name;
    }

    public boolean isValid() {
        return name != null && name.toLowerCase().contains("protein");
    }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> List<T> generateValidPlan(List<T> inputMeals) {
        List<T> validMeals = new ArrayList<>();
        for (T meal : inputMeals) {
            if (meal.isValid()) {
                validMeals.add(meal);
            }
        }
        return validMeals;
    }

    public static void displayMeals(List<? extends MealPlan> meals) {
        for (MealPlan meal : meals) {
            System.out.println("Meal: " + meal.getMealName());
        }
    }
}

public class PersonalizedMealPlanner {
    public static void main(String[] args) {
        Meal<VeganMeal> veganMealPlan = new Meal<>();
        veganMealPlan.addMeal(new VeganMeal("Vegan Salad"));
        veganMealPlan.addMeal(new VeganMeal("Grilled Tofu Vegan Style"));
        veganMealPlan.addMeal(new VeganMeal("Tofu Stir Fry")); // Invalid for demo

        Meal<KetoMeal> ketoMealPlan = new Meal<>();
        ketoMealPlan.addMeal(new KetoMeal("Keto Chicken Bowl"));
        ketoMealPlan.addMeal(new KetoMeal("Keto Avocado Salad"));

        System.out.println("=== Valid Vegan Meals ===");
        List<VeganMeal> validVeganMeals = MealPlanGenerator.generateValidPlan(veganMealPlan.getMeals());
        MealPlanGenerator.displayMeals(validVeganMeals);

        System.out.println("\n=== Valid Keto Meals ===");
        List<KetoMeal> validKetoMeals = MealPlanGenerator.generateValidPlan(ketoMealPlan.getMeals());
        MealPlanGenerator.displayMeals(validKetoMeals);
    }
}
