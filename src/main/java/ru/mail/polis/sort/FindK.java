package ru.mail.polis.sort;

import java.util.Random;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by Ilgar on 21.11.2016.
 */
public class FindK {
    public void kthElemenet(int[] a, int k) {
        int left=0;
        int right=a.length-1;
        Random rnd = new Random();
        while(right>left) {
            int pivotIdx = left + rnd.nextInt(right-left+1);
            int idx = partition(a, left, right, pivotIdx);
            if (k < idx) {
                right = idx - 1;
            }
            else if (k > idx) {
                left = idx + 1;
            }
            else return;
        }
    }

    private int partition(int[] a, int left, int right, int pivot) {
        if(left > right) return right;
        int i=0;
        int j=right;
        int x=a[pivot];
        swap(a, j--, pivot);
        while (i <= j) {
            while (i <= j && a[i] < x) i++;
            while (i <= j && a[j] > x) j--;
            if (i >= j) break;
            swap(a, i++, j--);
        }
        swap(a, i, right);
        return i;
    }
}
