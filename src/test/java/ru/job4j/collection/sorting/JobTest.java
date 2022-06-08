package ru.job4j.collection.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAsc() {
        List<Job> jobs = Arrays.asList(
                new Job("Job1", 4),
                new Job("Job3", 1),
                new Job("Job2", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Job1", 4),
                new Job("Job2", 2),
                new Job("Job3", 1)
        );
        Collections.sort(jobs, new JobAscByName());
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenCompatorByNameDesc() {
        List<Job> jobs = Arrays.asList(
                new Job("Job1", 4),
                new Job("Job3", 1),
                new Job("Job2", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Job3", 1),
                new Job("Job2", 2),
                new Job("Job1", 4)
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenCompatorByPriorityAsc() {
        List<Job> jobs = Arrays.asList(
                new Job("Job1", 4),
                new Job("Job3", 1),
                new Job("Job2", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Job3", 1),
                new Job("Job2", 2),
                new Job("Job1", 4)
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenCompatorByPriorityDesc() {
        List<Job> jobs = Arrays.asList(
                new Job("Job1", 4),
                new Job("Job3", 1),
                new Job("Job2", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Job1", 4),
                new Job("Job2", 2),
                new Job("Job3", 1)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs, is(expected));
    }
}