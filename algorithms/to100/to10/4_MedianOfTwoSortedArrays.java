package to100.to10;

class MergeAndGetMedian {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr = mergeArrs(nums1, nums2);

        if (mergedArr.length % 2 == 1) {
            return mergedArr[(mergedArr.length - 1) / 2];
        } else {
            double n1 = mergedArr[mergedArr.length/2 - 1];
            double n2 = mergedArr[mergedArr.length/2];
            return (n1 + n2) / 2;
        }
    }

    private int[] mergeArrs(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, k = 0; k < arr.length; k++) {
            Integer n1 = i < nums1.length ? nums1[i] : null;
            Integer n2 = j < nums2.length ? nums2[j] : null;
            if (n1 != null && (n2 == null || n1 <= n2)) {
                arr[k] = n1;
                i++;
            } else {
                arr[k] = n2;
                j++;
            }
        }
        return arr;
    }
}

class BinarySearchMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int half = (n + m) / 2;

        // ищем середину
        int low = 0;
        int high = n;

        int mid1 = -1;
        int mid2 = -1;
        int l1, l2, r1, r2;
        double leftMax, rightMin;
        while (true) {
            l1 = Integer.MIN_VALUE;
            l2 = Integer.MIN_VALUE;
            r1 = Integer.MAX_VALUE;
            r2 = Integer.MAX_VALUE;

            mid1 = (low + high) / 2;
            mid2 = half - mid1;

            if (mid1 > 0) l1 = nums1[mid1 - 1];
            if (mid1 < n) r1 = nums1[mid1];
            if (mid2 > 0) l2 = nums2[mid2 - 1];
            if (mid2 < m) r2 = nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 1) {
                    return Math.min(r1, r2);
                } else {
                    double r = Math.min(r1, r2);
                    double l = Math.max(l1, l2);
                    return (r+l)/2;
                }
            } else if (l2 > r1) {
                low = mid1 + 1;
            } else {
                high = mid1 - 1;
            }
        }
    }
}
