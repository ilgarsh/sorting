package ru.mail.polis.sort;

/**
 * Created by Ilgar on 26.11.2016.
 */
public class SimpleSortString {
    public static void simpleSort(String[] a) {
        boolean wasSwap = true;
        int j = 0;
        while (wasSwap) {
            wasSwap = false;
            for (int i = 0; i < a.length - j - 1; i++) {
                if (a[i].compareTo(a[i + 1])>0) {
                    Helper.swap(a, i, i + 1);
                    wasSwap = true;
                }
            }
            j++;
        }
    }
}
