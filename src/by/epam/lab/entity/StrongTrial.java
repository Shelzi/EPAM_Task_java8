package by.epam.lab.entity;

public class StrongTrial extends Trial {
    private static final int MARK1_COEFFICIENT = 2;

    public StrongTrial() {
    }

    public StrongTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

/*
    public StrongTrial(Trial trial) {
        super(trial);
    }
*/

    protected int result() {
        return (getMark1() / MARK1_COEFFICIENT + getMark2());
    }
}
