package org.example.code;

import org.example.code.helper.Interval;

import java.util.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MeetingRoom252.java
 * @Description
 * @createTime 2022年09月18日 13:41:00
 */

public class MeetingRoom252 {

    public static void main(String[] args) {
        MeetingRoom252 room = new MeetingRoom252();
    }

    //一维数组
    public boolean resovler(Interval[] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(Interval::getStart));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].getEnd() > intervals[i+1].getStart()){
                return false;
            }
        }
        return true;
    }

    //二维数组 @see LintCode 391
    public int meetingRoom253(int[][] intervals){
        //二维转一维
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0],1}); //开始时间，占用一个房间
            list.add(new int[]{interval[0],-1}); //结束时间，退一个房间
        }

        //排序 按照开始结束时间、开始结束(优先级高)操作排序
        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        //扫描排序好的list中每一个时间,计算出同时最大的会议数量，即满足条件的最小会议室数量
        int res = 0,cnt = 0;
        for (int[] point: list){
            cnt += point[1];//累计当前数量
            res = Math.max(res, cnt);
        }
        return res;

    }

    //合并多个interval,overlap合并
    public int[][] merge57(int[][] intervals){
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals[0].length == 0) return new int[0][];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] cur = intervals[0];
        for (int[] next: intervals){
            if (cur[1] >= next[0]){//当前end >= 后边的start，合并
                cur[1] = Math.max(cur[1],next[1]);//直接跨过start
            }else {
                res.add(cur);//直到找到不重叠的，说明该区域合并完成
                cur = next;
            }
        }
        res.add(cur);//收集循环结束，但是没进else的，比如只有一个元素，或所有元素都重叠
        return res.toArray(new int[0][]);
    }
}
