package by.epam.lab.entity;

public class StrongTrial extends Trial {
    private static final int MARK1_COEFFICIENT = 2;

    public StrongTrial() {
    }

    public StrongTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    public StrongTrial(StrongTrial strongTrial) {
        super(strongTrial);
    }

    @Override
    public StrongTrial getCopy() {
        return new StrongTrial(this);
    }

    protected int result() {
        return (getMark1() / MARK1_COEFFICIENT + getMark2());
    }
}