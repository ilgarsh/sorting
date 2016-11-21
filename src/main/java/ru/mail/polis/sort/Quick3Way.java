package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by Ilgar on 21.11.2016.
 */
public class Quick3Way {
    public int[] sort (int[] input){
        return sort(input, 0, input.length-1);
    }

    public int[] sort(int[] input, int lowIndex, int highIndex) {


        if (highIndex<=lowIndex) return input;

        int lt=lowIndex;
        int gt=highIndex;
        int i=lowIndex+1;

        int pivotIndex=lowIndex;
        int pivotValue=input[pivotIndex];


        while (i<=gt){


            if (input[i] < pivotValue){
                swap(input, i++, lt++);
            }
            else if (pivotValue < input[i]){
                swap(input, i, gt--);
            }
            else{
                i++;
            }


        }

        sort (input, lowIndex, lt-1);
        sort (input, gt+1, highIndex);

        return input;
    }
}
