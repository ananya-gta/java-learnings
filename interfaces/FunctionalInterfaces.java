package interfaces;

@FunctionalInterface
public interface FunctionalInterfaces {
    // only 1 astract method
    void abstractMethod();

    // can have other default, static methods also
    default void defaultMethod(){};
    static void publicstaticMethod() {};

    // can use object class method
    String toString();
}
