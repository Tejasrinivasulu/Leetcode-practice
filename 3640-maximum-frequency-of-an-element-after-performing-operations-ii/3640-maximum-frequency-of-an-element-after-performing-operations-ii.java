import java.util.*;

class Solution {
    /**
     * Finds the maximum possible frequency of any element in nums after performing operations.
     * Time Complexity: O(n log n) due to sorting/TreeSet/TreeMap operations.
     * Space Complexity: O(n) for maps and sets.
     *
     * @param nums The initial array of integers.
     * @param k The maximum absolute change in one operation, [-k, k].
     * @param numOperations The number of elements that can be modified.
     * @return The maximum possible frequency.
     */
    public int maxFrequency(int[] nums, int k, int numOperations) {
        // Step 1: Initialize data structures for counting and sweep-line
        // 'count' stores the initial frequency of each number in nums.
        Map<Integer, Integer> count = new HashMap<>();
        // 'line' is the difference array for the sweep line. Key is a position,
        // value is the change in the number of elements that can reach that position.
        // TreeMap is used to process positions in sorted order.
        TreeMap<Integer, Integer> line = new TreeMap<>();
        // 'candidates' stores all relevant positions (nums[i], nums[i]-k, nums[i]+k+1)
        // that could be the start or end of a reachable range or an existing element.
        Set<Integer> candidates = new TreeSet<>();

        for (final int num : nums) {
            // Initial count of the number itself
            count.merge(num, 1, Integer::sum);
            
            // Sweep-line: An element 'num' can be transformed to any value in [num - k, num + k].
            
            // Start of the reachable range: num - k
            // The count of elements that can reach a value increases by 1 at this point.
            line.merge(num - k, 1, Integer::sum);
            
            // End of the reachable range (exclusive): num + k + 1
            // The count decreases by 1 at this point.
            line.merge(num + k + 1, -1, Integer::sum);
            
            // Add relevant points to candidates for checking
            candidates.add(num);
            candidates.add(num - k);
            candidates.add(num + k + 1);
        }

        int ans = 1;
        // 'adjustable' tracks the running sum of the sweep line, representing
        // the total number of elements in 'nums' that *can* be transformed to the current 'num'
        // (i.e., num is within the range [nums[i]-k, nums[i]+k] for 'adjustable' elements).
        int adjustable = 0;

        // Iterate through all candidate positions in sorted order
        for (final int num : candidates) {
            // Update the running count based on the sweep-line difference array
            adjustable += line.getOrDefault(num, 0);

            // 'countNum' is the number of elements already equal to 'num'
            final int countNum = count.getOrDefault(num, 0);

            // 'adjusted' is the number of *other* elements that can be transformed to 'num'.
            // It's the total elements that can reach 'num' ('adjustable') minus the elements
            // that are *already* 'num' ('countNum').
            final int adjusted = adjustable - countNum;

            // Maximum frequency is the number of original elements ('countNum') plus 
            // the minimum of (available operations on other elements, number of other
            // elements that *can* be transformed to 'num').
            // The minimum ensures we don't use more operations than available or
            // count more elements than can actually be transformed.
            ans = Math.max(ans, countNum + Math.min(numOperations, adjusted));
        }

        return ans;
    }
}