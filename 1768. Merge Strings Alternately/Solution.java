class Solution {
    public String mergeAlternately(String word1, String word2) {
        int min = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        if (word1.length() > min) {
            sb.append(word1.substring(min, word1.length()));
        } else {
            sb.append(word2.substring(min, word2.length()));
        }
        return sb.toString();
    }
}
