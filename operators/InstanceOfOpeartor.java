package operators;

class Parent {}
class Child1 extends Parent {}
class Child2 extends Parent{}

public class InstanceOfOpeartor {
    public static void main(String[] args) {
        Parent obj = new Child1();
        System.out.println(obj instanceof Child1); // true
        System.out.println(obj instanceof Child2); // false

        Child1 obj1 = new Child1();
        System.out.println(obj1 instanceof Parent); // true

        String val = "hello";
        System.out.println(val instanceof String); // true

        Object unkownObject = new Parent();
        System.out.println(unkownObject instanceof Child2); // false

        
    }
}
