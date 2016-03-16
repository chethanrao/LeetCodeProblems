import java.io.BufferedReader;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*

 * Jumpstart

 */

/**

 * Class which will read input from the console, and call the appropriate

 * command.

 * 

 * @author interview

 */

public class JumpStart {

    /**

     * Input stream for commands

     */

    private BufferedReader input;

    HashSet<Component> hashSet= new HashSet<Component>();
    HashMap<String,Component> hashMap = new HashMap<String,Component>();

    /**

     * Output stream for results

     */

    private PrintStream output;

    /**

     * Creates a new CommandParser, sending input and output to the specified

     * locations

     * 

     * @param in

     *            input stream for commmands

     * @param out

     *            output stream for results

     */

    public JumpStart(InputStream in, PrintStream out) {

        input = new BufferedReader(new InputStreamReader(in));

        output = out;

    }

    /**

     * Processes a command from user. invalid commands are not printed, and

     * silently ignored. An invalid command includes a command which is missing

     * its argument. For example: "mkdir " is invalid.

     * 

     * @param line

     *            line of text representing the command string

     */

    public void processLine(String line) {

        String command;

        String argument;
        
        String[] str;
        boolean c;
        
        
        int i;
        
        Component c1;


        output.println("ECHO> " + line);
        
        if (line.contains("DEPEND")){
        	str=line.trim().replaceAll(" +", " ").split(" ");
        	
        	if (hashMap.containsKey(str[1]))
                 c1=hashMap.get(str[1]);
             else
        	     c1=new Component(str[1]);
        	
            
            hashMap.put(str[1],c1);
            Component c2;
           
            
            for (i=2;i<str.length;i++){
            	if (hashMap.containsKey(str[i]))
            		c2=hashMap.get(str[i]);
            	else 
            		c2= new Component(str[i]);
            	
            	c1.addDependentComponent(c2);
            	
                hashMap.put(str[i],c2);

             }
            
        }
        
        else if (line.contains("INSTALL")){
        	
        	str=line.trim().replaceAll(" +", " ").split(" ");
        	
        	c=false;
        			
        	if (hashMap.containsKey(str[1])){
        		c=hashMap.get(str[1]).installComponent();
        		if (c)
            		hashSet.add(hashMap.get(str[1]));
        	}
        	    
        	else{
        		c1=new Component(str[1]);
        		c=c1.installComponent();
        		if (c)
            		hashSet.add(c1);     	
        	}
        }
        else if (line.contains("REMOVE")){
        	str=line.trim().replaceAll(" +", " ").split(" ");
        	boolean t1=false;
        	if (hashMap.containsKey(str[1])){
        		t1=hashMap.get(str[1]).removeComponent();
        		if (t1)
            		hashSet.remove(hashMap.get(str[1]));	
            
        	}
        	else{
        		c1=new Component(str[1]);
        		t1=c1.removeComponent();
        		if (t1)
            		hashSet.remove(c1);	
        	}
        	}
        
        else if (line.contains("LIST")){
        	Component c2;
        	Iterator<Component> it = hashSet.iterator();        	
        	HashSet<Component> component = new HashSet();
            while(it.hasNext()){
               c2=it.next();
               if (!component.contains(c2)){
            	   System.out.println(c2.componentName);
    	   	       component.add(c2);
               }
               for (Component comp:c2.dependents){
            	   if (!component.contains(comp)){
            		   System.out.println(comp.componentName);
            	   	   component.add(comp);
                  
            	   }
               }

            }

        }
        

    }

    /**

     * Reads all commands from the input, and executes them

     * 

     * @throws IOException

     *             if a read error occurs while parsing commands

     */

    public void process() throws IOException {

        String line = input.readLine();

        while (line != null && line.length() > 0) {

            processLine(line);

            line = input.readLine();
            

        }

    }

    /**

     * Runs the parser on the supplied test data set. Expects a file in the

     * current working directory. Output is sent to stdout

     * 

     * @param args

     *            not used

     */

    public static void main(String[] args) {

        try {

            JumpStart parser = new JumpStart(new FileInputStream("C:\\Users\\qwerty\\workspace\\SalesForceTest\\src\\program.txt"), System.out);

            parser.process();

        } catch (Throwable t) {

            t.printStackTrace();

        }

    }

}