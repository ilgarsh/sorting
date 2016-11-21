package ru.mail.polis.bench;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import ru.mail.polis.sort.*;

import static java.util.Arrays.sort;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SortBench {

    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = Helper.gen(1000);
    }

    @Benchmark
    public void measureBubbleSort(Blackhole bh) {
        bh.consume(BubbleSort.sort(a));
    }

    @Benchmark
    public void measureInsertionSort(Blackhole bh)  {bh.consume(InsertionSort.insertionSort(a));}

    @Benchmark
    public void measureInsertionSortBinSearch(Blackhole bh) {bh.consume(InsertionSortBinSearch.sort(a, a.length));}

    @Benchmark
    public void measureMergesort(Blackhole bh) {bh.consume(Mergesort.sort(a));}


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
