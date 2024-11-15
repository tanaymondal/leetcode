package dp;

import java.util.HashMap;

public class fibonacci {

    static HashMap<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fibTopDown(50));
        System.out.println(fibBottomUp(50));
    }

    // fib of n = fib(n-1) + fib(n-2)
    // what we know: fib(0) = 0 and fib(1) = 1

    static long fibTopDown(int n) {
        if (n < 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long value = fibTopDown(n - 1) + fibTopDown(n - 2);
            map.put(n, value);
            return value;
        }
    }

    static long fibBottomUp(int n) {
        if (n < 2) {
            return n;
        }
        int i = 2;
        long prev1 = 1;
        long prev2 = 0;
        long num = 0;
        while (i <= n) {
            num = prev1 + prev2;
            prev2 = prev1;
            prev1 = num;
            i++;
        }
        return num;
    }

}


