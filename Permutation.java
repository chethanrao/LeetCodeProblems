package javaproject;

public class Permutation {

	public static void permutate(StringBuilder s,int k){
		char c;


		if (k==s.length()-1){
			System.out.println(s);
		}
		else
		{
			for (int i=k;i<s.length();i++){
				if (s.charAt(i)==s.charAt(k) && k!=i)
					continue;
				c=s.charAt(k);
				s.setCharAt(k, s.charAt(i));
				s.setCharAt(i, c);

				permutate(s,k+1);

				c=s.charAt(k);
				s.setCharAt(k, s.charAt(i));
				s.setCharAt(i, c);			}
		}
	}

	public static void main(String[] args){

		permutate(new StringBuilder("aabbccddee"),0);
	}

}
