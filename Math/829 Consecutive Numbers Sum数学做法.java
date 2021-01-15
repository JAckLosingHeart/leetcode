/**
 * 不知道为啥，sqrt里面值变大了就开始返回NaN了
 */
class Solution {
    public int consecutiveNumbersSum(int N) {
        int result = 0;
        int boudary = (int)(Math.sqrt(0.25+2*N)-0.5);
        for (long k = 1; k <= boudary; k++) {
            if ((N - k*(k+1)/2) % k == 0) {
                result++;
            }
        }
        return result;
    }
}