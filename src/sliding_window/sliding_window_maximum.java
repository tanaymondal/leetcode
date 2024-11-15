package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sliding_window_maximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int right = k - 1; right < nums.length; right++) {
            int left = index;
            int max = Integer.MIN_VALUE;
            while (left <= right) {
                max = Math.max(max, nums[left]);
                left++;
            }
            list.add(max);
            index++;
        }

        return convertIntegers(list);

    }

    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }
}
