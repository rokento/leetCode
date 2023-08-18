import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 *
 *
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 */
public class WordPattern_290 {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> vk = new HashMap<>();
        String[] strings = s.split(" ");
        for (int i = 0; i < Math.min(strings.length, pattern.length()); i++) {
            if (!map.containsKey(pattern.charAt(i)) && !vk.containsKey(strings[i])) {
                map.put(pattern.charAt(i), strings[i]);
                vk.put(strings[i], pattern.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : pattern.toCharArray()) {
            sb.append(map.get(c));
            sb.append(" ");
        }
        return s.equals(sb.toString().trim());
    }

    public static void main(String[] args) {
        WordPattern_290 w = new WordPattern_290();
        System.out.println(w.wordPattern("aba", "cat cat cat dog"));
    }
}
