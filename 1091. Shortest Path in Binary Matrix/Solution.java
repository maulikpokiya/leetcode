class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        if (n == 1)
            return grid[0][0] == 0 ? 1 : -1;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 0, 0 });
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            level++;
            for (int l = 0; l < len; l++) {
                int[] curr = queue.removeFirst();
                int r = curr[0];
                int c = curr[1];

                for (int i = r - 1; i <= r + 1; i++) {
                    for (int j = c - 1; j <= c + 1; j++) {
                        if (i == -1 || i == n || j == -1 || j == n || grid[i][j] == 1) {
                            continue;
                        }
                        if (i == n - 1 && j == n - 1)
                            return level + 1;
                        else {
                            queue.add(new int[] { i, j });
                            grid[i][j] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
