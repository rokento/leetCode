import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *
 *
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class MajorityElement_169 {
    /**
     * 1.hash表统计出现元素出现次数，
     * 2.遍历hash表取出现最多的为多数元素
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map.Entry<Integer, Integer> max = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == null) {
                max = entry;
            } else {
                max = max.getValue() > entry.getValue() ? max : entry;
            }
        }
        return max.getKey();
    }

    public static void main(String[] args) {
        MajorityElement_169 m = new MajorityElement_169();
        System.out.println(m.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
