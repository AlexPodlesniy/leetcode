package to100.to40;

class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int shift = getShift(nums);
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midV = nums[shiftIndex(mid, length, shift)];
            if (midV == target) {
                return shiftIndex(mid, length, shift);
            } else if (midV > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int shiftIndex(int index, int length, int shift) {
        int newIndex = index + shift;
        if (newIndex >= length) {
            return newIndex - length;
        } else {
            return newIndex;
        }
    }

    private int getShift(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        int lv = nums[l];
        int rv = nums[r];
        if (lv < rv) {
            return 0;
        }
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int midV = nums[mid];
            if (midV > nums[mid+1]) {
                return mid + 1;
            } else if (midV < lv) {
                r = mid;
                rv = nums[r];
            } else if (midV > rv) {
                l = mid;
                lv = nums[l];
            }
        }
        return 0;
    }
}
