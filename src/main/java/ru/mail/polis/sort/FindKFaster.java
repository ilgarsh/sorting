package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by Ilgar on 26.11.2016.
 */
public class FindKFaster {

    public static int findKFaster(int[] arr, int k) {
        return findKFaster(arr, 0, arr.length-1, k);
    }

    private static int findPivot(int arr[], int left, int right) {
        Arrays.sort(arr, left, right);
        if((right + left) % 2 == 0){
            return arr[(left + right - 1) / 2];
        }
        else{
            return arr[(left + right) / 2];
        }
    }

    private static int findKFaster(int[] arr, int l, int r, int k) throws NullPointerException {
        if (k <= r - l + 1 && k > 0) {
            int n = r - l + 1;
            int i;
            int[] pivots = new int[(n + 4) / 5];

            for (i = 0; i < n / 5; i++) {
                int m = l + 5 * i;
                pivots[i] = findPivot(arr, m, m + 5);
            }

            if (i * 5 < n) {
                int m = l + i * 5;
                pivots[i] = findPivot(arr, m, m + n % 5);
                i++;
            }

            int pivOfPivots;
            if (i == 1){
                pivOfPivots=pivots[i-1];
            }
            else {
                pivOfPivots=findKFaster(pivots, 0, i - 1, i / 2);
            }
            int pos = partition(arr, l, r, pivOfPivots);

            if (pos-l == k-1) {
                return arr[pos];
            }
            else if (pos-l > k-1) {
                return findKFaster(arr, l, pos - 1, k);
            }
            else {
                return findKFaster(arr, pos + 1, r, k - pos + l - 1);
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int partition(int[] arr, int l, int r, int x) {
        int i;
        for (i = l; i < r; i++) {
            if(arr[i] == x) {
                break;
            }
        }
        Helper.swap(arr, i, r);

        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                Helper.swap(arr, i, j);
                i++;
            }
        }
        Helper.swap(arr, i, r);
        return i;
    }

    public static void main(String[] args) {
        int[] data = {0};
        System.out.println(FindKFaster.findKFaster(data, 1));
    }
}
