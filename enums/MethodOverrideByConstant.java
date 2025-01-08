package enums;

public class MethodOverrideByConstant {
    public enum EnumSample {
        // suppose if i want to override this dummy method for monday
        MONDAY {
            @Override
            public void dummyMethod() {
                System.out.println("overrriden dummy method");
            }
        }, 
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;

        public void dummyMethod() {
            System.out.println("default dummy method will be accessible by each constant of enum");
        }
    }
    public static void main(String[] args) {
        EnumSample fridayEnumSample = EnumSample.FRIDAY;
        fridayEnumSample.dummyMethod(); // prints default dummy method 
        EnumSample mondayEnumSample = EnumSample.MONDAY;
        mondayEnumSample.dummyMethod(); // prints monday's overriden dummy method
    }
}
