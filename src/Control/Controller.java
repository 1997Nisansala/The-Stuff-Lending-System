package Control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import View.*;
import Model.*;

public class Controller {
    private Member member;
    private Item item;
    private Contract contract;
    String id;
    private View view;
    private List<Member> listOfMember = new ArrayList<Member>();
    private List<Item> listOfItems = new ArrayList<>();
    private List<Contract> lendstuff = new ArrayList<>();

    public Controller(View view) {
        this.view = view;
    }

    public void start() {
        view.initial();
        while (true) {
            int choice = view.mainMenu();
            switch (choice) {
                case 1:
                    int choice1 = view.menu1();
                    switch (choice1) {
                        case 1:
                            addMember();
                            break;

                        case 2:
                            showAllMember();
                            break;

                        case 3:
                            removeMember();
                            break;

                        case 4:
                            updateMember();
                            break;

                        case 5:
                            getMember();
                            break;

                        case 6:
                            System.exit(0);

                        default:
                            view.warning3();
                    }
                    break;
                case 2:
                    int choice2 = view.menu2();
                    switch (choice2) {
                        case 1:
                            addItem();
                            break;

                        case 2:
                            showAllItem();
                            break;

                        case 3:
                            removeItem();
                            break;

                        case 4:
                            updateItem();
                            break;

                        case 5:
                            lendstuff();
                            break;

                        case 6:
                            showAllContracts();
                            break;

                        case 7:
                            System.exit(0);

                        default:
                            view.warning3();
                    }
                    break;
                case 3:
                    System.exit(0);

            }
        }
    }

    //Related Items
    private void showAllContracts() {
        view.showAllContract(lendstuff);
    }

    private void lendstuff() {
        boolean set = false;
        boolean timeValidity = true;
        int end_date = 0;
        contract = view.lendStuff();
        id = contract.getItemId();
        Iterator<Contract> ls = this.lendstuff.iterator();
        while (ls.hasNext()) {
            Contract ln = ls.next();
            if (ln.getItemId().equals(contract.getItemId())) {
                end_date = ln.getEndDate();
            }
        }
        if (end_date > 0) {
            if (end_date > contract.getStartDate()) {
                timeValidity = false;
            } else {
                timeValidity = true;
            }
        }

        int numberOfDays = contract.getEndDate() - contract.getStartDate();
        Iterator<Item> i = this.listOfItems.iterator();
        while (i.hasNext()) {
            Item e = i.next();
            if (e.getId().equals(id)) {
                int cost = (int) (e.getCostperday() * numberOfDays);
                Iterator<Member> in2 = this.listOfMember.iterator();
                while (in2.hasNext()) {
                    Member en2 = in2.next();
                    if (en2.getId().equals(contract.getborrowerId())) {
                        if ((en2.getCurrentCredit() - cost > 0) && timeValidity) {
                            en2.setCurrentCredit(-cost);
                            this.lendstuff.add(contract);
                            view.lend();
                            set = true;
                        } else if (!timeValidity) {
                            view.warning5();
                        } else {
                            view.warning6();
                            set = false;
                        }

                    }
                }
                Iterator<Member> in = listOfMember.iterator();
                while (in.hasNext()) {
                    Member en = in.next();
                    if (en.getId().equals(e.getOwnerID())) {
                        if (set) {
                            en.setCurrentCredit(cost);
                        }
                    }
                }

            }
        }

    }

    private void updateItem() {
        boolean found = false;
        ListIterator<Item> li = listOfItems.listIterator();
        id = view.getItemID();
        while (li.hasNext()) {
            Item e = li.next();
            if (e.getId().equals(id)) {
                item = view.updateItem();

                li.set(item);
                found = true;
            }
            if (!found) {
                view.warning1();
            } else {
                view.warning2();
            }
        }
    }

    private void removeItem() {
        boolean found = false;
        Iterator<Item> i = this.listOfItems.iterator();
        id = view.getItemID();
        while (i.hasNext()) {
            Item e = i.next();
            if (e.getId().equals(id)) {
                String ownerid = e.getOwnerID();
                i.remove();
                found = true;
                Iterator<Member> in = listOfMember.iterator();
                while (in.hasNext()) {
                    Member e1 = in.next();
                    if (e1.getId().equals(ownerid)) {
                        e1.setCurrentCredit(-100);
                        e1.setnumberofowned(-1);
                        e1.removeItem(e.getName());
                    }
                }
            }
        }
        Iterator<Contract> ci = lendstuff.iterator();
        while (ci.hasNext()) {
            Contract c = ci.next();
            if (c.getItemId().equals(id)) {
                c.setStatus(false);
            }
        }
        if (!found) {
            view.warning1();
        } else {
            view.warning4();
        }
    }

    private void showAllItem() {
        view.showAllItem(this.listOfItems);
    }

    private void addItem() {
        item = view.addItem();
        this.listOfItems.add(item);
        id = item.getOwnerID();
        Iterator<Member> i = this.listOfMember.iterator();
        while (i.hasNext()) {
            Member e = i.next();
            if (e.getId().equals(id)) {
                e.setCurrentCredit(100);
                e.setnumberofowned(1);
                e.setItems(item.getName());
            }
        }
    }


    // Related members
    private void getMember() {
        id = view.getMemberID();
        boolean found = false;
        Iterator<Member> i = this.listOfMember.iterator();
        while (i.hasNext()) {
            Member e = i.next();
            if (e.getId().equals(id)) {
                found = true;
                view.getMember();
                System.out.println(
                        e.getId() + "\t\t" + e.getName() + "\t\t" + e.getEmail() + "\t" + e.getMobile() + "\t\t"
                                + e.getCurrentCredit() + "\t\t" + e.getNumberofowned() + "\t" + e.getItems());
            }
        }
        if (!found) {
            view.warning1();
        }
    }

    private void updateMember() {
        boolean found = false;
        ListIterator<Member> li = this.listOfMember.listIterator();
        id = view.getMemberID();
        while (li.hasNext()) {
            Member e = li.next();
            if (e.getId().equals(id)) {
                member = view.updateMember();
                li.set(member);
                found = true;
            }
            if (!found) {
                view.warning1();
            } else {
                view.warning2();
            }
        }
    }

    private void removeMember() {
        boolean found = false;
        Iterator<Member> i = this.listOfMember.iterator();
        id = view.getMemberID();
        while (i.hasNext()) {
            Member e = i.next();
            if (e.getId().equals(id)) {
                i.remove();
                found = true;
            }
        }
        if (!found) {
            view.warning1();
        } else {
            view.warning4();
        }
    }

    public void addMember() {
        member = view.addMember();

        if (this.listOfMember.isEmpty()) {
            this.listOfMember.add(member);
        } else {
            ArrayList<Member> listOfMember2 = new ArrayList<Member>();
            listOfMember2 = (ArrayList<Member>) ((ArrayList) this.listOfMember).clone();

            Iterator<Member> i = listOfMember2.iterator();
            while (i.hasNext()) {
                Member e = i.next();
                if (e.getEmail().equals(member.getEmail()) | (e.getMobile() == (member.getMobile()))) {
                    view.unique();
                    return;
                } else {
                    this.listOfMember.add(member);
                }
            }
        }
    }

    private void showAllMember() {
        view.showAllMember(this.listOfMember);
    }

}
