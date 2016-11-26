package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import ru.mail.polis.sort.MSDString;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static ru.mail.polis.sort.Helper.genStr;

/**
 * Created by Ilgar on 26.11.2016.
 */
public class SimpleStringSortTest {
    private static final Random r = ThreadLocalRandom.current();

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    private boolean isSorted(String[] a) {
        String[] b = Arrays.copyOf(a, a.length);
        MSDString.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    @Test
    public void test1_checkSimpleSortString() throws IOException {
        String[] array = genStr(1);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void test2_checkSimpleSortString() throws IOException {
        String[] array = genStr(10);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void test3_checkSimpleSortString() throws IOException {
        String[] array = genStr(100);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void test4_checkSimpleSortString() throws IOException {
        String[] array = genStr(1000);
        Assert.assertTrue(isSorted(array));
    }

}
