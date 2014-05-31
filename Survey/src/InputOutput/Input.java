package InputOutput;

import java.io.Serializable;
import java.util.Set;

abstract public class Input implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Output output_;
	
	abstract public String getString();
	abstract public String getStringShorterThanEqualTo(int length);
	abstract public String getStringInSet(Set<String> collection);
	abstract public int getIntInRange(int lower, int upper);
	abstract public int getIntGreaterThanEqualTo(int lower);
	abstract public int getInt();
	abstract public void close();
	
	public void setOutput(Output output)
	{
		output_ = output;
	}
	
	protected void errorInInput()
	{
		output_.putString("Please input a valid choice: ");
	}
}
