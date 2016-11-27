package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.genInt;
import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by Ilgar on 27.11.2016.
 */
public class QuickSortBin {

    private static final int BIN_LENGTH = 31;

    public static int[] sort(int[] arr){
        sort(arr, 0, arr.length - 1, BIN_LENGTH);
        return arr;
    }

    private static int[] sort(int[] arr, int l, int r, int bit){
        if (l < r && (bit >= 0)) {
            int idx = partition(arr, l, r, bit);
            sort(arr, l, idx, bit - 1);
            sort(arr, idx + 1, r, bit - 1);
        }
        return arr;
    }

    private static int partition(int[] arr, int l, int r, int bit){
        int i = l;
        int j = r;
        while (i <= j){
            while (i < arr.length && digit(arr[i], bit) == 0) i++;
            while (j > -1 && digit(arr[j], bit) == 1) j--;
            if (i <= j) swap(arr, i++, j--);
        }
        return j;
    }

    private static int digit(int n, int k) {
        return (n >> k) & 1;
    }
}
