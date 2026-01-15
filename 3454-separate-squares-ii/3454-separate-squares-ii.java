import java.util.*;

class Solution {

    static class Event {
        long y;
        int x1, x2;
        int type; // +1 add, -1 remove
        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    // Segment Tree to maintain union length
    static class SegmentTree {
        int n;
        int[] count;
        long[] length;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[n * 4];
            length = new long[n * 4];
        }

        void update(int idx, int l, int r, int ql, int qr, int val) {
            if (ql >= r || qr <= l) return;
            if (ql <= l && r <= qr) {
                count[idx] += val;
            } else {
                int mid = (l + r) / 2;
                update(idx * 2, l, mid, ql, qr, val);
                update(idx * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[idx] > 0) {
                length[idx] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[idx] = 0;
            } else {
                length[idx] = length[idx * 2] + length[idx * 2 + 1];
            }
        }

        void update(int l, int r, int val) {
            update(1, 0, n, l, r, val);
        }

        long query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {

        int n = squares.length;
        List<Event> events = new ArrayList<>();
        List<Long> xList = new ArrayList<>();

        for (int[] s : squares) {
            long x1 = s[0];
            long x2 = (long) s[0] + s[2];
            long y1 = s[1];
            long y2 = (long) s[1] + s[2];

            xList.add(x1);
            xList.add(x2);

            events.add(new Event(y1, 0, 0, 1));  // temp indices
            events.add(new Event(y2, 0, 0, -1));
        }

        // Coordinate compression
        long[] xs = xList.stream().distinct().sorted().mapToLong(Long::longValue).toArray();
        Map<Long, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) xIndex.put(xs[i], i);

        int ei = 0;
        for (int[] s : squares) {
            int x1 = xIndex.get((long) s[0]);
            int x2 = xIndex.get((long) s[0] + s[2]);

            events.get(ei++).x1 = x1;
            events.get(ei - 1).x2 = x2;
            events.get(ei++).x1 = x1;
            events.get(ei - 1).x2 = x2;
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        long prevY = events.get(0).y;
        double totalArea = 0;
        List<double[]> slabs = new ArrayList<>();

        for (Event e : events) {
            long currY = e.y;
            long width = st.query();

            if (currY > prevY && width > 0) {
                double area = (currY - prevY) * (double) width;
                slabs.add(new double[]{prevY, currY, width});
                totalArea += area;
            }

            st.update(e.x1, e.x2, e.type);
            prevY = currY;
        }

        double half = totalArea / 2;
        double acc = 0;

        for (double[] s : slabs) {
            double y1 = s[0], y2 = s[1], w = s[2];
            double area = (y2 - y1) * w;
            if (acc + area >= half) {
                return y1 + (half - acc) / w;
            }
            acc += area;
        }

        return slabs.get(slabs.size() - 1)[1];
    }
}