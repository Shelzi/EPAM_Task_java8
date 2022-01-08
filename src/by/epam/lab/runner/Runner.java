package by.epam.lab.runner;

import by.epam.lab.entity.ExtraTrial;
import by.epam.lab.entity.LiteTrial;
import by.epam.lab.entity.StrongTrial;
import by.epam.lab.entity.Trial;
import by.epam.lab.util.Utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Trial> trials = new ArrayList<Trial>() {
            {
                add(new Trial("Sakovich", 45, 93));
                add(new Trial("Kerkashin", 100, 100));
                add(new Trial("Zhylinsky", 51, 35));
                add(new LiteTrial("Barkou", 29, 95));
                add(new LiteTrial("Lisoniana", 35, 68));
                add(new StrongTrial("Astapenka", 30, 57));
                add(new StrongTrial("Vapenka", 90, 80));
                add(new ExtraTrial("Megabrain", 90, 90, 60));
                add(new ExtraTrial("Smartguy", 89, 90, 80));
            }
        };

        Utils.printTrials(trials);
        System.out.println();

        trials.stream().filter(Trial::isPassed).forEach(System.out::println);
        System.out.println();

        trials = trials.stream().sorted(Trial::compareTo).collect(Collectors.toList());
        System.out.println();

        Utils.printTrials(trials);
        System.out.println();

        trials.stream().forEach(s -> System.out.println(s.getMark1() + s.getMark2()));
        System.out.println();

        List<Trial> nonPassedTrials = trials.stream().filter(((Predicate<Trial>) Trial::isPassed).negate()).collect(Collectors.toList());
        Utils.clearMarksOfFailTrials(nonPassedTrials);
        Utils.printTrials(nonPassedTrials);
        System.out.println();

        System.out.println(Utils.trialsHalfAveragePassMark(trials));

        //Utils.findEqualTrial(trials, new ExtraTrial("Smartguy", 89, 90, 80));
    }
}