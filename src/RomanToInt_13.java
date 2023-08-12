import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: s = "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: s = "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 */
public class RomanToInt_13 {

    public static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("L", 50);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("I", 1);
    }

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};


    /**
     * 暴力解法
     */
    public int romanToInt(String s) {
        List<String> list = new ArrayList<>();
        int temp = 0;
        while (temp < s.length()){
            if (s.charAt(temp) == 'I') {
                if (temp + 1 < s.length() && (s.charAt(temp+1) == 'V' || s.charAt(temp+1) == 'X')) {
                    list.add(s.substring(temp, temp + 2));
                    temp += 2;
                } else {
                    list.add(String.valueOf(s.charAt(temp)));
                    temp++;
                }
            } else if(s.charAt(temp) == 'X') {
                if (temp + 1 < s.length() && (s.charAt(temp+1) == 'L' || s.charAt(temp+1) == 'C')) {
                    list.add(s.substring(temp, temp + 2));
                    temp += 2;
                } else {
                    list.add(String.valueOf(s.charAt(temp)));
                    temp++;
                }
            } else if(s.charAt(temp) == 'C') {
                if (temp + 1 < s.length() && (s.charAt(temp+1) == 'D' || s.charAt(temp+1) == 'M')) {
                    list.add(s.substring(temp, temp + 2));
                    temp += 2;
                } else {
                    list.add(String.valueOf(s.charAt(temp)));
                    temp++;
                }
            } else {
                list.add(String.valueOf(s.charAt(temp)));
                temp++;
            }
        }
        int result = 0;
        for(String str : list) {
            result += map.get(str);
        }
        return result;
    }


    /**
     * 方式二:
     * 通过找规律，从左到右，如果左边数字小于右边数字则右边数字减左边 如 IX (I=1,X=10, 10-1=9)
     */
    public int romanToInt1(String s){
        int result = 0;
        int index = 0;
        while (index < s.length()) {
            int value = symbolValues.get(s.charAt(index));
            if (index < s.length() - 1 && value < symbolValues.get(s.charAt(index + 1))) {
                result += symbolValues.get(s.charAt(index + 1)) - value;
                index += 2;
            } else {
                result += symbolValues.get(s.charAt(index));
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt_13 r = new RomanToInt_13();
        System.out.println(r.romanToInt1("MCMXCIV"));
    }
}
