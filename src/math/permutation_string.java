package math;

import java.util.Arrays;

public class permutation_string {
    public static void main(String[] args) {
        int number = 1234;

        char[] array = String.valueOf(number).toCharArray();
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            char[] m = array;
            for (int j = 0; j < array.length; j++) {
                if (array[i] != array[j]) {
                    char temp = array[i];
                    m[i] = array[j];
                    m[j] = temp;
                }

                count++;
                System.out.println(Arrays.toString(m));
            }
        }
        System.out.println(count);
    }
}
