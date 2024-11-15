package binary_search;

public class search_in_sorted_matrix {
    // https://leetcode.com/problems/search-a-2d-matrix/description/

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {1, 2, 3}, {7, 8, 9}};
        System.out.println(searchMatrix(matrix, 8));
    }

    // {1, 2, 3}
    // {1, 2, 3}
    // {7, 8, 9}

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
