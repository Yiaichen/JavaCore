package leetcode.string;


/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 代表26个字母
        int[] srray = new int[26];
        int[] trray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            srray[s.charAt(i)-97]++;
            trray[t.charAt(i)-97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (srray[i] != trray[i])
                return false;
        }
        return true;
    }

}
