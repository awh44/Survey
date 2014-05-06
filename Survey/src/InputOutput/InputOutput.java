package InputOutput;

import java.io.Serializable;
import java.util.Set;

abstract public class InputOutput implements Serializable
{
	//data attributes-------------------------------	
	private static final long serialVersionUID = 1L;
	
	//abstract methods------------------------------	
	abstract public String getString();
	abstract public String getStringShorterThanEqualTo(int length);
	abstract public String getStringInSet(Set<String> collection);
	abstract public int getIntInRange(int lower, int upper);
	abstract public int getIntGreaterThanEqualTo(int lower);
	abstract public int getInt();
	abstract public void putString(String output);
	abstract public void close();
	
	//protected methods-----------------------------	
	static protected void errorInInput()
	{
		System.out.print("Please input a valid choice: ");
	}
}