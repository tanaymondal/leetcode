package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minimum_absolute_difference {

    public static void main(String[] args) {
        int[] array = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(minimumAbsDifference(array));
    }

    static public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int dif = Math.abs(arr[i] - arr[i - 1]);

            if (dif < minDiff) {
                minDiff = dif;
                list.clear();
            }

            if (dif == minDiff) {
                list.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return list;
    }
}
