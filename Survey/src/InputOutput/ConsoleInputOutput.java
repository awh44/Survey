package InputOutput;

import java.util.Scanner;
import java.util.Set;

public class ConsoleInputOutput extends InputOutput
{
	private static final long serialVersionUID = 1L;
	private static Scanner input_ = new Scanner(System.in).useDelimiter("\r\n");;
	
	@Override
	public String getString()
	{
		return input_.next();
	}
	
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
	
	public int getIntGreaterThan(int lower)
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
	public void putString(String output)
	{
		System.out.print(output);
	}

	@Override
	public void close()
	{
		input_.close();
	}
}
