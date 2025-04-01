class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int n, int openCount, int closeCount, StringBuilder sb, List<String> result) {
        if (sb.length() == n * 2) {
            result.add(sb.toString());
        }

        if (openCount < n) {
            sb.append("(");
            backtrack(n, openCount + 1, closeCount, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closeCount < openCount) {
            sb.append(")");
            backtrack(n, openCount, closeCount + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
