class Solution {
    public int mostBooked(int n, int[][] meetings) {
          Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? (int)(a[1] - b[1]) : (int)(a[0] - b[0])
        );

        int[] count = new int[n];

        for (int[] meet : meetings) {
            long start = meet[0];
            long end = meet[1];
            long duration = end - start;

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.add((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                busyRooms.add(new long[]{end, room});
                count[room]++;
            } else {
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                busyRooms.add(new long[]{newEnd, room});
                count[room]++;
            }
        }

        int maxMeetings = 0;
        int resultRoom = 0;

        for (int i = 0; i < n; i++) {
            if (count[i] > maxMeetings) {
                maxMeetings = count[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}