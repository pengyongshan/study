package com.tree.www.leetCode;

/**
 * 71. 简化路径
 * <p>
 * Created by pysh on 2020-03-10.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

    public static String simplifyPath(String path) {
        StringBuilder reslut = new StringBuilder();
        String[] paths = path.split("/");
        for (int i = 0, len = paths.length; i < len; i++) {
            if (paths[i].equals(".")) {
                paths[i] = "";
            }
            if (paths[i].equals("..")) {
                paths[i] = "";
                for (int j = i - 1; j >= 0; j--) {
                    if(!paths[j].equals("")) {
                        paths[j] = "";
                        break;
                    }
                }
            }
        }
        for (String path1 : paths) {
            if (path1.equals("")) {
                continue;
            }
            reslut.append("/").append(path1);
        }
        if(reslut.length() == 0) {
            return "/";
        }
        return reslut.toString();
    }
}
