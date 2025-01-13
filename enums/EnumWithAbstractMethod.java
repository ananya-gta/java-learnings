package enums;

public class EnumWithAbstractMethod {
    public interface MyInterface {
        public String toLowerCase();
    }

    public enum Sample implements MyInterface {
        MONDAY {
            public void dummyMethod() {
                System.out.println("overrriden MONDAY method");
            }
        },
        TUESDAY {
            public void dummyMethod() {
                System.out.println("overrriden TUESDAY method");
            }
        },
        SUNDAY {
            public void dummyMethod() {
                System.out.println("overrriden SUNDAY method");
            }
        };

        // but what if i want not all constants to implement abstract method
        @Override
        public String toLowerCase() {
            return this.name().toLowerCase();
        } // thsi function is for every constant to access
          // if abstarct method is there then each constant has to implement it

        public abstract void dummyMethod();

    }

    public static void main(String[] args) {
        Sample mondaySample = Sample.MONDAY;
        mondaySample.dummyMethod();
        mondaySample.toLowerCase();
    }
}
