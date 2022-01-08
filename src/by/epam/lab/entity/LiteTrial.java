package by.epam.lab.entity;

public class LiteTrial extends Trial {
    private static final int PASS_MARK1 = 35;
    private static final int PASS_MARK2 = 60;

    public LiteTrial() {
    }

    public LiteTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    public boolean isPassed() {
        return getMark1() >= PASS_MARK1 && getMark2() >= PASS_MARK2;
    }
}