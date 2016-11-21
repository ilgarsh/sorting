package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by Ilgar on 20.11.2016.
 */
public class InsertionSortBinSearch {
    public static int[] sort(int a[], int n){
        for (int i=0;i<n;++i){
            int temp=a[i];
            int left=0;
            int right=i;
            while (left<right){
                int middle=(left+right)/2;
                if (temp>=a[middle])
                    left=middle+1;
                else
                    right=middle;
            }
            for (int j=i;j>left;--j){
                swap(a,j-1,j);
            }
        }
        return a;
    }
}
