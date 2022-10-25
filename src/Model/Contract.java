package Model;

public class Contract {
    private int startDate;
    private int endDate;
    private String itemId;
    private String borrowerID;
    private boolean status;

    public Contract(String itemId, int date1, int date2, String borrowerID) {
        this.itemId = itemId;
        this.endDate = date1;
        this.startDate = date2;
        this.borrowerID = borrowerID;
        this.status = true;
    }

    public String getItemId() {
        return itemId;
    }

    public boolean getStatus() {
        return status;
    }

    public int getEndDate() {
        return endDate;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getborrowerId() {
        return borrowerID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
