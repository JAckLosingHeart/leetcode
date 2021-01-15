/**
 * Space用更多但更地道的用法
 */
class Solution {
    public int reverse(int x) {
        try{
            int flag = x < 0 ? -1 : 1;
            String reversedAbs = new StringBuilder().append(Math.abs(x)).reverse().toString();
            return flag * Integer.parseInt(reversedAbs);
        } catch (Exception e) {
            return 0;
        }
    }
}