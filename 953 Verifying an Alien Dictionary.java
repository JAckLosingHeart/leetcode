import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Character> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        map.clear();
        for (int i = 0; i < order.length(); i++) {
            // java里char一加整数也就转int了
            map.put(order.charAt(i), (char)('a'+i));
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!lessOrEqualThan(words[i], words[i+1])) {
                return false;
            }
        }
        return true;
    }

    private boolean lessOrEqualThan(String pre, String pos) {
        StringBuilder preBuilder = new StringBuilder();
        StringBuilder posBuilder = new StringBuilder();
        for (Character c : pre.toCharArray()) {
            preBuilder.append(map.get(c));
        }
        for (Character c : pos.toCharArray()) {
            posBuilder.append(map.get(c));
        }
        // str.compareTo 很好使
        if (preBuilder.toString().compareTo(posBuilder.toString()) <= 0) {
            return true;
        } else {
            return false;
        }
    }
}