package Model;

public class Item {
    private String id;
    private String name;
    private String ownerID;
    private String description;
    private String category;
    private int dayCreation;
    private int costperday;

    RandomAlphanumeric ran = new RandomAlphanumeric();

    public Item(String name, String ownerID, String description, String category, int costperday) {
        this.id = ran.generateRandomAlphanumeric(3);
        this.name = name;
        this.ownerID = ownerID;
        this.description = description;
        this.category = category;
        this.dayCreation = 0;
        this.costperday = costperday;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public String getDescription() {
        return description;
    }

    public String getcategory() {
        return category;
    }

    public int getDayCreation() {
        return dayCreation;
    }

    public String getEmail() {
        return null;
    }

    public int getCostperday() {
        return costperday;
    }

}
