package binary_search;

public class binary_search {
    // in binary search input array is sorted

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 9, 10, 67, 89, 99, 101};
        int target = 101;
        int index = binarySearch(array, target);
        System.out.println(index);
    }

    static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
