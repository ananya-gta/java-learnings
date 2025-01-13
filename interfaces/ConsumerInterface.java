package interfaces;

@FunctionalInterface
// accepts one parameter and returns no result
interface Consumer<T> {
    void accept(T t);
}

public class ConsumerInterface {
    public static void main(String[] args) {
        Consumer<Integer> obj = (x) -> {
            if (x > 10)
                System.out.println("Consumer Interface accepts geneic value: " + x);
        };
        obj.accept(11);
    }
}
