/*
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these two functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [1, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.*/

class MyHashSet {
    List<Integer>[] set=null;
    
    int MAX_SIZE=1000000;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        set=(List<Integer>[])new ArrayList[MAX_SIZE];
    }
  
    int getIndex(int key){
      int index=key%MAX_SIZE;
      return index;
    }
    
    int getPosition(int key,int index){
        List<Integer> list=set[index];
        
        if (list!=null)
            for (int i=0;i<list.size();i++){
                if (list.get(i)==key)
                    return i;
             }
        
        return -1;
    }
    
    void add(int key){
        int index=getIndex(key);
        List<Integer> list=set[index];
        
        if (list==null){
            set[index]=new ArrayList<Integer>();
            set[index].add(key);
            return;
        }

        int position=getPosition(key,index);
          
        if (position==-1)
            set[index].add(key);
    }
    
    void remove(int key){
        int index=getIndex(key);
        
        if (set[index]==null)
            return;

        int position=getPosition(key,index);       
        if (position!=-1){
            set[index].remove(position);
        }            
    }
    
    boolean contains(int key){
        int index=getIndex(key);
        int position=getPosition(key,index); 
        return position>=0;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
