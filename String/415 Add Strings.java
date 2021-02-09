/**
 * 这道题和之前的链表相加，二进制字符串相加全都一个道理，这算是练了三遍了把
 */
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        String reverseNum1 = new StringBuilder().append(num1).reverse().toString();
        String reverseNum2 = new StringBuilder().append(num2).reverse().toString();
        StringBuilder result = new StringBuilder();
        int num1Len = reverseNum1.length();
        int num2Len = reverseNum2.length();
        int carry = 0, i = 0, j = 0;
        while (i < num1Len || j < num2Len) {
            int num1Curr = i < num1Len ? Integer.parseInt(reverseNum1.charAt(i++) + "") : 0;
            int num2Curr = j < num2Len ? Integer.parseInt(reverseNum2.charAt(j++) + "") : 0;
            int sum = num1Curr + num2Curr + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}