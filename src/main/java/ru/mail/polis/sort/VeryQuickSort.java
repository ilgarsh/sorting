package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by Ilgar on 21.11.2016.
 */
public class VeryQuickSort {
    public void quicksort(int[] a, int l, int r) {
        int v = a[r];
        if (r <= l) return;
        int i = l;
        int j = r - 1;
        int p = l - 1;
        int q = r;
        while (true) {
            while (a[i++] < v);
            while (a[j--] > v);
            if (i == j) {
                break;
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
            if (a[i] == v) {
                p++;
                swap(a, p, i);
            }
            
            if (a[j] == v) {
                q--;
                swap(a, q, j);
            }
        }
        swap(a[i], a[r])
        j = i - 1
        i++
        for (int k = 1; k \leqslant p;
        k++, j--)
        swap(a[k], a[j])
        for (int k = r - 1; k \geqslant q;
        k--, i++)
        swap(a[k], a[i])
        quicksort(a, 1, j)
        quicksort(a, i, r)
    }
}
