/**
 * 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 *
 *
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 *
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 *
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class Rotate_189 {

    /**
     * 挪动后的位置为 index+k % length - 1
     * 空间复杂度O（n）
     * 时间复杂度O（n）
     */
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int[] tempArr = new int[nums.length];
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((i + k) < nums.length) {
                index = i + k;
            } else {
                index = (i + k) % nums.length;
            }
            tempArr[index] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        Rotate_189 r = new Rotate_189();
        r.rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
