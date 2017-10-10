package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/submissions/detail/116073280/
 * 方法一: 不预先排序,简单的思路，O(n2)
 * 方法二：预先排序后,只需要遍历一次
 */
public class MergeIntervals {



    private static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
          public String toString(){

              return "start: "+start+","+"end: "+end;

          }
    }



    public static void main(String args []){
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(2,6));
        input.add(new Interval(8,10));
        input.add(new Interval(15,18));
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> result = mergeIntervals.mergeWithSort(input);
        for(Interval interval :result){
            System.out.println(interval.toString());
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        int i=0;
        //对于每一个interval
        while(i<intervals.size()){
           boolean hasJoined = false;

           //寻找可能的合并项,然后合并
            for(int j=i+1;j<intervals.size();j++){
                if(isJoinedWithNext(intervals,i,j)){
                    hasJoined = true;
                    int start = Math.min(intervals.get(i).start , intervals.get(j).start);
                    int end = Math.max(intervals.get(i).end , intervals.get(j).end);
                    Interval merge = new Interval(start , end);
                    //注意下标
                    intervals.remove(i); intervals.remove(j-1);
                    intervals.add(i,merge);
                }
            }
            if(hasJoined){
                i--;
            }
            i++;
        }

        return intervals;
    }

    private boolean isJoinedWithNext(List<Interval> intervals , int i , int j){
        if(i>=intervals.size()-1){
            return false;
        }
        Interval cur = intervals.get(i);
        Interval other = intervals.get(j);
        if(cur.start>=other.start && cur.start <= other.end || cur.end >= other.start && cur.end <= other.end
                || other.start >=cur.start && other.start<=cur.end || other.end >=cur.start && other.end <= cur.end){
            return true;
        }

        return  false;
    }


    public List<Interval> mergeWithSort(List<Interval> intervals){
        if(intervals.size()<=1){
            return  intervals;
        }

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start,o2.start);
            }
        });

        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i=1;i<intervals.size();i++){
            Interval temp = intervals.get(i);
            //待合并
            if(end >= temp.start){
                end = Math.max(end,temp.end);
            }else{
                result.add(new Interval(start,end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }

        result.add(new Interval(start,end));
        return  result;
    }
}
