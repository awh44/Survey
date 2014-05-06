package InputOutput;

import java.util.Scanner;
import java.util.Set;

public class ConsoleInputOutput extends InputOutput
{
	//data attributes-------------------------------
	private static Scanner input_ = new Scanner(System.in).useDelimiter("\r\n");
	private static final long serialVersionUID = 1L;
	
	//public methods--------------------------------
	@Override
	public void close()
	{
		input_.close();
	}
	
	@Override
	public int getInt()
	{
		while (!input_.hasNextInt())
    	{
    		errorInInput();
    		input_.next();
    	}
		return input_.nextInt();
	}
	
	@Override
	public int getIntGreaterThanEqualTo(int lower)
	{
		int choice = getInt();
		while (choice < lower)
		{
			errorInInput();
			choice = getInt();
		}
		return choice;
	}
	
	@Override
	public int getIntInRange(int lower, int upper)
	{	
    	int choice = getInt();
    	while ((choice < lower) || (choice > upper))
    	{
    		errorInInput();
    		choice = getInt();
    	}    	
    	return choice;
	}
	
	@Override
	public String getString()
	{
		return input_.next();
	}
	
	@Override
	public String getStringInSet(Set<String> set)
	{
		String input = getString();
		while (!set.contains(input))
		{
			errorInInput();
			input = getString();
		}
		return input;
	}
	
	@Override
	public String getStringShorterThanEqualTo(int length)
	{
		String input = getString();
		while (input.length() > length)
		{
			errorInInput();
			input = getString();
		}
		
		return input;
	}
	
	@Override
	public void putString(String output)
	{
		System.out.print(output);
	}
}
