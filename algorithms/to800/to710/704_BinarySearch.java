package to800.to710;

class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midElement = nums[mid];
            if (midElement == target) {
                return mid;
            } else if (midElement > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
