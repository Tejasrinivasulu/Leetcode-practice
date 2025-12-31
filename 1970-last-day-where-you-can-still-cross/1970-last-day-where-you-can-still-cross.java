class Solution {

    int[] parent, rank;
    int rows, cols;
    int TOP, BOTTOM;

    public int latestDayToCross(int row, int col, int[][] cells) {
        rows = row;
        cols = col;

        int total = row * col;
        TOP = total;
        BOTTOM = total + 1;

        parent = new int[total + 2];
        rank = new int[total + 2];

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        boolean[][] land = new boolean[row][col];

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Reverse days
        for (int day = total - 1; day >= 0; day--) {

            int r = cells[day][0] - 1;
            int c = cells[day][1] - 1;
            land[r][c] = true;

            int idx = r * col + c;

            // Connect neighbors
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && land[nr][nc]) {
                    union(idx, nr * col + nc);
                }
            }

            // Connect top row
            if (r == 0) union(idx, TOP);
            // Connect bottom row
            if (r == row - 1) union(idx, BOTTOM);

            // Check connection
            if (find(TOP) == find(BOTTOM)) {
                return day;
            }
        }
        return 0;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
