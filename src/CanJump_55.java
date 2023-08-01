/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *
 *
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 *
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class CanJump_55 {

    /**
     * 假设目标位置为target，target前一格为start
     * 我们需要判断start是否能到达target，如果能到达则target就转换为了我们能不能到达start位置（target=start）
     * 如果start不能到达target，就要判断start-1位置能不能到达target，以此类推
     * 最后target是否为0则表示可以到达
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int target = nums.length - 1;
        int start = nums.length - 2;
        while (start >= 0) {
            if (nums[start] + start >= target) {
                target = start;
            }
            start --;
        }
        return target == 0;
    }

    public static void main(String[] args) {
        CanJump_55 c = new CanJump_55();
        System.out.println(c.canJump(new int[]{2,3,1,1,4}));
        System.out.println(c.canJump(new int[]{2,3,1,1,4}));
        System.out.println(c.canJump(new int[]{3,2,1,0,4}));
    }
}
