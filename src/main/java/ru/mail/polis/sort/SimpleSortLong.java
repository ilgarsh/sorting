package ru.mail.polis.sort;

/**
 * Created by Ilgar on 27.11.2016.
 */
public class SimpleSortLong {
    public static long[] sort(long a[]) {
        boolean wasSwap = true;
        int j = 0;
        while (wasSwap) {
            wasSwap = false;
            for (int i = 0; i < a.length - j - 1; i++) {
                if (a[i] > a[i + 1]) {
                    Helper.swap(a, i, i + 1);
                    wasSwap = true;
                }
            }
            j++;
        }
        return a;
    }
}
