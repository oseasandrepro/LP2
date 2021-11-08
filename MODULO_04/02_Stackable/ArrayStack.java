import java.util.*;
 
public class ArrayStack implements IStackable
{
	private ArrayList arr = new ArrayList();
	
	public int size(){
	    	return arr.size();
	}
	    
	public void push (int v){
	    	arr.add(v);
	}
	    
	public int  pop(){
	  int x;
	  int index = arr.size()-1;
	  if( index >=0)
	  {
	  	x = (int)arr.get( index );
	  	arr.remove(index);
	  	return x;
	  }
	  else
	  	return -1;
	}
	 
}
