import java.util.Arrays;

/**
 * 给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。
 * <p>
 * 执行下述操作，直到 grid 变为空矩阵：
 * <p>
 * 从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
 * 将删除元素中的最大值与答案相加。
 * 注意 每执行一次操作，矩阵中列的数据就会减 1 。
 * <p>
 * <p>
 * 输入：grid = [[1,2,4],[3,3,1]]
 * 输出：8
 * 解释：上图展示在每一步中需要移除的值。
 * - 在第一步操作中，从第一行删除 4 ，从第二行删除 3（注意，有两个单元格中的值为 3 ，我们可以删除任一）。在答案上加 4 。
 * - 在第二步操作中，从第一行删除 2 ，从第二行删除 3 。在答案上加 3 。
 * - 在第三步操作中，从第一行删除 1 ，从第二行删除 1 。在答案上加 1 。
 * 最终，答案 = 4 + 3 + 1 = 8 。
 * **/

public class DeleteGreatestValue {
    public int deleteGreatestValue(int[][] grid) {
        int max = 0;
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        for (int i = grid[0].length - 1; i >= 0; i--) {
            int temp = 0;
            for (int[] ints : grid) {
                temp = Math.max(temp, ints[i]);
            }
            max += temp;
        }
        return max;
    }

    public static void main(String[] args) {
        DeleteGreatestValue d = new DeleteGreatestValue();
        int[][] grid = {
                {1, 2, 4},
                {3, 3, 1}
        };
        System.out.println(d.deleteGreatestValue(grid));
    }
}
