package ru.mail.polis.sort.valid;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ru.mail.polis.sort.*;

import static ru.mail.polis.sort.Helper.genInt;

@RunWith(Parameterized.class)
public class Tester {

    private static final Random r = ThreadLocalRandom.current();

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

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
                genInt(1),
                genInt(10),
                genInt(100),
                genInt(1000),
                genInt(10000),
        });
    }

    private boolean isSorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkBubbleSort() throws IOException {
        Assert.assertTrue(isSorted(BubbleSort.sort(array)));
    }

    @Test
    public void test02_checkInsertionSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionSort.insertionSort(array)));
    }

    @Test
    public void test03_checkInsertionSortBinSearch() throws IOException {
        Assert.assertTrue(isSorted(InsertionSortBinSearch.sort(array, array.length)));
    }

    @Test
    public void test04_checkShellSort() throws IOException {
        Assert.assertTrue(isSorted(ShellSort.sort(array)));
    }

    @Test
    public void test05_checkMergeSort() throws IOException {
        Assert.assertTrue(isSorted(Mergesort.sort(array)));
    }

    @Test
    public void test06_checkMergeSortMemory() throws IOException {
        Assert.assertTrue(isSorted(MergeSortMemory.sort(array)));
    }

    @Test
    public void test07_checkQuickSort() throws IOException {
        Assert.assertTrue(isSorted(QuickSort.quickSort(array, 0, array.length - 1)));
    }

    @Test
    public void test08_checkQuick3Way() throws IOException {
        Assert.assertTrue(isSorted(Quick3Way.sort(array)));
    }

    @Test
    public void test09_checkQuickSortBin() throws IOException {
        Assert.assertTrue(isSorted(QuickSortBin.sort(array)));
    }

    @Test
    public void test10_checkMSDSortBin() throws IOException {
        Assert.assertTrue(isSorted(MSDSortBin.sort(array)));
    }
}
