import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import InputOutput.ConsoleInputOutput;
import InputOutput.InputOutput;
import Survey.Survey;
import Survey.Test;

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

    public static void display(Survey survey)
    {
    	if (survey != null)
    	{
    		survey.display();
    	}
    	else
    	{
    		in_out_.putString("Please either create or load one first.\n");
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
    			display(activeSurvey_);
    			break;
    		case 4:
    			display(activeTest_);
    			break;
    		case 5:
    			loadSurvey();
    			break;
    		case 6:
    			loadTest();
    			break;
    		case 7:
    			save(activeSurvey_);
    			break;
    		case 8:
    			save(activeTest_);
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
    	in_out_.putString("What is the path to the Survey you would like to load?\n");
    	String path = in_out_.getString();
    	try
        {
           FileInputStream inFile = new FileInputStream(path);
           ObjectInputStream in = new ObjectInputStream(inFile);
           activeSurvey_ = (Survey) in.readObject();
           in.close();
           inFile.close();
        }
    	catch(IOException i)
        {
           in_out_.putString("Error in I/O while trying to load. Please check the file path.\n");
           return;
        }
    	catch(ClassNotFoundException c)
        {
           System.out.println("Error in finding the Survey class. Please try again.");
           return;
        }
    }

    public static void loadTest()
    {
    	in_out_.putString("What is the path to the Test you would like to load?\n");
    	String path = in_out_.getString();
    	try
        {
           FileInputStream inFile = new FileInputStream(path);
           ObjectInputStream in = new ObjectInputStream(inFile);
           activeTest_ = (Test) in.readObject();
           in.close();
           inFile.close();
        }
    	catch(IOException i)
        {
           in_out_.putString("Error in I/O while trying to load. Please check the file path.\n");
        }
    	catch(ClassNotFoundException c)
        {
           System.out.println("Error in finding the Survey class. Please try again.");
        }
    }
    public static void modifySurvey() 
    {
        
    }

    public static void quit()
    {
        
    }


    public static void save(Survey survey)
    {
    	if (survey == null)
    		return;
    	
    	in_out_.putString("Where would you like to save your Survey?");
    	String path = in_out_.getString();
    	try
        {
           FileOutputStream outFile = new FileOutputStream(path);
           ObjectOutputStream out = new ObjectOutputStream(outFile);
           out.writeObject(survey);
           out.close();
           outFile.close();
        }
    	catch(IOException i)
        {
            in_out_.putString("Error when trying to save. Check file path.");
        }
    }

    public void tabulate(Survey survey)
    {
    	
    }

    public void take(Survey survey)
    {
    	
    }
}
