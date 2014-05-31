package InputOutput;

import java.io.Serializable;
import java.util.Set;

public class InputOutput implements Serializable
{
	//data attributes-------------------------------	
	private static final long serialVersionUID = 1L;
	private Input input_;
	private Output output_;
	
	//Constructor-----------------------------------
	public InputOutput(Input input, Output output)
	{
		input_ = input;
		output_ = output;
		input_.setOutput(output_);
	}
	
	//public methods------------------------------	
	public String getString()
	{
		return input_.getString();
	}
	
	public String getStringShorterThanEqualTo(int length)
	{
		return input_.getStringShorterThanEqualTo(length);
	}
	
	public String getStringInSet(Set<String> collection)
	{
		return input_.getStringInSet(collection);
	}
	
	public int getIntInRange(int lower, int upper)
	{
		return input_.getIntInRange(lower, upper);
	}
	
	public int getIntGreaterThanEqualTo(int lower)
	{
		return getIntGreaterThanEqualTo(lower);
	}
	
	public int getInt()
	{
		return input_.getInt();
	}
	
	public void putString(String output)
	{
		output_.putString(output);
	}
	
	public void close()
	{
		input_.close();
		output_.close();
	}
}