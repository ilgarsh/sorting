package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.FindK;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static ru.mail.polis.sort.Helper.genInt;


/**
 * Created by Ilgar on 26.11.2016.
 */
@RunWith(Parameterized.class)
public class FindKTest {
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    private int expected(int[] a, int k) {
        Arrays.sort(a);
        return a[k];
    }

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
                genInt(1),
                genInt(10),
                genInt(100),
                genInt(1000),
                genInt(10000),
        });
    }

    @Test
    public void test_checkFindK() throws IOException {
        Random r = new Random();
        int[] tempArray = Arrays.copyOf(array, array.length);
        int k = r.nextInt(array.length);
        Assert.assertEquals(FindK.findK(tempArray, k), expected(array, k));
    }
}
