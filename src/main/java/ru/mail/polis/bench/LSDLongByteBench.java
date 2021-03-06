package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.LSDLongByte;
import ru.mail.polis.sort.SimpleSortLong;
import ru.mail.polis.sort.SimpleSortString;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ilgar on 27.11.2016.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class LSDLongByteBench {
    long[][] data;
    long[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new long[10][100];
        for (int i = 0; i < 10; i++) {
            //define arrays here
            data[i] = Helper.genLong(1000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureLSDLongByte() {
        LSDLongByte.sort(curr);
    }

    @Benchmark
    public void measureSimpleSortLong() {
        SimpleSortLong.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LSDLongByte.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
