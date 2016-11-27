package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.FindK;
import ru.mail.polis.sort.FindKFaster;
import ru.mail.polis.sort.Helper;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ilgar on 21.11.2016.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class FindKthBench {
    int[][] data;
    int[] curr;
    int index;
    int k;
    Random r = new Random();

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new int[10][1000];
        for (int i = 0; i < 10; i++) {
            //define arrays here
            data[i] = Helper.genInt(100000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
        k=r.nextInt(100000);
    }

    @Benchmark
    public void measureFindK() {
        FindK.findK(curr, k);
    }

    @Benchmark
    public void measureFindKFaster() {
        FindKFaster.findKFaster(curr, k);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(FindKthBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
