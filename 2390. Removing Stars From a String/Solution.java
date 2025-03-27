class Solution {
    public String removeStars(String s) {
        if(s.length() == 1) {
            return s;
        }

        Deque<Character> deque = new ArrayDeque<>();
        deque.add(s.charAt(0));

        for(int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c != '*') {
                deque.add(c);
            } else {
                deque.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : deque) {
            sb.append(c);
        }
        return sb.toString();
   }
}
