public class Cereal {
    private String name;
    private char type;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int fiber;
    private int carbs;
    private int sugar;
    private int potassium;
    private int vitamins;
    private int shelf;
    private double weight;
    private double rating;

    public Cereal (String name, char type, int calories, int protein, int fat, int sodium, 
        int fiber, int carbs, int sugar, int potassium, int vitamins, int shelf, double weight, double rating) {
            name = this.name;
            type = this.type;
            calories = this.calories;
            protein = this.protein;
            fat = this.fat;
            sodium = this.sodium;
            fiber = this.fiber;
            carbs = this.carbs;
            sugar = this.sugar;
            potassium = this.potassium;
            vitamins = this.vitamins;
            shelf = this.shelf;
            weight = this.weight;
            rating = this.rating;

    }

    public String toString(){
        return ("Information for " + name + ":\n\tName: " + name + "\n\tType: " + type + "\n\tCalories: " + calories
            + "\n\tProtein: " + protein + "\n\tFat: " + fat + "\n\tSodium: " + sodium + "\n\tFiber: " + fiber
            + "\n\tCarbohydrates: " + carbs + "\n\tSugar: " + sugar + "\n\tPotassium: " + potassium + "\n\tVitamins: " 
            + vitamins + "\n\tShelf: " + shelf + "\n\tWeight: " + weight + "\n\tRating: " + rating);
    }


}