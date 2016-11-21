package ru.mail.polis.sort;

/**
 * Created by Ilgar on 21.11.2016.
 */
public class QuickSort {
    private static int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[i+(j-i+1)/2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return j;
    }

    public static void quickSort(int arr[], int left, int right) {
        if(left >= right) return;
        int idx = partition(arr, left, right);
        quickSort(arr, left, idx);
        quickSort(arr, idx+1, right);
    }
}
