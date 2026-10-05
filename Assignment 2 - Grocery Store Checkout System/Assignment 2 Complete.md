## Part 1
 I chose Purchase Log to be an ArrayList & Checkout Line to be a LinkedList.
## part 2
Starter code is implemented!
## Part 3
Instead of creating new files, I commented out the first implementation of the componenets for simplicity. Complete!
	        Purchase Log	CheckoutLine
Array List	443774	        21042054
Linked List	633265	        136346

The numbers in the table are the differences in nano time. Notice that the checkoutline with an arraylist is VERY large! We have to shift down everyone each time we add a customer to the front!
## Part 4 - Written Justification
I chose an Arraylist for the PurchaseLog and a Linked List for the CheckoutLine. The reason for this is that the log requires a lot of iterating through which arrays are better suited for. They also have more information at one time and require a lot of accessing. The LinkedList on the checkout line fits better because if we want to add someone to the front it does not require shifting the entire list up an index.

My Purchase Log has an n^2 complexity, but my implementation requires comparing one list to another.

For the purchase log, it's n^2 regardless because my implementation requires comparing one list to another.

Arraylists are simpler for accessing because you do not need to reference **each** element by their memory location, just the index. It is faster and cleaner than a LinkedList because we are working with potentially thousands of items in the log. Each customer can bring in 100+ items if its a big day!

It does match my predictions.

