/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

class MergeLists {
    public ListNode mergeKLists(ListNode[] lists) {
    
        if (lists.length==0)
		    return null;

	    if (lists.length==1)
		    return lists[0];
	
        int interval=1;
    
        while (interval<lists.length){
              int i;
              for (i=0;(i+interval)<lists.length;i=i+(interval*2)){         
 	              lists[i]=getMergedList(lists[i],lists[i+interval]);
	       }
              interval=interval*2;
        }
        
	    return lists[0];
    }
     
    ListNode getMergedList(ListNode list1,ListNode list2){

            ListNode mergedNode =new ListNode(0);
            ListNode origNode=mergedNode;
	    ListNode templist1=list1;
	    ListNode templist2=list2;
		
	    while (templist1!=null && templist2!=null){
		
            if (templist1.val<templist2.val){
		mergedNode.next=templist1;
	        mergedNode= mergedNode.next;
	        templist1=templist1.next;
		}	
	     else {
		 mergedNode.next=templist2;
	         mergedNode=mergedNode.next;
                 templist2=templist2.next;
	      }

	}
    
    if (templist1==null)
        mergedNode.next=templist2;
    else
        mergedNode.next=templist1;
        
	return origNode.next;
    }
}
