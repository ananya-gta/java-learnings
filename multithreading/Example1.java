package multithreading;


// when a process is created it starts with one thread called Main thread and tehn other are execution threads are created from it 
public class Example1 {
    public static void main (String[] args) {
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}
