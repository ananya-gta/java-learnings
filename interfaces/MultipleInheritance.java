package interfaces;
interface WaterAnimal {
    public boolean canBreathe() ;
}

interface LandAnimal {
    public boolean canBreathe() ;
}

class Crocodile implements WaterAnimal, LandAnimal {
    @Override
    public boolean canBreathe() {
        return true;
    }

}
// class can implement multiple interfaces
public class MultipleInheritance {
    public static void main(String[] args) {
        Crocodile obj = new Crocodile();
        System.out.println(obj.canBreathe());
    }
}
