/**
 * 是可以基于之前那道reverse integer做的题，关键点还在于判断溢出的问题
 */
class Solution {
    public boolean isPalindrome(int x) {
        // 负数直接return false，问题简单了不少
        if (x < 0) {
            return false;
        }
        // 把最初的x存一下
        int prev_x = x;
        int reverse = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x/10;
            // 因为没有负数了，直接考虑正数即可，溢出直接return false
            if (reverse > Integer.MAX_VALUE / 10 || reverse == Integer.MAX_VALUE / 10 && pop > 7)
                return false;
            reverse = reverse * 10 + pop;
        }
        // 只有相等才说明是回文数
        if (prev_x == reverse) {
            return true;
        } else {
            return false;
        }
    }
}