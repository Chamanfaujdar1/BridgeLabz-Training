import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getPlanType();
    int getCaloriesPerDay();
    boolean isValidCalories();
}

class VegetarianMeal implements MealPlan {
    private final int caloriesPerDay;

    public VegetarianMeal(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    @Override
    public String getPlanType() {
        return "Vegetarian";
    }

    @Override
    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    @Override
    public boolean isValidCalories() {
        return caloriesPerDay >= 1200 && caloriesPerDay <= 2500;
    }

    @Override
    public String toString() {
        return " Vegetarian Meal Plan | Calories/Day: " + caloriesPerDay;
    }
}

class VeganMeal implements MealPlan {
    private final int caloriesPerDay;

    public VeganMeal(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    @Override
    public String getPlanType() {
        return "Vegan";
    }

    @Override
    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    @Override
    public boolean isValidCalories() {
        return caloriesPerDay >= 1100 && caloriesPerDay <= 2400;
    }

    @Override
    public String toString() {
        return " Vegan Meal Plan | Calories/Day: " + caloriesPerDay;
    }
}

class KetoMeal implements MealPlan {
    private final int caloriesPerDay;

    public KetoMeal(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    @Override
    public String getPlanType() {
        return "Keto";
    }

    @Override
    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    @Override
    public boolean isValidCalories() {
        return caloriesPerDay >= 1300 && caloriesPerDay <= 3000;
    }

    @Override
    public String toString() {
        return "Keto Meal Plan | Calories/Day: " + caloriesPerDay;
    }
}

class HighProteinMeal implements MealPlan {
    private final int caloriesPerDay;
    private final int proteinGrams;

    public HighProteinMeal(int caloriesPerDay, int proteinGrams) {
        this.caloriesPerDay = caloriesPerDay;
        this.proteinGrams = proteinGrams;
    }

    @Override
    public String getPlanType() {
        return "High-Protein";
    }

    @Override
    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public int getProteinGrams() {
        return proteinGrams;
    }

    @Override
    public boolean isValidCalories() {
        return caloriesPerDay >= 1500 && caloriesPerDay <= 3500;
    }

    public boolean isValidProtein() {
        return proteinGrams >= 60 && proteinGrams <= 250;
    }

    @Override
    public String toString() {
        return "High-Protein Meal Plan | Calories/Day: " + caloriesPerDay +
                " | Protein: " + proteinGrams + "g";
    }
}

class Meal<T extends MealPlan> {
    private final List<T> mealPlans;

    public Meal() {
        this.mealPlans = new ArrayList<>();
    }

    public void addMealPlan(T plan) {
        mealPlans.add(plan);
        System.out.println("Added Meal Plan: " + plan.getPlanType());
    }

    public List<T> getAllPlans() {
        return mealPlans;
    }
}

class MealPlanGenerator {

    public static <T extends MealPlan> T validateAndGenerateMealPlan(T plan) {

        if (!plan.isValidCalories()) {
            throw new IllegalArgumentException(
                    "Invalid calories for " + plan.getPlanType() +
                            " plan: " + plan.getCaloriesPerDay()
            );
        }

        if (plan instanceof HighProteinMeal) {
            HighProteinMeal hp = (HighProteinMeal) plan;
            if (!hp.isValidProtein()) {
                throw new IllegalArgumentException(
                        "Invalid protein for High-Protein plan: " + hp.getProteinGrams() + "g"
                );
            }
        }

        System.out.println("Meal Plan Validated & Generated Successfully: " + plan.getPlanType());
        return plan;
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {

        Meal<MealPlan> userMealPlans = new Meal<>();

        VegetarianMeal vegMeal = new VegetarianMeal(1800);
        VeganMeal veganMeal = new VeganMeal(1600);
        KetoMeal ketoMeal = new KetoMeal(2200);
        HighProteinMeal hpMeal = new HighProteinMeal(2500, 140);

        try {
            userMealPlans.addMealPlan(MealPlanGenerator.validateAndGenerateMealPlan(vegMeal));
            userMealPlans.addMealPlan(MealPlanGenerator.validateAndGenerateMealPlan(veganMeal));
            userMealPlans.addMealPlan(MealPlanGenerator.validateAndGenerateMealPlan(ketoMeal));
            userMealPlans.addMealPlan(MealPlanGenerator.validateAndGenerateMealPlan(hpMeal));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n All Generated Meal Plans:");
        for (MealPlan plan : userMealPlans.getAllPlans()) {
            System.out.println(plan);
        }
    }
}
