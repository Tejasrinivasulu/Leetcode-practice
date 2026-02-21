class Solution {
    public int countPrimeSetBits(int left, int right) {
         int count = 0;

        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);

            if (bits > 1) {
                boolean prime = true;
                for (int j = 2; j * j <= bits; j++) {
                    if (bits % j == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) count++;
            }
        }
        return count;
    }
}