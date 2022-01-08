package by.epam.lab.util;

import by.epam.lab.entity.Trial;

import java.util.List;

public class Utils {
    public static <T extends Trial> void printTrials(List<T> trials) {
        trials.forEach(System.out::println);
    }
}