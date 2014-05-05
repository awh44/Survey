import Survey.*;
import InputOutput.*;

public class MainMenu
{
    static Survey activeSurvey_;
    static Test activeTest_;
    static InputOutput in_out_;

    public static void main(String[] args)
    {
    	activeSurvey_ = null;
    	activeTest_ = null;
    	in_out_ = new ConsoleInputOutput();
    	displayMenu();
    	while (get_executeChoice())
    	{
    		displayMenu();
    	}
    	
    	in_out_.close();
    }

    public static void displaySurvey()
    {
    	if (activeSurvey_ != null)
    	{
    		activeSurvey_.display();
    	}
    	else
    	{
    		in_out_.putString("Please either create or load a Survey first.\n");
    	}
        	
        in_out_.putString("\n");
    }
    
    public static void displayTest()
    {
    	if (activeTest_ != null)
    	{
    		activeTest_.display();
    	}
    	else
    	{
    		in_out_.putString("Please either create or load a Test first.\n");
    	}
    	
    	
    	in_out_.putString("\n");
    }

    public static void displayMenu()
    {
    	in_out_.putString("Please choose an action.\n" +
    					   "1.) Create a new Survey\n" +
    					   "2.) Create a new Test\n" + 
    					   "3.) Display a Survey\n" +
    					   "4.) Display a Test\n" + 
    					   "5.) Load a Survey\n" +
    					   "6.) Load a Test\n" +
    					   "7.) Save a Survey\n" +
    					   "8.) Save a Test\n" +
    					   "9.) Quit\n");
    }
    
    public static boolean get_executeChoice()
    {
    	int choice = in_out_.getIntInRange(1, 9);
    	in_out_.putString("\n");
    	switch (choice)
    	{
    		case 1:
    			newSurvey();
    			break;
    		case 2:
    			newTest();
    			break;
    		case 3:
    			displaySurvey();
    			break;
    		case 4:
    			displayTest();
    			break;
    		case 5:
    			loadSurvey();
    			break;
    		case 6:
    			loadTest();
    			break;
    		case 7:
    			saveSurvey();
    			break;
    		case 8:
    			saveTest();
    			break;
    		case 9:
    			quit();
    			return false;
    		default:
    			in_out_.putString("Somehow still got an invalid choice. Good job!");
    	}
    	
    	return true;
    }
    
    public static void newSurvey()
    {
    	activeSurvey_ = new Survey();
    }
    
    public static void newTest()
    {
    	activeTest_ = new Test();
    }

    public static void grade()
    {
        
    }

    public static void loadSurvey()
    {
        
    }

    public static void loadTest()
    {
    	
    }
    public static void modifySurvey() 
    {
        
    }

    public static void quit()
    {
        
    }


    public static void saveSurvey()
    {
    	
    }
    
    public static void saveTest()
    {
    	
    }

    public void tabulate()
    {
    	
    }

    public void take()
    {
    	
    }
}
