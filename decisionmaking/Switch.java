package decisionmaking;

public class Switch {
    public static void main(String[] args) {
        // switch labels
        String day = "";
        int val = 1;
        String output = switch(val) {
            case 1 -> "Monday"; // after arrow we put the return value and no break statemnet is required
            case 2 -> "Tuesday";
            default -> "None";
        };
        System.out.println(output);
    }
}
