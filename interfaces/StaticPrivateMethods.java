package interfaces;

public interface StaticPrivateMethods {
    void method1(); // == public abstract void method1()
    public default void defaultmethod() {
        publicStaticMethod();
        privateMethod();
        privateStaticMethod();
    }

    static void publicStaticMethod() {
        // static methods can call only static data members
        privateStaticMethod();
    }

    private void privateMethod() {
        System.out.println("I am a private method");}

    private static void privateStaticMethod() { System.out.println("I am a private Static method");}
}

