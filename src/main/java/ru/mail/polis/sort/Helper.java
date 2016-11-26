package ru.mail.polis.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    private static final Random r = ThreadLocalRandom.current();
    private static final String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void swap(String[] a, int i, int j) {
        String x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] genInt(int n) {
        int[] a = new int[n];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = r.nextInt(i + 1);
        }
        return a;
    }

    public static String[] genStr(int n) {
        String[] a = new String[n];
        int sizeAlph = alph.length();
        StringBuilder rndString = new StringBuilder();
        int rndSizeString;
        for (int i = 0; i < a.length; i++) {
            rndSizeString=r.nextInt(sizeAlph);
            for (int j=0; j<rndSizeString; j++) {
                rndString.append(alph.charAt(r.nextInt(sizeAlph)));
            }
            a[i] = rndString.toString();
            rndString.delete(0,rndSizeString);
        }
        return a;
    }
}
