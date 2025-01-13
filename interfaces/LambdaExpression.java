package interfaces;

@FunctionalInterface
interface MyInterface {
    void myMethod();
    // void parametrisedMethod(String val);
}

public class LambdaExpression {
    public static void main(String[] args) {
        MyInterface obj = () -> System.out.println("Hello, Lambda");
        // MyInterface obj = (String val) -> System.out.println(val);
        obj.myMethod();
        // obj.parametrisedMethod(val);
    }
}
