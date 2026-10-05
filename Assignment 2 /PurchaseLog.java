
import java.util.ArrayList;

public class PurchaseLog {
    // TODO: declare the field that stores your PurchaseItem records.
    // Decide: ArrayList<PurchaseItem> or LinkedList<PurchaseItem>?
    // An ArrayList is created where every time an item is scanned it is added to the ArrayList.
    ArrayList<PurchaseItem> itemStore = new ArrayList<PurchaseItem>();

    public void addItem(PurchaseItem item) {
        // To add an item to the purchase log, we use the .add() method.
        itemStore.add(item);
    }

    public PurchaseItem findItemByName(String name) {
        // To determine if an item has been scanned we iterate through the ArrayList and compare the query to the queried ArrayList.
        // If the item is present, we return the item. If it is not found, we return null.
        for (int i = 0; i <= itemStore.size() - 1; i++)
        {
            if (itemStore.get(i).getName().equalsIgnoreCase(name))
            {
                return itemStore.get(i);
            }
        }
        return null;
    }

    public void updatePrice(String name, double newPrice) {
        // This method assumes that we are updating ALL the prices of a specific item.
        // This comes from the fact that if we want to update only one, then specification would need to be had which is outside the scope of this assignment.
        // This solution also works for items of only one type.
        int loop = 0;
        for (PurchaseItem itemName : itemStore)
        {
            if (name.equalsIgnoreCase(itemName.getName()))
            {
                itemStore.get(loop).setPrice(newPrice);
            }
        }
    }

    public void printDailyReport() {
        // TODO: loop through every item — total count, total revenue, best seller
        // To print a total count of items, we simply print the length of the ArrayList.
        // To print the total revenue, we need to init a new double to 0 and iterate through the list to get the sum.
        // To get the best seller, we need to make a new String ArrayList, add all the unique items to it, and then get a count of eac to determine the biggest.
        double totalRevenue = 0.00;
        int topSellerCount = 0;
        String topSellerName = "";

        ArrayList<String> uniqueItems = new ArrayList<String>();
        uniqueItems.add(itemStore.get(1).getName()); // Add the first item.

        for (int i = 0; i <= itemStore.size() - 1; i++)
        {
            totalRevenue = totalRevenue + itemStore.get(i).getPrice();
        }

        // To determine the top seller, we make a comparison variable that holds the count of a specific item.
        // We count the number of times the unique item is in the array list.
        // If the count of a specific item is larger than the current count then we change the maximum.
        int comparisonVariable;
        for (String uniqueItemName : uniqueItems)
        {
            comparisonVariable = 0;
            for (PurchaseItem itemStoreName : itemStore)
            {
                if (itemStoreName.getName().equals(uniqueItemName))
                {
                    comparisonVariable = comparisonVariable++;
                }
            }

            if (comparisonVariable > topSellerCount)
            {
                topSellerCount = comparisonVariable;
                topSellerName = uniqueItemName;
            }
            else
            {
                topSellerName = "N/A (There are no purchases of the same item.)";
            }
        }

        // Print out the respective values.
        System.out.println("Total Items: " + itemStore.size());
        System.out.println("Total Revenue: " + totalRevenue);
        System.out.println("Top Seller: " + topSellerName);
    }

    public int itemCount() {
        return itemStore.size();
    }
}


/*
import java.util.LinkedList;
import java.util.ArrayList;

public class PurchaseLog {
    // TODO: declare the field that stores your PurchaseItem records.
    // Decide: ArrayList<PurchaseItem> or LinkedList<PurchaseItem>?
    // An ArrayList is created where every time an item is scanned it is added to the ArrayList.
    LinkedList<PurchaseItem> itemStore = new LinkedList<PurchaseItem>();

    public void addItem(PurchaseItem item) {
        // To add an item to the purchase log, we use the .add() method.
        itemStore.addLast(item);
    }

    public PurchaseItem findItemByName(String name) {
        // To determine if an item has been scanned we iterate through the ArrayList and compare the query to the queried ArrayList.
        // If the item is present, we return the item. If it is not found, we return null.
        for (PurchaseItem itemName : itemStore)
        {
            if (itemName.getName().equalsIgnoreCase(name))
            {
                return itemName;
            }
        }
        return null;
    }

    public void updatePrice(String name, double newPrice) {
        // This method assumes that we are updating ALL the prices of a specific item.
        // This comes from the fact that if we want to update only one, then specification would need to be had which is outside the scope of this assignment.
        // This solution also works for items of only one type.
        int loop = 0;
        for (PurchaseItem itemName : itemStore)
        {
            if (name.equalsIgnoreCase(itemName.getName()))
            {
                itemStore.get(loop).setPrice(newPrice);
            }
        }
    }

    public void printDailyReport() {
        // TODO: loop through every item — total count, total revenue, best seller
        // To print a total count of items, we simply print the length of the ArrayList.
        // To print the total revenue, we need to init a new double to 0 and iterate through the list to get the sum.
        // To get the best seller, we need to make a new String ArrayList, add all the unique items to it, and then get a count of eac to determine the biggest.
        double totalRevenue = 0.00;
        int topSellerCount = 0;
        String topSellerName = "";

        ArrayList<String> uniqueItems = new ArrayList<String>();
        uniqueItems.add(itemStore.get(1).getName()); // Add the first item.

        for (int i = 0; i <= itemStore.size() - 1; i++)
        {
            totalRevenue = totalRevenue + itemStore.get(i).getPrice();
        }

        // To determine the top seller, we make a comparison variable that holds the count of a specific item.
        // We count the number of times the unique item is in the array list.
        // If the count of a specific item is larger than the current count then we change the maximum.
        int comparisonVariable;
        for (String uniqueItemName : uniqueItems)
        {
            comparisonVariable = 0;
            for (PurchaseItem itemStoreName : itemStore)
            {
                if (itemStoreName.getName().equals(uniqueItemName))
                {
                    comparisonVariable = comparisonVariable++;
                }
            }

            if (comparisonVariable > topSellerCount)
            {
                topSellerCount = comparisonVariable;
                topSellerName = uniqueItemName;
            }
            else
            {
                topSellerName = "N/A (There are no purchases of the same item.)";
            }
        }

        // Print out the respective values.
        System.out.println("Total Items: " + itemStore.size());
        System.out.println("Total Revenue: " + totalRevenue);
        System.out.println("Top Seller: " + topSellerName);
    }

    public int itemCount() {
        return itemStore.size();
    }
}
*/