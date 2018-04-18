/*Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these two functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All values will be in the range of [1, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.*/

class MyHashMap {
    List<List<Integer>>[] set=null;
    int MAX_SIZE=10000;

    /** Initialize your data structure here. */
    public MyHashMap() {
        set=(List<List<Integer>>[])new ArrayList[MAX_SIZE];        
    }
    
    int getIndex(int key){
        return key%MAX_SIZE;
    }
    
    int getPosition(int key,int index){ 
        List<List<Integer>> list=set[index];
        
        if (list==null)
            return -1;
        
        for (int i=0;i<list.size();i++){
            if (list.get(i).get(0).equals(key))
                return i;
        }
        return -1;
    }
    
    /** value will always be positive. */
    public void put(int key, int value) {
        int index=getIndex(key);
        
        List<List<Integer>> list=set[index];
        
        if (list==null){
        	set[index]=new ArrayList<List<Integer>>();
            List<Integer> newList=new ArrayList<Integer>();
            newList.add(key);
            newList.add(value);
            set[index].add(newList);
            return;
        }
            
        int position=getPosition(key,index);
        
        if (position==-1){
            List<Integer> newList=new ArrayList<Integer>();
            newList.add(key);
            newList.add(value);
            list.add(newList);
        }
        else {
            List<Integer> currList=list.get(position);
            if (currList.get(1)!=value)
                currList.set(1,value);
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getIndex(key);
        int position=getPosition(key,index);
        
        if (set[index]==null || position==-1)
            return -1;
        else
            return set[index].get(position).get(1);


    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=getIndex(key);
        int position=getPosition(key,index);
        if (position!=-1)
            set[index].remove(position);
    }
    

}

