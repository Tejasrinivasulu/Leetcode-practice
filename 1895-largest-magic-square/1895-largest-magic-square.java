class Solution {
    public int largestMagicSquare(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;

        // try size from big to small
        for (int size = Math.min(n, m); size >= 1; size--) {
            for (int r = 0; r + size <= n; r++) {
                for (int c = 0; c + size <= m; c++) {

                    int sum = 0;
                    // first row sum
                    for (int j = 0; j < size; j++)
                        sum += grid[r][c + j];

                    boolean ok = true;

                    // rows
                    for (int i = 0; i < size && ok; i++) {
                        int rowSum = 0;
                        for (int j = 0; j < size; j++)
                            rowSum += grid[r + i][c + j];
                        if (rowSum != sum) ok = false;
                    }

                    // columns
                    for (int j = 0; j < size && ok; j++) {
                        int colSum = 0;
                        for (int i = 0; i < size; i++)
                            colSum += grid[r + i][c + j];
                        if (colSum != sum) ok = false;
                    }

                    // main diagonal
                    int d1 = 0;
                    for (int i = 0; i < size; i++)
                        d1 += grid[r + i][c + i];

                    // anti diagonal
                    int d2 = 0;
                    for (int i = 0; i < size; i++)
                        d2 += grid[r + i][c + size - 1 - i];

                    if (ok && d1 == sum && d2 == sum)
                        return size;
                }
            }
        }
        return 1;
    }
}