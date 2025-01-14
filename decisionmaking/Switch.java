package decisionmaking;

public class Switch {
    public static void main(String[] args) {
        String day = "";
        int val = 1;
        String output = switch(val) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            default -> "None";
        };
        System.out.println(output);
    }
}
