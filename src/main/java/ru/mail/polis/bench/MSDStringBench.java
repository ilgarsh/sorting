package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.MSDString;
import ru.mail.polis.sort.SimpleSortString;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ilgar on 26.11.2016.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class MSDStringBench {
    String[][] data;
    String[] curr;
    int index;
    Random r = new Random();

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new String[10][1000];
        for (int i = 0; i < 10; i++) {
            //define arrays here
            data[i] = Helper.genStr(1000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureMSDString() {
        MSDString.sort(curr);
    }

    @Benchmark
    public void measureSimpleSortString() {
        SimpleSortString.simpleSort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MSDStringBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
