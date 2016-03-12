package SamplePrograms;

import java.util.HashSet;
import java.util.ArrayList;

class Person {
	String name;
	
	ArrayList<Person> friends;

	HashSet<Person> indirectfriends;
	
	Person(){
		this.name=null;
		this.friends=new ArrayList<Person>();
		
		this.indirectfriends=new HashSet<Person>();

	}
	
	Person(String name){
		this.name=name;
		this.friends=new ArrayList<Person>();
		
		this.indirectfriends=new HashSet<Person>();


	}
	
	void Person(String Name,ArrayList<Person> friends){
		this.name=name;
		this.friends=friends;
		
	}
	void addFriend(Person p){
	
		friends.add(p);
	}
	
	ArrayList<Person> getDirectFriends(){
		
		return friends;		
	}
	
	void removeFriends(Person p1){
		
	    friends.remove(p1);	  
	}
	
	ArrayList<Person> getIndirectFriends(){
		ArrayList<Person> inDirectFriends;
		
		
		if (indirectfriends.contains(this))
			return new ArrayList<Person>();
		
		
		for (Person per:friends){
		
			indirectfriends.addAll(per.friends);
			indirectfriends.addAll(per.getIndirectFriends());
			
		}
		indirectfriends.removeAll(this.getDirectFriends());
		
		indirectfriends.remove(this);
		
		inDirectFriends = new ArrayList<Person>(indirectfriends);
		
		return inDirectFriends;
		
	}
}
