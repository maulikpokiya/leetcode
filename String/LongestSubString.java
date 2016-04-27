public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        
        char[] input = s.toCharArray();
        int length = 0;
        int maxLength = 0;
        char c;
        List<Character> temp = new ArrayList<Character>();

        for(int i=0; i<input.length; i++) {
            for(int j=i; j<input.length; j++) {
                c = input[j];
                if(temp.contains(c)) {
                    break;
                }
                temp.add(c);
            }

            length = temp.size();
            if(length > maxLength)
                maxLength = length;
            temp = new ArrayList<Character>();
        }

        return maxLength;
    }
}