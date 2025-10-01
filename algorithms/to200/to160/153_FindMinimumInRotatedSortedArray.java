package to200.to160;

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        int lv = nums[l];
        int rv = nums[r];
        if (lv < rv) {
            return lv;
        }
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int midV = nums[mid];
            int nexV = nums[mid + 1];
            if (midV > nexV) {
                return nexV;
            } else if (midV < lv) {
                r = mid;
                rv = nums[r];
            } else if (midV > rv) {
                l = mid;
                lv = nums[l];
            }
        }
        return nums[0];
    }
}
