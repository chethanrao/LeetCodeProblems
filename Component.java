import java.util.HashSet;

class Component {
	
	String componentName;

	HashSet<Component> dependents;
	
	boolean isInstalled;
	
	HashSet<Component> parentcomponents;
	
	
	Component(){
		componentName="";
		
		this.dependents=new HashSet<Component>();
		
		
		this.isInstalled=false;
		
	}
	
	Component(String name){
		this.componentName=name;
		
		this.dependents=new HashSet<Component>();
		
		this.parentcomponents = new HashSet<Component>();
		
		this.isInstalled=false;
		
	}

	Component(String name,HashSet<Component> component,boolean isInstalled){
		componentName="";
		
		dependents=new HashSet<Component>();
		
		parentcomponents = new HashSet<Component>();
		
		isInstalled=false;
		
	}
	
	void addDependentComponent(Component c){
	
		if (c.dependents.contains(this) || this.parentcomponents.contains(c)){
			System.out.println(c.componentName+" depends on "+this.componentName +" Ignoring command");
		    return;
		}
		
		
		dependents.add(c);

		c.addParentComponent(this);

	}
	
	
	void addParentComponent(Component c){
		parentcomponents.add(c);
	}
	
	
	
	void removeParentComponent(Component c){
		parentcomponents.remove(c);
	}
	

	boolean installComponent(){
		if (this.isInstalled){
			System.out.println(this.componentName + " is already installed");
			return false;
			
		}
		
		for (Component c:this.dependents){
			if (c.isInstalled)
		    	continue;
			c.addParentComponent(this);
	    	System.out.println("Instaling "+c.componentName);
	    	c.isInstalled=true;
		}
	    if (!this.isInstalled)
	    	System.out.println("Instaling "+this.componentName);
		
		
		this.isInstalled=true;
		
		return true;
		
	}
	boolean removeComponent(){
		
		if (!this.isInstalled){
		    System.out.println(this.componentName+" is not installed");
			return false;
		}
		
		if (this.isInstalled && this.parentcomponents.size()==0){
			System.out.println("Removing:"+this.componentName);
		    this.isInstalled=false;
		    for (Component c:this.dependents){
  		    	c.removeParentComponent(this);
		    	if (c.isInstalled && c.parentcomponents.size()==0){
				  System.out.println("Removing:"+c.componentName);
			      c.isInstalled=false;

		    	}
		    	else{
					if (this.parentcomponents.size()>1)
						System.out.println(this.componentName+" is still needed");    		
		    	}
		    		
		    }
		    
		    return true;	
		}
		else{
			if (this.parentcomponents.size()>0)
				System.out.println(this.componentName+" is still needed");
			return false;		
		}
			
	}
	
}