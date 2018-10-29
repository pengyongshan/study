package com.tree.www.algorithm;

/**
 * Created by pysh on 2018/10/26.
 */
public class MaxPoint {
    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(4, 0),
                new Point(4, -1),
                new Point(4, 5)
        };
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(Point[] points) {
        int length = points.length;
        if (length <= 2) {
            return length;
        }
        int max = 2;
        for (int i = 0; i < points.length; i++) {
            int samePosition = 0; //重复位置的点 个数
            int sameSlope = 1;    //斜率相同的点 个数
            for (int j = i + 1; j < points.length; j++) {
                //判断是否为重复位置的点
                long x1 = points[j].x - points[i].x;
                long y1 = points[j].y - points[i].y;
                if (x1 == 0 && y1 == 0) {
                    samePosition++;
                } else {
                    sameSlope++;//第二个点，所以可以直接++
                    for (int k = j + 1; k < points.length; k++) {
                        long x2 = points[k].x - points[i].x;
                        long y2 = points[k].y - points[i].y;

                        if (x1 * y2 == x2 * y1) {
                            sameSlope++;
                        }
                    }
                }
                if (max < (samePosition + sameSlope)) {
                    max = samePosition + sameSlope;
                }
                sameSlope = 1;
            }
        }
        return max;
    }
}


class Point {
    int x;
    int y;

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
