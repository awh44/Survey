package InputOutput;
import java.util.Scanner;

public class ConsoleInputOutput extends InputOutput
{
	static Scanner input_ = new Scanner(System.in).useDelimiter("\r\n");;
	
	@Override
	public String getString()
	{
		return input_.next();
	}
	
	public int getInt()
	{
		while (!input_.hasNextInt())
    	{
    		System.out.print("Please input a valid choice: ");
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
    		System.out.print("Please input a valid choice: ");
    		choice = getInt();
    		input_.next();
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
