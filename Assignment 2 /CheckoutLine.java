
import java.util.LinkedList;

public class CheckoutLine {

    // TODO: declare the field that stores your Customer records.
    // Decide: ArrayList<Customer> or LinkedList<Customer>?
    LinkedList<Customer> line = new LinkedList<Customer>();
    public Customer getFirst(){
        return line.getFirst();
    }

    public Customer getlast(){
        return line.getLast();
    } 
    public void addToBack(Customer c) {
        line.addLast(c);
    }

    public void addToFront(Customer c) {
        line.addFirst(c);
    }

    public Customer removeFromFront() {
        line.removeFirst();
        return line.getFirst();
    }

    public Customer removeFromBack() {
        line.removeLast();
        return line.getLast();
    }

    public int size() {
        return line.size();
    }
}

/*
import java.util.ArrayList;

public class CheckoutLine {

    // TODO: declare the field that stores your Customer records.
    // Decide: ArrayList<Customer> or LinkedList<Customer>?
    ArrayList<Customer> line = new ArrayList<Customer>();
    public Customer getFirst(){
        return line.get(0);
    }

    public Customer getlast(){
        return line.get(line.size() - 1);
    } 
    public void addToBack(Customer c) {
        line.add(c);
    }

    public void addToFront(Customer c) {
        ArrayList<Customer> interimLine = new ArrayList<Customer>();
        interimLine.add(c);
        interimLine.addAll(line);
        line.removeAll(line);
        line.addAll(interimLine);
    }

    public Customer removeFromFront() {
        line.remove(0);
        return line.get(0);
    }

    public Customer removeFromBack() {
        line.remove(line.size() - 1);
        return line.get(line.size() - 1);
    }

    public int size() {
        return line.size();
    }
}
*/