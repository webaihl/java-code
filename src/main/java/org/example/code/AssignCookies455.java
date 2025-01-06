package org.example.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author web
 * @date 2022年08月26日
 */
public class AssignCookies455 {

    public static void main(String[] args) {
        System.out.println(new AssignCookies455().findContentChildren(new int[]{1, 3}, new int[]{1, 2, 4}));
        int[][] s = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(new AssignCookies455().eraseOverlapIntervals(s));
        s = new int[][]{{10, 16}, {2, 8}, {1, 6},{7,12}};
        System.out.println(new AssignCookies455().findMinArrowShots(s));
    }

    public int findContentChildren(int[] grid, int[] size) {
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[1]));
        int end = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt - 1;
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(e->e[1]));
        int end = points[0][1], cnt = 0;
        for (int[] point : points) {
            if (point[0] <= end) {
                continue;
            }
            end = point[1];
            cnt++;
        }

        return points.length - cnt - 1;
    }

}
