import Survey.*;
import InputOutput.*;

public class MainMenu
{
    static Survey activeSurvey_;
    //static Test activeTest_;
    static boolean gradeable_;
    static InputOutput in_out_;

    public static void main(String[] args)
    {
    	activeSurvey_ = null;
    	gradeable_ = false;
    	in_out_ = new ConsoleInputOutput();
    	displayMenu();
    	while (get_executeChoice())
    	{
    		displayMenu();
    	}
    	
    	in_out_.close();
    }
    /**
     * 
     */
    public void display()
    {
        // implement here...
    }

    /**
     * 
     */
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
    					   "9.) Quit");
    }
    
    public static boolean get_executeChoice()
    {
    	int choice = in_out_.getIntInRange(1,  9);
    	switch (choice)
    	{
    		case 1:
    		case 2:	//fallthrough
    			newSurvey(choice);
    			break;
    		default:
    			in_out_.putString("Somehow still got an invalid choice. Good job!");
    	}
    	
    	return true;
    }
    
    public static void newSurvey(int type)
    {
    	if (type == 1)
    		activeSurvey_ = new Survey();
    	else if (type == 2)
    		activeSurvey_ = new Test();
    	else
    		return;
    }

    /**
     * 
     */
    public static void grade()
    {
        // implement here...
    }

    /**
     * 
     */
    public static void load()
    {
        // implement here...
    }

    /**
     * 
     */
    public static void modify() 
    {
        // implement here...
    }

    /**
     * 
     */
    public static void quit()
    {
        // implement here...
    }

    /**
     * 
     */
    public static void save()
    {
        // implement here...
    }

    /**
     * 
     */
    public void tabulate()
    {
        // implement here...
    }

    /**
     * 
     */
    public void take()
    {
        // implement here...
    }
}
