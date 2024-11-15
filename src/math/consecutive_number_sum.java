package math;

public class consecutive_number_sum {

    public static void main(String[] args) {
        //System.out.println(consecutiveNumbersSum(15));
        System.out.println(consecutiveNumbersSumMath(15));
    }

    public static int consecutiveNumbersSum(int n) {
        int count = 0;
        int i = 1;

        while (n > 0) {
            n = n - i;
            if (n % i == 0) {
                count++;
            }
            i++;
        }
        return count;
    }


    public static int consecutiveNumbersSumMath(int n) {
        int count = 0;
        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            int sumK = k * (k - 1) / 2;
            if ((n - sumK) % k == 0) {
                count++;
            }
        }
        return count;
    }

}
