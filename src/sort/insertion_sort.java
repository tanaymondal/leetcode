package sort;

import java.util.Arrays;

public class insertion_sort {
    public static void main(String[] args) {
        int[] array = {4, 1, 8, 2, 3};

        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            while (j >= 0 && array[j + 1] < array[j]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(array));

    }
}

// TC => O(n^2)
// SC => O(n)
