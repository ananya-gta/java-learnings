package collections;
import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {
        // Create a Collection using an ArrayList (implements Collection)
        Collection<String> collection = new ArrayList<>();

        // 1. add(E element)
        collection.add("Apple");
        collection.add("Banana");
        collection.add("Orange");
        System.out.println("Collection after adding elements: " + collection);

        // 2. size()
        System.out.println("Size of the collection: " + collection.size());

        // 3. isEmpty()
        System.out.println("Is the collection empty? " + collection.isEmpty());

        // 4. contains(Object o)
        System.out.println("Does the collection contain 'Banana'? " + collection.contains("Banana"));
        System.out.println("Does the collection contain 'Mango'? " + collection.contains("Mango"));

        // 5. iterator()
        System.out.println("Using iterator to iterate through the collection:");
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 6. toArray()
        Object[] array = collection.toArray();
        System.out.println("Array representation of the collection: " + Arrays.toString(array));

        // 7. remove(Object o)
        collection.remove("Banana");
        System.out.println("Collection after removing 'Banana': " + collection);

        // 8. clear()
        collection.clear();
        System.out.println("Collection after clear(): " + collection);

        // 9. addAll(Collection<? extends E> c)
        Collection<String> anotherCollection = new ArrayList<>();
        anotherCollection.add("Pineapple");
        anotherCollection.add("Grapes");
        collection.addAll(anotherCollection);
        System.out.println("Collection after addAll() from another collection: " + collection);

        // 10. containsAll(Collection<?> c)
        Collection<String> checkCollection = new ArrayList<>();
        checkCollection.add("Pineapple");
        checkCollection.add("Grapes");
        System.out.println("Does the collection contain all elements from checkCollection? "
                + collection.containsAll(checkCollection));

        // 11. removeAll(Collection<?> c)
        collection.removeAll(checkCollection);
        System.out.println("Collection after removeAll() operation: " + collection);

        // 12. retainAll(Collection<?> c)
        collection.add("Pineapple");
        collection.add("Grapes");
        collection.retainAll(checkCollection);
        System.out.println("Collection after retainAll() operation: " + collection);

        // 13. equals(Object o)
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("Pineapple");
        collection2.add("Grapes");
        System.out.println("Is the collection equal to collection2? " + collection.equals(collection2));

        // 14. hashCode()
        System.out.println("HashCode of the collection: " + collection.hashCode());
    }
}
