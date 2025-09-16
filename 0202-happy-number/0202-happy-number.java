class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sqSum(slow);
            fast = sqSum(sqSum(fast));
        } while (slow != fast);
        return slow == 1;
    }
    private int sqSum(int x) {
        int s = 0;
        while (x > 0) {
            int d = x % 10;
            s += d * d;
            x /= 10;
        }
        return s;
    }
}