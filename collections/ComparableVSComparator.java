package collections;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableVSComparator {
    public static void main(String[] args) {
        Integer[] arr = {5, 6, 7, 8};
        // Arrays.sort(arr); --> this will give `cannot cast to a java.lang.Comparable` exception, instead pass a comparator
        Arrays.sort(arr, (Integer val1, Integer val2)-> val1 - val2); // sort in asc
        Arrays.sort(arr, (Integer val1, Integer val2)-> val2 - val1); // sort in desc


        //-------------------
        Car[] carObj = new Car[3];
        carObj[0] = new Car("BMW", "Black");
        carObj[1] = new Car("Audi", "Red");
        carObj[2] = new Car("Mercedes", "Blue");


        // compare and sort based on color in lexicogrphically desc order
        Arrays.sort(carObj, (Car obj1, Car obj2) -> obj2.carColor.compareTo(obj1.carColor));
        
        for (Car car : carObj) {
            System.out.println(car.carName + " " + car.carColor);
        }
        // ----------------- another way
        Car2[] carObj2 = new Car2[3];
        carObj2[0] = new Car2("BMW", "Black");
        carObj2[1] = new Car2("Audi", "Red");
        carObj2[2] = new Car2("Mercedes", "Blue");

        Arrays.sort(carObj2, new Car2());
        

    }
}

class Car {
    String carName;
    String carColor;

    Car (String name, String color) {
        this.carName = name;
        this.carColor = color;
    }
}

class Car2 implements Comparator<Car2> {
    String carName;
    String carColor;
    Car2(){}
    Car2(String name, String color) {
        this.carName = name;
        this.carColor = color;
    }

    @Override
    public int compare(Car2 obj1, Car2 obj2) {
        // compare and sort based on name in lexicogrphically asc order
        return obj1.carName.compareTo(obj2.carName);
    }
}
