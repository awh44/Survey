package InputOutput;
import java.util.Scanner;

public class ConsoleInputOutput extends InputOutput
{
	static Scanner input_;
	
	public ConsoleInputOutput()
	{
		input_ = new Scanner(System.in);
	}
	
	@Override
	public String getString()
	{
		return input_.nextLine();
	}
	
	@Override
	public int getIntInRange(int lower, int upper)
	{
		while (!input_.hasNextInt())
    	{
    		System.out.print("Please input a valid choice: ");
    		input_.next();
    	}
    	
    	int choice = input_.nextInt();
    	while ((choice < lower) || (choice > upper))
    	{
    		System.out.print("Please input a valid choice: ");
    		while (!input_.hasNextInt())
    		{
    			System.out.print("PLease input a valid chocie: ");
    			input_.next();
    		}
    		choice = input_.nextInt();
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
