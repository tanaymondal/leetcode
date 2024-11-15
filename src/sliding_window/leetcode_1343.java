package sliding_window;

public class leetcode_1343 {
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(numOfSubArrays(array, 3, 4));
    }

    public static int numOfSubArrays(int[] arr, int k, int threshold) {

        int L = 0;
        int currentSum = 0;
        int count = 0;
        for (int R = 0; R < arr.length; R++) {
            currentSum += arr[R];
            if (R - L + 1 == k) {
                if (currentSum / k >= threshold) {
                    count++;
                }
                currentSum = currentSum - arr[L];
                L++;
            }
        }
        return count;

    }
}
