class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
           // Row -> all y values in that row
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        // Column -> all x values in that column
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        // Fill rowMap and colMap
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            rowMap.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            colMap.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        // Sort lists for binary searching neighbors
        for (List<Integer> list : rowMap.values()) Collections.sort(list);
        for (List<Integer> list : colMap.values()) Collections.sort(list);

        int covered = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            List<Integer> row = rowMap.get(x);  // all y values in same row
            List<Integer> col = colMap.get(y);  // all x values in same column

            int rowIndex = Collections.binarySearch(row, y);
            int colIndex = Collections.binarySearch(col, x);

            boolean left = rowIndex > 0;
            boolean right = rowIndex < row.size() - 1;
            boolean up = colIndex > 0;
            boolean down = colIndex < col.size() - 1;

            if (left && right && up && down) {
                covered++;
            }
        }

        return covered;
    }
}