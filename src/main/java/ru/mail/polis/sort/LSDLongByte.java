package ru.mail.polis.sort;

public class LSDLongByte {

    private static final int BYTE = 8;

    public static long[] sort(long[] arr) {
        final int olderDigit = 1 << BYTE;
        final int mask = olderDigit - 1;
        long[] tempArray = new long[arr.length];
        for (int d = 0; d < BYTE; d++) {
            long[] counter = new long[olderDigit + 1];
            for (int i = 0; i < arr.length; i++) {
                int c = (int) ((arr[i] >> BYTE * d) & mask);
                counter[(c + 1)]++;
            }

            for (int r = 0; r < olderDigit; r++)
                counter[r + 1] += counter[r];

            if (d == BYTE - 1) {
                long shift1 = counter[olderDigit] - counter[olderDigit / 2];
                long shift2 = counter[olderDigit / 2];
                for (int r = 0; r < olderDigit / 2; r++)
                    counter[r] += shift1;
                for (int r = olderDigit / 2; r < olderDigit; r++)
                    counter[r] -= shift2;
            }

            for (int i = 0; i < arr.length; i++) {
                int c = (int) ((arr[i] >> BYTE * d) & mask);
                tempArray[(int) counter[c]++] = arr[i];
            }

            for (int i = 0; i < arr.length; i++)
                arr[i] = tempArray[i];
        }
        return arr;
    }
}
