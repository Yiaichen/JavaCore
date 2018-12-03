package leetcode.string;

public class ReverseString {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s));
    }

    public static String reverseString(String s) {
        int left = 0, right = s.length() - 1;
        char[] cs = s.toCharArray();
        while (left < right) {
            char c = cs[left];
            cs[left++] = cs[right];
            cs[right--] = c;
        }
        return new String(cs);
    }

}
