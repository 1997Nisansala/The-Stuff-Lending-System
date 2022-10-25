package Model;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String email;
    private int mobileno;
    private String id;
    private float currentCredit;
    private int numberofowneditems;
    private List<String> items;

    RandomAlphanumeric ran = new RandomAlphanumeric();

    public Member(String name, String email, int mobileno) {
        this.id = ran.generateRandomAlphanumeric(6);
        this.name = name;
        this.email = email;
        this.mobileno = mobileno;
        this.currentCredit = (float) 0.0;
        this.numberofowneditems = 0;
        this.items = new ArrayList<String>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeItem(String name) {
        this.items.remove(name);
    }

    public String getEmail() {
        return email;
    }

    public int getNumberofowned() {
        return numberofowneditems;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobileno;
    }

    public void setMobile(int mobileno) {
        this.mobileno = mobileno;
    }

    public float getCurrentCredit() {
        return currentCredit;
    }

    public void setCurrentCredit(int credit) {
        this.currentCredit = this.currentCredit + credit;
    }

    public void setnumberofowned(int value) {
        this.numberofowneditems = this.numberofowneditems + value;
    }

    public void setItems(String item) {
        this.items.add(item);
    }
}
