/**
 * 因为直接用integer内置函数会有溢出的危险，所以考虑使用手动给他计算
 *
 */
class Solution {
    public String addBinary(String a, String b) {
        // 把字符串反一下，符合我做从小index到大index做相加的习惯
        String reverse_a = new StringBuilder().append(a).reverse().toString();
        String reverse_b = new StringBuilder().append(b).reverse().toString();
        int len_a = reverse_a.length();
        int len_b = reverse_b.length();
        int i = 0, j = 0;
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        while (i < len_a || j < len_b) {
            int sum = (i < len_a ? Integer.parseInt(reverse_a.charAt(i)+"") : 0)
                    + (j < len_b ? Integer.parseInt(reverse_b.charAt(j)+"") : 0) + carry;
            switch (sum) {
                case 0:
                    builder.append('0');
                    carry = 0;
                    break;
                case 1:
                    builder.append('1');
                    carry = 0;
                    break;
                case 2:
                    builder.append('0');
                    carry = 1;
                    break;
                case 3:
                    builder.append('1');
                    carry = 1;
                    break;
                // 不能匹配以上任何一个case
                // default:
            }
            i++;
            j++;
        }
        if (carry == 1) {
            builder.append('1');
        }
        // 最后再反回来
        return builder.reverse().toString();
    }
}