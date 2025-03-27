class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if(k > s.length() || k > 26) {
            return 0;
        }

        Set<Character> counts = new HashSet<>();
        int result = 0;

        int left=0;
        for(int right=0; right<s.length(); right++) {
            while(counts.contains(s.charAt(right))) {
                counts.remove(s.charAt(left));
                left++;
            }
            counts.add(s.charAt(right));

            if(right - left + 1 == k) {
                counts.remove(s.charAt(left));
                left++;
                result++;
            }
        }
        return result;
    }
}
