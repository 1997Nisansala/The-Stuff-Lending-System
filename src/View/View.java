package View;
import Model.Contract;
import Model.Item;
import Model.Member;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner sc,sc1;

    public View(){
        this.sc = new Scanner(System.in);
        this.sc1 = new Scanner(System.in);
    }

    public void initial(){
        System.out.println("-------------------------");
        System.out.println("The Stuff Lending System");
        System.out.println("-------------------------");
    }

    public int mainMenu(){
        System.out.println("---------------------");
        System.out.println("Enter you choice ");
        System.out.println("1.Member");
        System.out.println("2.Item");
        System.out.println("3.Exit");
        System.out.println("---------------------");
        int choice = sc.nextInt();
        return choice;
    }

    public int menu1(){
        System.out.println("---------------------");
        System.out.println("Enter you choice ");
        System.out.println("1.Add member");
        System.out.println("2.Show all members");
        System.out.println("3.Remove a member");
        System.out.println("4.Update member");
        System.out.println("5.Search a member");
        System.out.println("6.Exit");
        System.out.println("---------------------");
        int choice = sc.nextInt();
        return choice;
    }

    public int menu2(){
        System.out.println("---------------------");
        System.out.println("Enter you choice ");
        System.out.println("1.Add item");
        System.out.println("2.Show all items");
        System.out.println("3.Remove a item");
        System.out.println("4.Update item");
        System.out.println("5.lend an item");
        System.out.println("6.Show all contracts");
        System.out.println("7.Exit");
        System.out.println("---------------------");
        int choice = sc.nextInt();
        return choice;
    }

    public int menu3(){
        System.out.println("1.Tool");
        System.out.println("2.Vehicle");
        System.out.println("3.Game");
        System.out.println("4.Toy");
        System.out.println("5.Sport");
        System.out.println("6.Other");
        int choice = sc.nextInt();
        return choice;
    }

    public Contract lendStuff() {
        System.out.println("---------------------");
        System.out.print("Enter the Item ID : ");
        String itemId = sc1.nextLine();
        System.out.print("Enter your member ID : ");
        String memberId = sc1.nextLine();
        System.out.print("Enter the return date : ");
        int date1 = sc.nextInt();
        System.out.print("Enter the start date : ");
        int date2 = sc.nextInt();
        Contract cq = new Contract(itemId, date1, date2, memberId);
        return cq;
    }
    //Related to Member
    public void showAllMember(List<Member> listOfMember) {
        Iterator<Member> i = listOfMember.iterator();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("MemberID\tMembername\tEmail\t\tMobileNo\tCurrentCredit\tNumber_of_Owned_Items\towned_items");
        while (i.hasNext()) {
            Member e = i.next();
            System.out.println(e.getId() + "\t\t" + e.getName() + "\t\t" + e.getEmail() + "\t" + e.getMobile() + "\t\t"
                    + e.getCurrentCredit() + "\t\t" + e.getNumberofowned() + "\t" + e.getItems());
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public String getMemberID(){
        System.out.print("Enter Member ID : ");
        String id = sc1.nextLine();
        return id;
    }

    public Member addMember(){
        System.out.print("Enter the member Name : ");
        String name = sc1.nextLine();
        System.out.print("Enter email : ");
        String email = sc1.nextLine();
        System.out.print("Enter mobile No : ");
        int mobile = sc.nextInt();

        Member p = new Member(name, email, mobile);
        return p;
    }

    public Member updateMember(){
        System.out.print("Enter new name : ");
        String ename = sc1.nextLine();

        System.out.print("Enter new email : ");
        String mail = sc1.nextLine();

        System.out.print("Enter new mobile no : ");
        int mobno = sc.nextInt();

        Member m = new Member(ename, mail, mobno);
        return m;
    }

    public void getMember(){
        System.out.println("MemberID\tMembername\tEmail\t\tMobileNo\tCurrentCredit\tNumber_of_Owned_Items\towned_items");
    }

    //Related to Contracts
    public void showAllContract(List<Contract> lendstuff){
        System.out.println("-----------------------");
        Iterator<Contract> i = lendstuff.iterator();
        System.out.println("ItemID\tstart_date\tend_date\tborrower_iD\tActive_order");
        while (i.hasNext()) {
            Contract e = i.next();
            System.out.println(e.getItemId() + "\t" + e.getStartDate() + "\t" + e.getEndDate() + "\t"
                    + e.getborrowerId() + "\t" + e.getStatus());
        }
        System.out.println("-----------------------");
    }

    //Related to Item
    public String getItemID() {
        System.out.print("Enter Item ID : ");
        String id = sc1.nextLine();
        return id;
    }

    public Item addItem() {
        System.out.print("Enter the Item Name : ");
        String name = sc1.nextLine();
        System.out.println("Enter the category : ");
        int ch = menu3();
        String cat;
        if(ch==1){
            cat = "Tool";
        }
        else if(ch==2){
            cat = "Vehicle";
        }
        else if(ch==3){
            cat = "Game";
        }
        else if(ch==4){
            cat = "Toy";
        }
        else if(ch==5){
            cat = "Sport";
        }
        else{
            cat = "Other";
        }
        System.out.print("Enter the description : ");
        String des = sc1.nextLine();
        System.out.print("Enter the member ID : ");
        String ownerid = sc1.nextLine();
        System.out.print("Enter the cost per day : ");
        int costperday = sc.nextInt();

        Item p = new Item(name,ownerid, des,cat ,costperday);
        return p;
    }

    public void showAllItem(List<Item> listOfItems){
        System.out.println("--------------------------------------------------------------");
        Iterator<Item> i = listOfItems.iterator();
        System.out.println("ItemID\tOwnerID\tItem_Name\tDescription\tCreated_Day\tCategory");
        while (i.hasNext()) {
            Item e = i.next();
            System.out
                    .println(e.getId() + "\t" + e.getOwnerID() + "\t" + e.getName() + "\t\t" + e.getDescription() + "\t"
                            + e.getDayCreation() + "\t\t" + e.getcategory());
        }
        System.out.println("---------------------------------------------------------------");
    }

    public Item updateItem(){
        System.out.print("Enter new Item name : ");
        String iname = sc1.nextLine();

        System.out.println("Enter the new category : ");
        int ch = menu3();
        String cat;
        if(ch==1){
            cat = "Tool";
        }
        else if(ch==2){
            cat = "Vehicle";
        }
        else if(ch==3){
            cat = "Game";
        }
        else if(ch==4){
            cat = "Toy";
        }
        else if(ch==5){
            cat = "Sport";
        }
        else{
            cat = "Other";
        }

        System.out.print("Enter new description : ");
        String ides = sc1.nextLine();

        System.out.print("Enter new member ID : ");
        String memid = sc1.nextLine();

        System.out.print("Enter the cost per day : ");
        int cost = sc.nextInt();

        Item p = new Item(iname, memid, ides, cat, cost);
        return p;
    }

    public void showAllContracts(){
        System.out.println("ItemID\tstart_date\tend_date\t\t\t2borrower_iD\tActive_order");
    }

    //Related to Error Messages
    public void unique(){
        System.out.println("--------------------------------------------");
        System.out.println("The Email and Mobile number should be unique");
    }

    public void warning1(){
        System.out.println("Record not found");
    }

    public void warning2(){
        System.out.println("Record is updated successfully");
    }

    public void warning3(){
        System.out.println("Enter a valid choice");
    }

    public void warning4(){
        System.out.println("Record is deleted successfully");
    }

    public void warning5(){
        System.out.println("Time Conflict happened.");
    }

    public void warning6(){
        System.out.println("The current credit value is not sufficient");
    }

    public void lend(){
        System.out.println("The item is lent successfully");
    }

}
