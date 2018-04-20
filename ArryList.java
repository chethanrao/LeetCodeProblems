import java.util.Arrays;
/* Implementation of array list in java*/

public class ArryList<E>{
	Object[] arr=null;
	int index=0;
	int size=10;
	public ArryList(){
		arr=new Object[size];
	}
	public void add(E e){
		if (index>=arr.length)
			inceaseSize();
		arr[index++]=e;
	}
	
	public void remove(E e){
		int i;
		for (i=0;i<index;i++){
			if (arr[i]==e){
				break;

			}
		}
		
		if (i!=index){
			while (i<index-1){
				arr[i]=arr[i+1];
            			i++;
			}
			index--;
		}

	
	}
       
	@SuppressWarnings("unchecked")
	public E get(int k) {
		if (k>=index){
			throw new ArrayIndexOutOfBoundsException("Index out of range");
		}
		else
		    return (E)arr[k];
	}
	
	public void inceaseSize(){
		int newsize=arr.length*2;
		arr=Arrays.copyOf(arr,newsize);
	}
	
}
