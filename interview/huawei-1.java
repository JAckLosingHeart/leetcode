import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String args[]) {
        String[] array = {"cat", "abc", "hhh", "habcajsd", "a"};
        String chars = "abct";
        System.out.println(lengthSum(array, chars));
    }
    static int lengthSum(String[] array, String chars) {
        if (array == null || chars == null)
            return 0;

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (arrayInChars(array[i], chars))
                result += array[i].length();
        }
        return result;
    }
    static boolean arrayInChars(String str, String chars) {
        List<Character> list = new LinkedList<>();
        for (Character c : chars.toCharArray()) {
            list.add(c);
        }
        for (Character c : str.toCharArray()) {
            if (!list.remove(c))
                return false;
        }
        return true;
    }
}