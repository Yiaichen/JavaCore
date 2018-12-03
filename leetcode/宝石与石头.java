package leetcode;

import java.io.UnsupportedEncodingException;

public class 宝石与石头 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        宝石与石头 bs = new 宝石与石头();

        String J = "aA";
        String S = "aAAbbbb";

        System.out.println(bs.numJewelsInStones(J, S));

    }

    public int numJewelsInStones(String J, String S) {
        int num = 0;
        char[] charsS = S.toCharArray();

        for (int i = 0; i < charsS.length; i++) {
            if (J.contains(String.valueOf(charsS[i])))
                num++;
        }
        return num;
    }
}
