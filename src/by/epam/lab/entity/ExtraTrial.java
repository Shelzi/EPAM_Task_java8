package by.epam.lab.entity;

public class ExtraTrial extends Trial {
    private static final int PASS_MARK3 = 75;
    private int mark3;

    public ExtraTrial() {
    }

    public ExtraTrial(String name, int mark1, int mark2, int mark3) {
        super(name, mark1, mark2);
        this.mark3 = mark3;
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }

    public boolean isPassed() {
        return super.isPassed() && (mark3 >= PASS_MARK3);
    }

    public double findAverage() {
        return ((getMark1() + getMark2() + mark3) / 3.0);
    }

    @Override
    public Trial refreshMarks() {
        super.refreshMarks();
        mark3 = 0;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%d;%d;%b",
                getName(), getMark1(), getMark2(), getMark3(), isPassed());
    }
}