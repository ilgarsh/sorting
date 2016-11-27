package ru.mail.polis.sort;

/**
 * Created by Ilgar on 27.11.2016.
 */
public class MSDSortBin {

    private static final int BIN_LENGTH = 31;

    public static int[] sort(int[] arr){
        int[] res = new int[arr.length];
        sort(arr, res, 0, arr.length - 1, BIN_LENGTH);
        return arr;
    }

    private static void sort(int[] arr, int[] res, int left, int right, int r) {
        if (r < 0 || left >= right) return;
        int[] count = new int[32];

        for (int i = left; i <= right; i++) {
            count[digit(arr[i], r)]++;
        }
        for (int i = 1; i < 32; i++) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            res[left + --count[digit(arr[i], r)]] = arr[i];
        }
        System.arraycopy(res, left, arr, left, right - left + 1);
        for (int i = 0; i < 31; i++) {
            sort(arr, res, left + count[i], left + count[i + 1] - 1, r - 1);
        }
    }

    private static int digit(int i, int r) {
        return (i >> r) & 1;
    }
}
