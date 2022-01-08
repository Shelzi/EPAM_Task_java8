package by.epam.lab.util;

import by.epam.lab.entity.ExtraTrial;
import by.epam.lab.entity.Trial;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utils {
    public static <T extends Trial> void printTrials(List<T> trials) {
        trials.forEach(System.out::println);
    }

    public static <T extends Trial> List<Trial> trialsHalfAveragePassMark(List<T> trials) {
        return trials.stream()
                .filter(s -> s.findAverage() <= Trial.getPassMark() / 2.0)
                .collect(Collectors.toList());
    }

    public static <T extends Trial> void clearMarksOfFailTrials(List<T> trials) {
        trials.stream()
                .filter(((Predicate<Trial>) Trial::isPassed).negate())
                .peek(s -> s.setMark1(0))
                .peek(s -> s.setMark2(0))
                .filter(s -> s.getClass() == ExtraTrial.class)
                .forEach(s -> ((ExtraTrial) s).setMark3(0));
    }

    public static <T extends Trial> void findEqualTrial(List<T> trials, T keyTrial) {
        trials.stream()
                .filter(Predicate.isEqual(keyTrial))
                .forEach(System.out::println);
    }
}