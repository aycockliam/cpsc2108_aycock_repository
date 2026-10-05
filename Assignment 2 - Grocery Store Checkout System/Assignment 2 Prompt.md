Assignment: Grocery Store Checkout System
## Overview

You will build a small Java program that models two parts of a grocery store's daily operation. These systems standalone from each other but later can be connected. Each part behaves differently, and part of your grade depends on choosing the List structure whose performance characteristics actually match how each part is used. You will implement both parts, write code that demonstrates each required behavior, measure how your choices perform, and justify your decisions in writing using Big-O notation.

This assignment does not tell you which structure to use where. Read each component's behavior description carefully and then choose what works best based on its characteristics. 
## Learning Objectives

    Implement and use the core operations of both ArrayList and LinkedList in a single program.
    Analyze a component's real usage pattern and select the data structure whose performance profile fits it.
    Express the time complexity of specific operations, in your own code, using Big-O notation.
    Support a design decision with measured evidence, not just theory.

## The Scenario

You are building the backend for a grocery store's checkout system. It has two components. Read each description below and decide what best fits.
Component A — Purchase Log

The store keeps a running record of every item scanned at checkout throughout the day. Cashiers scan items continuously, and each scanned item is added to this record. Once an item is added, it stays in the record permanently, nothing is ever removed from it during normal operation. Meanwhile, this record is read constantly: it's used to look up an item's price by name, to recalculate running totals, and, at the end of the day, to loop through every entry to generate a report (total items sold, total revenue, which item sold the most). Reading and scanning through this record happens far more often than adding to it.
Component B — Checkout Line

Customers join the checkout line at the back as they arrive. The cashier serves whoever is at the front of the line and removes them once their checkout is complete. Occasionally, an employee will wave a customer with only one or two items to the very front of the line ahead of everyone else. The program never needs to search the line for a specific customer, and it never loops through the whole line to generate a report, it only ever adds or removes someone at the very front or the very back.
Your task: implement both components, each backed by either java.util.ArrayList or java.util.LinkedList. You must use each structure at least once — one component should use ArrayList, and the other should use LinkedList. You decide which goes where based on the behavior described above.
### Part 1 — Required Operations

Each component must support the following behaviors, regardless of which structure backs it:
Purchase Log (Component A) 	Checkout Line (Component B)
Add a newly scanned item to the log 	Add a customer to the back of the line
Find an item by name and return it 	Add a customer to the front of the line (express override)
Update the price of an existing item by name 	Remove and return the customer at the front (serve them)
Loop through every item to print a daily report (item count, total revenue, best seller) 	Remove and return the customer at the back (they leave the line)
Report how many items have been scanned 	Report how many customers are currently in line

### Part 2 — Minimal Starter Code

The starter code below gives you the two supporting record classes and empty method signatures for each component. You decide what field backs each class, and you implement every method body. I have also attached these documents individually to the assignment.

PurchaseItem.java
```java
public class PurchaseItem {
    private String name;
    private double price;

    public PurchaseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
```

Customer.java
```java
public class Customer {
    private String name;
    private int itemCount;

    public Customer(String name, int itemCount) {
        this.name = name;
        this.itemCount = itemCount;
    }

    public String getName() { return name; }
    public int getItemCount() { return itemCount; }
}
```

PurchaseLog.java
```java
public class PurchaseLog {

    // TODO: declare the field that stores your PurchaseItem records.
    // Decide: ArrayList<PurchaseItem> or LinkedList<PurchaseItem>?

    public void addItem(PurchaseItem item) {
        // TODO
    }

    public PurchaseItem findItemByName(String name) {
        // TODO
        return null;
    }

    public void updatePrice(String name, double newPrice) {
        // TODO
    }

    public void printDailyReport() {
        // TODO: loop through every item — total count, total revenue, best seller
    }

    public int itemCount() {
        // TODO
        return 0;
    }
}
```

CheckoutLine.java
```java
public class CheckoutLine {

    // TODO: declare the field that stores your Customer records.
    // Decide: ArrayList<Customer> or LinkedList<Customer>?

    public void addToBack(Customer c) {
        // TODO
    }

    public void addToFront(Customer c) {
        // TODO
    }

    public Customer removeFromFront() {
        // TODO
        return null;
    }

    public Customer removeFromBack() {
        // TODO
        return null;
    }

    public int size() {
        // TODO
        return 0;
    }
}
```

You may add helper methods, but the five methods listed for each class above must exist with these signatures.
Main.java — Required Testing Driver

You must also write a Main class that exercises every required method on both PurchaseLog and CheckoutLine, and prints output that lets someone reading the console confirm each method worked correctly (e.g., print the object returned by findItemByName, print the line size before and after a removal, etc.). A method you never call from Main is a method you haven't demonstrated.

The starter below gives you a sample array of items and customers to load in, and a couple of example test calls to show the pattern. You need to write the loop that loads each array into its component using the appropriate add method — the starter marks where each loop goes but does not write it for you. Everything after the "load" section is also left for you to fill in — every required method needs its own test call and printed confirmation.
Main.java
```java
public class Main {
    public static void main(String[] args) {

        // ---- Sample data to load into the Purchase Log ----
        PurchaseItem[] sampleItems = {
            new PurchaseItem("Bread", 3.49),
            new PurchaseItem("Milk", 2.99),
            new PurchaseItem("Eggs", 4.29),
            new PurchaseItem("Coffee", 8.99),
            new PurchaseItem("Bananas", 1.29),
            new PurchaseItem("Cereal", 4.79),
            new PurchaseItem("Chicken Breast", 9.99),
            new PurchaseItem("Paper Towels", 6.49)
        };

        PurchaseLog log = new PurchaseLog();

        // TODO: write a loop that adds every item in sampleItems to log using addItem().

        System.out.println("Purchase Log loaded with " + log.itemCount() + " items.");

        // Example test call — findItemByName. Do the same for every other required method.
        PurchaseItem found = log.findItemByName("Coffee");
        System.out.println("Looked up 'Coffee', found: " +
            (found != null ? found.getName() + " $" + found.getPrice() : "NOT FOUND"));

        // TODO: test updatePrice() — update a price, then look it up again and print the new value.

        // TODO: test printDailyReport() — call it and confirm the totals look correct against sampleItems.


        // ---- Sample data to load into the Checkout Line ----
        Customer[] sampleCustomers = {
            new Customer("Alvarez", 12),
            new Customer("Chen", 3),
            new Customer("Patel", 27),
            new Customer("O'Brien", 1)
        };

        CheckoutLine line = new CheckoutLine();

        // TODO: write a loop that adds every customer in sampleCustomers to line using addToBack().

        System.out.println("Checkout Line loaded, size = " + line.size());

        // Example test call — addToFront (O'Brien has 1 item, gets waved to the front).
        Customer express = new Customer("Nguyen", 1);
        System.out.println("Waving " + express.getName() + " to the front...");
        line.addToFront(express);

        // TODO: test removeFromFront() — remove and print who gets served first. Should it be Nguyen?

        // TODO: test removeFromBack() — remove and print who leaves from the back of the line.

        // TODO: after your test calls above, print line.size() again and confirm it changed correctly.
    }
}
```

Part 3 — Performance Comparison

For each component, build a second version backed by the other structure (i.e., if you chose ArrayList for the Purchase Log, also build a LinkedList version of it — it does not need to be polished, just functional). Then:

    Run the same workload against both versions of that component — for the Purchase Log, this means performing 1,000 findItemByName lookups after populating it; for the Checkout Line, this means performing 1,000 addToFront calls.
    Measure and record either the elapsed time (System.nanoTime()) or a manual operation/shift counter for both versions.
    Report the numbers for both versions of both components in a short table in your write-up.

Part 4 — Written Justification

Submit a written response (roughly one page) that addresses the following for each component:

    Which structure you chose (ArrayList or LinkedList).
    The specific operations your program actually performs on that component (not a generic list from the textbook), with the Big-O of each operation for the structure you chose.
    What the Big-O of those same operations would have been if you had used the other structure instead, and how much worse (or not) that would have been in practice.
    A sentence connecting your choice back to the behavior description — why the access pattern described for that component makes your structure the better fit.
    Whether your Part 3 measurements matched your Big-O prediction. If they didn't, explain why.

Generic statements ("ArrayList is fast" / "LinkedList is good for insertion") without a Big-O value tied to a specific operation in your code will not receive credit for that item.
Submission Requirements

    All code submitted in a .zip file to CougarView
    Include both structure versions used for Part 3 in the repository.
    Submit your written justification (Part 4) as a PDF or Word document alongside your repository link.