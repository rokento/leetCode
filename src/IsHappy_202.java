import java.util.HashMap;
import java.util.Map;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 */
public class IsHappy_202 {

    /**
     * 使用hashMap记录每一次的计算结果，每次计算开始时判断是否回到了前面已经计算过的结果
     */
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int happy = calc(n);
        while (happy != 1) {
            if (map.containsKey(happy)) { // 回到了之前计算的结果，表示出现了循坏
                return false;
            }
            map.put(happy, happy);
            happy = calc(happy);
        }
        return true;
    }

    /**
     * 快乐数计算规则
     * @param n int
     * @return int 计算结果
     */
    public int calc(int n) {
        int temp = 0;
        while (n > 0) {
            int m = n % 10;
            temp += m * m;
            n = (n - m) / 10;
        }
        return temp;
    }

    public static void main(String[] args) {
        IsHappy_202 i = new IsHappy_202();
        System.out.println(i.isHappy(2));
    }
}
