package collections;
import java.util.*;
public class Iterator1 {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        // Get the iterator
        Iterator<String> it = list.iterator();

        // Print the elements of the list
        while (it.hasNext()) { // Check if there is a next element
            System.out.println(it.next()); // Get the next element
        }
        it.remove(); // Remove the last element returned by the iterator

        // Print the list using for each loop
        for (String val : list) {
            System.out.println(val);
        }

        // using forEach method of Iterable with lambda expression
        list.forEach(val -> System.out.println(val));
        
        
        
    }
}
