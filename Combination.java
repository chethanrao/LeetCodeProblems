package javaproject;


public class Combination {

	public static void combinate(StringBuilder s){
		int k=1,temp,index;
		
		while (k<Math.pow(2,(double)s.length())){
			temp=k;
			index=0;
			while (temp!=0){
				index++;
				if (temp%2==1){
					System.out.print(s.charAt(index-1));
				}
				temp=temp/2;
			}
			System.out.println();
			k++;			
		}
	}

	public static void main(String[] args){
        //assumption is there are no duplicates,if there are duplicates remove using some datastructure like set
		combinate(new StringBuilder("abcde"));
	}

}
