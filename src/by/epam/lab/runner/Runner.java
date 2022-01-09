package by.epam.lab.runner;

import by.epam.lab.entity.ExtraTrial;
import by.epam.lab.entity.LiteTrial;
import by.epam.lab.entity.StrongTrial;
import by.epam.lab.entity.Trial;
import by.epam.lab.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Trial> trials = new ArrayList<>(Arrays.asList(
                new Trial("Sakovich", 45, 93),
                new Trial("Kerkashin", 100, 100),
                new Trial("Zhylinsky", 51, 35),
                new LiteTrial("Barkou", 29, 95),
                new LiteTrial("Lisoniana", 35, 68),
                new StrongTrial("Astapenka", 30, 57),
                new StrongTrial("Vapenka", 90, 80),
                new ExtraTrial("Megabrain", 90, 90, 60),
                new ExtraTrial("Smartguy", 89, 90, 80))); //1

        Utils.printTrials(trials); //2
        System.out.println();

        trials.stream().filter(Trial::isPassed).forEach(System.out::println); //3
        System.out.println();

        Function<Trial, Integer> sumMarks = x -> x.getMark1() + x.getMark2();
        trials.sort(Comparator.comparingInt(sumMarks::apply)); //4
        System.out.println();

        trials.stream().map(sumMarks).forEach(System.out::println); //5
        System.out.println();

        List<Trial> nonPassedTrialsClone = trials.stream()
                .filter((p) -> !p.isPassed())
                .map(Trial::clone)
                .peek(Trial::refreshMarks)
                .collect(Collectors.toList()); //6
        Utils.printTrials(nonPassedTrialsClone);
        System.out.println();

        int[] arr = trials.stream()
                .mapToInt((ToIntFunction<? super Trial>) t -> (t.getMark1() + t.getMark2()))
                .toArray(); //7

        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();
    }
}