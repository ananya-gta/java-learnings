package interfaces;

interface LivingThing {
    default void eat(String bird) {
        System.out.println(bird + " eat");
    }
}

// cascading is done to call default method without error
interface Bird extends LivingThing {
    // by default this is an abstract method
    public void fly();

    // default method --> used bcz classes which implemennts interfaces compulsorily
    // have to implement the method's logic, but they have same code functionality
    // in all the classes, to prevent this default method is introduced since java8
    // default void eat(String bird) {
    //     System.out.println(bird + " eat");
    // }
}

class Eagle implements Bird {

    @Override
    public void fly() {
        System.out.println("Eagle flies");
    }

}

class Crow implements Bird {

    @Override
    public void fly() {
        System.out.println("Crow flies");
    }

}

public class DefaultMethod {
    public static void main(String[] args) {
        // interfaces cannot be instantiated, but can hold references of the instances
        // of classes which implements it
        Bird eagleObj = new Eagle();
        Bird crowObj = new Crow();
        eagleObj.fly();
        crowObj.fly();
        // both classes can call default method
        eagleObj.eat("Eagle");
        crowObj.eat("Crow");
    }
}
