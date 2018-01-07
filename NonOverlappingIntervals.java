/*
We are given a list avail of employees, which represents the free time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

Example 1:
Input: avails = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:
Input: avails = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, avails[0][0].start = 1, avails[0][0].end = 2, and avails[0][0][0] is not defined.)

Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

Note:

avails and avails[i] are lists with lengths in range [1, 50].
0 <= avails[i].start < avails[i].end <= 10^8.*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class NonOverlappingIntervals {
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> intervals=new ArrayList<Interval>();
        
        for (List<Interval> list:avails){
            intervals.addAll(list);
        }
        
        
     Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) return o1.start - o2.start;  //first sort by start
                return o1.end - o2.end;  //sort by end if starts are equal
            }
        });

 
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        
        List<Interval> finalList=new ArrayList<Interval>();
        
        for (int i=1;i<intervals.size();i++){
            int start1=intervals.get(i).start;
            int end1=intervals.get(i).end;
            
            if (start1>end){
                Interval interval=new Interval(end,start1);
                finalList.add(interval);
                start=start1;
                end=end1;
                
            }
            else {
                start=Math.min(start1,start);
                
                end=Math.max(end1,end);
                
            }
                           
        }
        
        return finalList;
    }
     
}
