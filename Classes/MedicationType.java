package Classes;

public enum MedicationType {
    TABLET("Tablet", "Oral", 30),
    SYRUP("Syrup", "Oral", 15),
    INJECTION("Injection", "Injectable", 5),
    CREAM("Cream", "Topical", 10);

    private final String name;
    private final String route;
    private final int shelfLifeDays;

    MedicationType(String name, String route, int shelfLifeDays) {
        this.name = name;
        this.route = route;
        this.shelfLifeDays = shelfLifeDays;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public int getShelfLifeDays() {
        return shelfLifeDays;
    }

    // Method to check if medication is valid
    public boolean isValid(int daysPassed) {
        return daysPassed <= shelfLifeDays;
    }

    @Override
    public String toString() {
        return name + " (" + route + "), Shelf Life: " + shelfLifeDays + " days";
    }
}
