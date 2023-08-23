/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() <= 1) {
            return t.contains(s);
        }
        int index1 = 0;
        int index2 = 0;
        while (index2 < t.length() && index1 < s.length()) {
            if (s.charAt(index1) == t.charAt(index2)) {
                index1++;
            }
            index2++;
        }
        return index1 == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence_392 t = new IsSubsequence_392();
        System.out.println(t.isSubsequence("abc", "ahbgdc"));
    }
}
