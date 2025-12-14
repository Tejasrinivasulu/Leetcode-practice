class Solution {
    public int numberOfWays(String corridor) {
        int MOD = 1_000_000_007;
        int seats = 0;

        // Count total seats
        for (char c : corridor.toCharArray()) {
            if (c == 'S') seats++;
        }

        // Invalid cases
        if (seats == 0 || seats % 2 != 0) return 0;

        long ways = 1;
        int seatCount = 0;
        int plantsBetween = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;

                // After finishing a section of 2 seats
                if (seatCount > 2 && seatCount % 2 == 1) {
                    ways = (ways * (plantsBetween + 1)) % MOD;
                    plantsBetween = 0;
                }
            } else {
                // Count plants only between sections
                if (seatCount >= 2 && seatCount % 2 == 0) {
                    plantsBetween++;
                }
            }
        }

        return (int) ways;
    }
}