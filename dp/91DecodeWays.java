import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        return recursiveDecode(0, s);
    }

    private int recursiveDecode(int i, String s) {
        if (map.containsKey(i))
            return map.get(i);
        if (i == s.length())
            return 1;
        if (s.charAt(i) == '0')
            return 0;
        if (i == s.length()-1)
            return 1;
        int numDecodeWays = recursiveDecode(i+1,s);
        if (Integer.parseInt(s.substring(i,i+2)) <= 26)
            numDecodeWays += recursiveDecode(i+2, s);
        map.put(i,numDecodeWays);
        return  numDecodeWays;
    }
}