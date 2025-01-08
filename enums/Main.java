package enums;

public class Main {
    public static void main(String[] args) {
        for (EnumSample sample : EnumSample.values()) {
            System.out.println(sample.ordinal());
        }
        EnumSample enumVariable = EnumSample.valueOf("FRIDAY");
        System.out.println(enumVariable.name());
    }
}