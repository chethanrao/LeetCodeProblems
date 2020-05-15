/*
Interval List Intersections
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/
class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> listOfIntersections=new ArrayList<int[]>();
        int index1=0;
        int index2=0;
        while (index1<A.length && index2<B.length){
                if (isIntersecting(A[index1][0],A[index1][1],B[index2][0],B[index2][1])){           
                    listOfIntersections.add(new int[]{Math.max(A[index1][0],B[index2][0]),Math.min(A[index1][1],B[index2][1])});
                }
                if (A[index1][1]<B[index2][1]) {
                    index1++;
                }            
                else if (A[index1][1]>B[index2][1]){
                    index2++;
                }
                else {
                    index1++;
                    index2++;
                }
            
        }
        return listOfIntersections.toArray(new int[listOfIntersections.size()/2][2]);

    }
    
    public boolean isIntersecting(int start1,int end1,int start2,int end2){
        if (start1<=Math.max(start1,start2) && start2<=Math.max(start1,start2) && end1>=Math.min(end1,end2) && end2>=Math.min(end1,end2) && Math.min(end1,end2)>=Math.max(start1,start2)){
            return true;
        }
        else {
            return false;
        }
    }

}
