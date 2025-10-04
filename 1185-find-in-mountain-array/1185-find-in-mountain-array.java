class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, n);
        int left = binarySearch(mountainArr, target, 0, peak, true);
        if (left != -1) return left;
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int findPeak(MountainArray arr, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr.get(m) < arr.get(m + 1)) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int binarySearch(MountainArray arr, int target, int l, int r, boolean asc) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = arr.get(m);
            if (val == target) return m;
            if (asc) {
                if (val < target) l = m + 1;
                else r = m - 1;
            } else {
                if (val > target) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }
}