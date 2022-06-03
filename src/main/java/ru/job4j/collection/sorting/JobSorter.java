package ru.job4j.collection.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        Collections.sort(jobs, new SortByNameJob());
        System.out.println(jobs);

        System.out.println("********************");
        List<Job> jobs2 = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs2, new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs2);

        System.out.println("********************");
        Comparator<Job> comb = new JobDescByNameLn()
                .thenComparing(new JobDescByName())
                .thenComparing(new JobDescByPriority());
        Collections.sort(jobs2, comb);
        System.out.println(jobs2);
    }
}
