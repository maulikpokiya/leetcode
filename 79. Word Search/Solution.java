class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (backtrack(board, word, 0, r, c, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int c,
            int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length
                || visited[i][j] || board[i][j] != word.charAt(c)) {
            return false;
        }

        if (c == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        if (backtrack(board, word, c + 1, i + 1, j, visited) ||
                backtrack(board, word, c + 1, i - 1, j, visited) ||
                backtrack(board, word, c + 1, i, j + 1, visited) ||
                backtrack(board, word, c + 1, i, j - 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
