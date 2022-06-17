package ru.job4j.collection.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CountFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        List<Double> result = CountFunction.diapason(2, 5, x -> 2 * x * x + 1 * x);
        List<Double> expected = Arrays.asList(10D, 21D, 36D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenDemonstrationFunctionThenLinearResults() {
        List<Double> result = CountFunction.diapason(2, 5, x -> x * x * x);
        List<Double> expected = Arrays.asList(8D, 27D, 64D);
        assertThat(result, is(expected));
    }
}