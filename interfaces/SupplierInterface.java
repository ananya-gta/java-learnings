package interfaces;

@FunctionalInterface
// accepts no parameter and returns result
interface Supplier<T> {
    T get();
}

public class SupplierInterface {
    public static void main(String[] args) {
        Supplier<String> obj = () -> "Supplier Interface accepts no value and returns result";
        System.out.println(obj.get());
    }
}
