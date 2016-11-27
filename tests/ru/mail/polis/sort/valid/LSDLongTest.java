package ru.mail.polis.sort.valid;

/**
 * Created by Ilgar on 27.11.2016.
 */

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.polis.sort.*;

import static ru.mail.polis.sort.Helper.genLong;

@RunWith(Parameterized.class)
public class LSDLongTest {

    private static final Random r = ThreadLocalRandom.current();

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public long[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<long[]> data() {
        return Arrays.asList(new long[][]{
                {0L},
                {1L},
                {0L, 1L, 1L, 0L},
                genLong(1),
                genLong(10),
                genLong(100),
                genLong(1000),
                genLong(10000)
        });
    }

    private boolean isSorted(long[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void checkLSDLong() throws IOException {
        Assert.assertTrue(isSorted(LSDLongByte.sort(array)));
    }

    @Test
    public void checkSimpleSortLong() throws IOException {
        Assert.assertTrue(isSorted(SimpleSortLong.sort(array)));
    }

}
