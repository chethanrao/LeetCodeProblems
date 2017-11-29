/*
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
*/

class RandomizedSet {
    
    int length;
    
    ArrayList<Integer> list=null;
    
    HashMap<Integer,Integer> hashMap=null;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list=new ArrayList<Integer>();
        length=0;
        hashMap=new HashMap<Integer,Integer>();     
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!hashMap.containsKey(val)){
         if (list.size()==length){
          list.add(val);
          hashMap.put(val,length);
          length++;
         }
         else {
          list.set(length,val);
          hashMap.put(val,length);
          length++; 
         }


          return true;
               

        }
        else
         return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (hashMap.containsKey(val)){
            int index=hashMap.get(val);  
            hashMap.remove(val);
            if (hashMap.size()!=0){
                list.set(index,list.get(length-1));
                hashMap.put(list.get(length-1),index);
            }
            length--;
        

            return true; 
        }
        return false;
          
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
         Random rand=new Random();
        int k;
        if (length>0)
         k=rand.nextInt(length);
        else k=0;
       

         return list.get(k);
    }
}
