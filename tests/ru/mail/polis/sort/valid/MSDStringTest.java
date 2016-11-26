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

import static ru.mail.polis.sort.Helper.genStr;

public class MSDStringTest {

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
    public void test01_checkMSDStringSort() throws IOException {
        String[] array = genStr(1);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void test02_checkMSDStringSort() throws IOException {
        String[] array = genStr(10);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void test03_checkMSDStringSort() throws IOException {
        String[] array = genStr(100);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void test04_checkMSDStringSort() throws IOException {
        String[] array = genStr(1000);
        Assert.assertTrue(isSorted(array));
    }

    @Test
    public void test05_checkMSDStringSort() throws IOException {
        String[] array = genStr(10000);
        Assert.assertTrue(isSorted(array));
    }

}