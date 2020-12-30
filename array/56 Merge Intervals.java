import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 之所以这里我们用LinkedList，是因为我们用到了只有LinkedList有的函数
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            if (list.isEmpty() || interval[0] > list.getLast()[1]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }
        // 因为object[]不能直接cast为int[][]，所以要用带T[]的重载接口
        // 还要在堆上新开辟一个空间
        // 这个list.size()必须放上去，这样它才会初始化，后面一个括号不用加因为可以动态分配
        return list.toArray(new int[list.size()][]);
    }
}