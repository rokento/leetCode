/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefix {

    /**
     * 两两对比得出公共前缀后再使用公共前缀与下一个字符串比较
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) {
            return strs[0];
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = getCommPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }

    private String getCommPrefix(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int maxLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < maxLength; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                result.append(s1.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
