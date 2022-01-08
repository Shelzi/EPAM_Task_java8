package by.epam.lab.entity;

import java.util.Objects;

public class Trial implements Comparable<Trial>, Cloneable {
    protected static final int PASS_MARK = 120;
    private String name;
    private int mark1;
    private int mark2;

    public Trial() {
    }

    public Trial(String name, int mark1, int mark2) {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public static int getPassMark() {
        return PASS_MARK;
    }

    protected int result() {
        return (mark1 + mark2);
    }

    public boolean isPassed() {
        return (result() >= PASS_MARK);
    }

    public double findAverage() {
        return ((mark1 + mark2) / 2.0);
    }

    public Trial refreshMarks() {
        mark1 = 0;
        mark2 = 0;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s;%d;%d;%b",
                name, mark1, mark2, isPassed());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Trial trial = (Trial) o;
        return mark1 == trial.mark1 && mark2 == trial.mark2 &&
                (Objects.equals(this.name, trial.name));
    }

    @Override
    public int compareTo(Trial o) {
        return ((mark1 + mark2) - (o.mark1 + o.mark2));
    }

    @Override
    public Trial clone() {
        try {
            return (Trial) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}