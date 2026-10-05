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

        for (PurchaseItem itemname : sampleItems)
        {
            log.addItem(itemname);
        }

        System.out.println("Purchase Log loaded with " + log.itemCount() + " items.");

        // Example test call — findItemByName. Do the same for every other required method.
        PurchaseItem found = log.findItemByName("Coffee");
        System.out.println("Looked up 'Coffee', found: " +
            (found != null ? found.getName() + " $" + found.getPrice() : "NOT FOUND"));

        // TODO: test updatePrice() — update a price, then look it up again and print the new value.
        found = log.findItemByName("bread");
        System.out.print("The price of 'Bread' has been updated from $" + found.getPrice() + " to $");
        log.updatePrice(found.getName(), 1.65);
        found = log.findItemByName("bread");
        System.out.println(found.getPrice());

        // TODO: test printDailyReport() — call it and confirm the totals look correct against sampleItems.
        log.printDailyReport();

        System.out.println("---TEST START!---");
        System.out.println(System.nanoTime());
        for (int i = 0; i < 1000; i++)
        {
            found = log.findItemByName("bread");
        }
        System.nanoTime();
        System.out.println(System.nanoTime());
        System.out.println("---TEST END!---");



        // ---- Sample data to load into the Checkout Line ----
        Customer[] sampleCustomers = {
            new Customer("Alvarez", 12),
            new Customer("Chen", 3),
            new Customer("Patel", 27),
            new Customer("O'Brien", 1)
        };

        CheckoutLine line = new CheckoutLine();

        // TODO: write a loop that adds every customer in sampleCustomers to line using addToBack().
        for (Customer customer : sampleCustomers)
        {
            line.addToBack(customer);
        }

        System.out.println("Checkout Line loaded, size p = " + line.size());

        // Example test call — addToFront (O'Brien has 1 item, gets waved to the front).
        Customer express = new Customer("Nguyen", 1);
        System.out.println("Waving " + express.getName() + " to the front...");
        line.addToFront(express);

        // TODO: test removeFromFront() — remove and print who gets served first. Should it be Nguyen?
        System.out.print(line.getFirst().getName() + " has been removed from the front. ");
        line.removeFromFront();
        System.out.println(line.getFirst().getName() + " is up next!");

        // TODO: test removeFromBack() — remove and print who leaves from the back of the line.
        System.out.println(line.getlast().getName() + " has left the back of the line.");
        line.removeFromBack();

        // TODO: after your test calls above, print line.size() again and confirm it changed correctly.
        System.out.println("There are currently " + line.size() + " customers currently the line.");


        System.out.println("---TEST START!---");
        System.out.println(System.nanoTime());
        for (int i = 0; i < 1000; i++)
        {
            line.addToFront(express);
        }
        System.nanoTime();
        System.out.println(System.nanoTime());
        System.out.println("---TEST END!---");
    }
}