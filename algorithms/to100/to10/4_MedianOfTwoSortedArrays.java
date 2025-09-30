package to100.to10;

class MedianOfTwoSortedArrays {
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
