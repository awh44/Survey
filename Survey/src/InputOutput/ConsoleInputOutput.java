//package InputOutput;
//
//import java.util.Scanner;
//import java.util.Set;
//
//public class ConsoleInputOutput extends InputOutput
//{
//	//data attributes-------------------------------
//	private static Scanner input_ = new Scanner(System.in).useDelimiter(String.format("%n"));
//	private static final long serialVersionUID = 1L;
//	
//	//public methods--------------------------------
//	@Override
//	public void close()
//	{
//		input_.close();
//	}
//	
//	@Override
//	public int getInt()
//	{
//		while (!input_.hasNextInt())
//		{
//    		
//    		input_.next();
//		}
//		return input_.nextInt();
//	}
//	
//	@Override
//	public int getIntGreaterThanEqualTo(int lower)
//	{
//		int choice = getInt();
//		while (choice < lower)
//		{
//			
//			choice = getInt();
//		}
//		return choice;
//	}
//	
//	@Override
//	public int getIntInRange(int lower, int upper)
//	{	
//		int choice = getInt();
//		while ((choice < lower) || (choice > upper))
//		{
//			
//			choice = getInt();
//		}    	
//		return choice;
//	}
//	
//	@Override
//	public String getString()
//	{
//		String input = input_.next();
//		while (input.equals(""))
//		{
//			
//			input = input_.next();
//		}
//		return input;
//	}
//	
//	@Override
//	public String getStringInSet(Set<String> set)
//	{
//		String input = getString();
//		while (!set.contains(input))
//		{
//			
//			input = getString();
//		}
//		return input;
//	}
//	
//	@Override
//	public String getStringShorterThanEqualTo(int length)
//	{
//		String input = getString();
//		while (input.length() > length)
//		{
//			
//			input = getString();
//		}
//		
//		return input;
//	}
//	
//	@Override
//	public void putString(String output)
//	{
//		System.out.print(output);
//	}
//}
