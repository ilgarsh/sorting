    package ru.mail.polis.sort;
    import java.util.Random;
    import java.util.concurrent.ThreadLocalRandom;

    import static ru.mail.polis.sort.Helper.genInt;
    import static ru.mail.polis.sort.Helper.swap;
    public class FindK {
        public static int findK(int[] a, int k) {
            int left = 0;
            int right = a.length - 1;

            while (true) {
                if (left >= right)
                    return a[left];

                int mid = partition(a, left, right);

                if (mid == k) {
                    return a[mid];
                } else if (mid < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        private static int partition(int[] arr, int left, int right) {
            Random rnd = ThreadLocalRandom.current();
            int index = rnd.nextInt(right - left) + left;
            Helper.swap(arr, left, index);

            int x = arr[left];
            int j = left;

            for (int i = left + 1; i <= right; i++) {
                if (arr[i] <= x) {
                    j++;
                    Helper.swap(arr, i , j);
                }
            }
            Helper.swap(arr, left, j);

            return j;
        }
    }
