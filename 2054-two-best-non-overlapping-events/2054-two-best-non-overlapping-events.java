class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int maxPrevVal = 0;
        int res = 0;
        
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            int val = event[2];
            
            while (!pq.isEmpty() && pq.peek()[0] < start) {
                maxPrevVal = Math.max(maxPrevVal, pq.poll()[1]);
            }
            
            res = Math.max(res, val + maxPrevVal);
            
            pq.offer(new int[]{end, val});
        }
        
        return res;
    }
}