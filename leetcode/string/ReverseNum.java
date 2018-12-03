package leetcode.string;

public class ReverseNum {
    public static void main(String[] args) {
        int x = -12300;
        System.out.println(reverseNum(x));
    }

    public static int reverseNum(Integer x) {
        int result = 0;

        while (x != 0) {
            // 因为都是用int型的，如果超出了范围，其除以10的结果就不会跟之前的结果一致，通过这点也可以进行区分
            int tmp = result * 10 + x % 10;
            if (tmp / 10 != result) {
                return 0;
            }
            result = tmp;
            x = x / 10;
        }

        return result;
    }
}
