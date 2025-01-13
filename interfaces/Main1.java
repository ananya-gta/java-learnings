package interfaces;

interface Bird {
    public void fly();
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

public class Main1 {
    public static void main(String[] args) {
        // interfaces cannot be instantiated, but can hold references of the instances of classes which implements it
        Bird eagleObj = new Eagle();
        Bird crowObj = new Crow();
        eagleObj.fly();
        crowObj.fly();
    }
}
