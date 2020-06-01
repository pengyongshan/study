package com.tree.www.leetcode;

/**
 * Created by pysh on 2020-06-01.
 */
public class Leetcode394 {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     * eg:
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                int nextLeft = s.indexOf("[", i);

                int times = Integer.valueOf(s.substring(i, nextLeft));
                int left = nextLeft;

                int nextRight = s.indexOf("]", nextLeft + 1);
                nextLeft = s.indexOf("[", nextLeft + 1);
                while (nextLeft < nextRight && nextLeft > 0) {
                    nextRight = s.indexOf("]", nextRight + 1);
                    nextLeft = s.indexOf("[", nextLeft + 1);
                }

                String sub = decodeString(s.substring(left + 1, nextRight));

                while (times-- != 0) {
                    sb.append(sub);
                }
                i = nextRight;
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode394().decodeString("21[ab]3[cd4[g]]"));
        //System.out.println(new Leetcode394().decodeString("ab"));
    }
}
