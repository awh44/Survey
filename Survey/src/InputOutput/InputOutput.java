package InputOutput;

import java.io.Serializable;

import java.util.Set;

abstract public class InputOutput implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	abstract public String getString();
	abstract public String getStringInSet(Set<String> collection);
	abstract public int getIntInRange(int lower, int upper);
	abstract public int getInt();
	abstract public void putString(String output);
	abstract public void close();
	static protected void errorInInput()
	{
		System.out.print("Please input a valid choice: ");
	}
}