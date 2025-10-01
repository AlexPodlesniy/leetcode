package to100.to80;

class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int amount = m * n;

        int l = 0;
        int r = amount - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midRow = mid / n;
            int midColumn = mid % n;
            int midValue = matrix[midRow][midColumn];

            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
