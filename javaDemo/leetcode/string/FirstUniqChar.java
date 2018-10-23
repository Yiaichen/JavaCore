package javaDemo.leetcode.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *      s = "leetcode"
 *      返回 0.
 *
 *      s = "loveleetcode",
 *      返回 2.
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i< cs.length; i++) {
            if(map.containsKey(cs[i])) {
                map.put(cs[i], -1);
            } else {
                map.put(cs[i], i);
            }
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }
        return -1;
    }

}
