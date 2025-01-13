package interfaces;

// accepts one parameter and returns result
@FunctionalInterface
interface Function<T, R> {
    R apply(T t);
}

public class FunctionInterface {
    public static void main(String[] args) {
        Function<Integer, String> obj = (Integer x) -> {
            if (x > 10)
                return "Fnction Interface accepts one value and returns result";
                            return "retrn type is string";
        };
        System.out.println(obj.apply(11));
    }
}
