package enums;

public enum EnumWithCustomValues {
    MONDAY(101, "1st Day of the week"),
    TUESDAY(102, "2nd Day of the week"),
    WEDNESDAY(103, "3rd Day of the week"),
    THURSDAY(104, "4th Day of the week"),
    FRIDAY(105, "5th Day of the week"),
    SATURDAY(106, "6th Day of the week"),
    SUNDAY(107, "7th Day of the week");

    private int val;
    private String comment;

    EnumWithCustomValues(int val, String comment) {
        this.val = val;
        this.comment = comment;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static EnumWithCustomValues getEnumFromValue(int val) {
        for (EnumWithCustomValues sample : EnumWithCustomValues.values()) {
            if (sample.getVal() == val) {
                return sample;
            }
        }
        return null;
    }
}
