package com.tree.www.leetcode;

/**
 * 模式匹配
 * <p>
 * Created by pysh on 2020-06-22.
 */
public class LeetcodeInterview1618 {

    /**
     * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
     * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），
     * 该字符串也匹配像"a"、"ab"和"b"这样的模式。
     * 但需注意"a"和"b"不能同时表示相同的字符串。
     * 编写一个方法判断value字符串是否匹配pattern字符串。
     * <p>
     * tips:
     * 0 <= len(pattern) <= 1000
     * 0 <= len(value) <= 1000
     * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
     *
     * @param pattern
     * @param value
     * @return
     */
    public boolean patternMatching(String pattern, String value) {
        int len = value.length();
        if (pattern.length() == 0 && len > 0) return false;
        if (len == 0 && (!pattern.contains("a") || !pattern.contains("b"))) return true;
        if (len == 0 && pattern.contains("a") && pattern.contains("b")) return false;
        char[] patterns = pattern.toCharArray();
        for (int i = 0; i <= len; i++) {
            outer:
            for (int j = 0; j <= len - i; j++) {
                String a = "", b = "", temp;
                int start = 0;
                for (char c : patterns) {
                    if (c == 'a') {
                        if (start + i > len) continue outer;
                        temp = value.substring(start, start + i);
                        if (a.length() == 0) a = temp;
                        else if (!a.equals(temp)) continue outer;
                        start += i;
                    }
                    if (c == 'b') {
                        if (start + j > len) continue outer;
                        temp = value.substring(start, start + j);
                        if (b.length() == 0) b = temp;
                        else if (!b.equals(temp)) continue outer;
                        start += j;
                    }
                    if (a.length() != 0 && b.length() != 0 && a.equals(b)) continue outer;
                }
                if (start == len) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetcodeInterview1618().patternMatching("aaaaab", "xahnxdxyaahnxdxyaahnxdxyaahnxdxyaauxuhuo"));
    }
}
