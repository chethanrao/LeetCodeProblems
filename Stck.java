import java.util.Arrays;


/*Implementation of Stack in Java*/

public class Stck<E>{
	private int size=10;
	private Object[] arr=null;
	private int index=0;
	
  	public Stck(){
     		arr=new Object[size];
        }
	
	public void push(Object o){
		
		if (index>=size)
			increaseSize();
		arr[index++]=o;
	}
	
	public Object pop(){
		
		if (index==0){
			System.out.println("Stack is empty");
			return null;
		}
		return arr[--index];
	}
	
	public Object peek(){
		
		if (index==0){
			System.out.println("Stack is empty");
			return null;
		}
		return arr[index-1];
	}
	
	public int size(){
		return index;
	}
	
	public boolean isEmpty(){
		return index==0;
	}
	
	public void increaseSize(){
		size=size*2;
		Arrays.copyOf(arr,size);
	}
}
