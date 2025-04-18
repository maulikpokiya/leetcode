class Solution {
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)) {
            return Collections.emptyList();
        }

        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack("", digits, map, result);
        return result;
    }

    private void backtrack(String current, String target, Map<Character,String> map, List<String> result) {
        if(target.length() == 0) {
            result.add(current);
        } else {
            for(char c : map.get(target.charAt(0)).toCharArray()) {
                backtrack(current + c, target.substring(1), map, result);
            }
        }
    }
}
