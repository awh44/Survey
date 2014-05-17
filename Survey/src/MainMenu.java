import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.ClassCastException;

import InputOutput.ConsoleInputOutput;
import InputOutput.InputOutput;
import Survey.Survey;
import Survey.Test;

public class MainMenu
{
    static Survey activeSurvey_;
    static Test activeTest_;
    static InputOutput in_out_;
    static boolean survey_unsaved;
    static boolean test_unsaved;

    public static void main(String[] args)
    {
    	activeSurvey_ = null;
    	survey_unsaved = false;
    	activeTest_ = null;
    	test_unsaved = false;
    	in_out_ = new ConsoleInputOutput();
    	displayMenu();
    	while (get_executeChoice())
    	{
    		displayMenu();
    	}
    	
    	in_out_.close();
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
    	//note that case 9 has a return false statement
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
    			survey_unsaved = save(activeSurvey_);
    			break;
    		case 8:
    			test_unsaved = save(activeTest_);
    			break;
    		case 9:
    			quit();
    			return false;
    		default:
    			in_out_.putString("Somehow still got an invalid choice. Good job!\n");
    	}
    	
    	return true;
    }
    
    public static void newSurvey()
    {
    	if (survey_unsaved)
    	{
    		in_out_.putString("Would you like to save your active Survey first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			survey_unsaved = save(activeSurvey_);
    	}
    	activeSurvey_ = new Survey();
    	survey_unsaved = true;
    }
    
    public static void newTest()
    {
    	if (test_unsaved)
    	{
    		in_out_.putString("Would you like to save your active Test first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			test_unsaved = save(activeTest_);
    	}
    	activeTest_ = new Test();
    	test_unsaved = true;
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

    public static void loadSurvey()
    {
    	if (survey_unsaved)
    	{
    		in_out_.putString("Would you like to save your active Survey first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			survey_unsaved = save(activeSurvey_);
    	}
    	
    	in_out_.putString("What is the path to the Survey you would like to load?\n");
    	String path = in_out_.getString();
    	try
        {
           FileInputStream inFile = new FileInputStream(path);
           ObjectInputStream in = new ObjectInputStream(inFile);
           activeSurvey_ = (Survey) in.readObject();
           in.close();
           inFile.close();
           in_out_.putString("Loaded succesfully.\n");
           survey_unsaved = false;
        }
    	catch (IOException i)
        {
           in_out_.putString("Error in I/O while trying to load. Please check the file path.\n");
        }
    	catch (ClassNotFoundException c)
        {
           in_out_.putString("Error in finding the Survey class. Please try again.\n");
        }
    	catch (ClassCastException e)
    	{
    		in_out_.putString("Could not cast to a Survey from that input file.\n");
    	}
    	
    	in_out_.putString("\n");
    }

    public static void loadTest()
    {
    	if (test_unsaved)
    	{
    		in_out_.putString("Would you like to save your active Test first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			test_unsaved = save(activeTest_);
    	}
    	
    	in_out_.putString("What is the path to the Test you would like to load?\n");
    	String path = in_out_.getString();
    	try
        {
           FileInputStream inFile = new FileInputStream(path);
           ObjectInputStream in = new ObjectInputStream(inFile);
           activeTest_ = (Test) in.readObject();
           in.close();
           inFile.close();
           in_out_.putString("Loaded succesfully.\n");
           test_unsaved = false;
        }
    	catch (IOException i)
        {
           in_out_.putString("Error in I/O while trying to load. Please check the file path.\n");
        }
    	catch (ClassNotFoundException c)
        {
           in_out_.putString("Error in finding the Survey class. Please try again.\n");
        }
    	catch (ClassCastException e)
    	{
    		in_out_.putString("Could not cast to a Test from that input file.\n");
    	}
    	
    	in_out_.putString("\n");
    }
    public static void modifySurvey() 
    {
        
    }

    public static void quit()
    {
    	if (survey_unsaved)
    	{
    		in_out_.putString("Would you like to save your active Survey first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			survey_unsaved = save(activeSurvey_);
    	}
    	
    	if (test_unsaved)
    	{
    		in_out_.putString("Would you like to save your active Test first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			test_unsaved = save(activeTest_);
    	}
    }


    public static boolean save(Survey survey)
    {
    	if (survey == null)
    	{
    		in_out_.putString("No active one to save.\n\n");
    		return false;
    	}
    	
    	in_out_.putString("Where and under what name would you like to save it?\n");
    	String path = in_out_.getString();
    	try
        {
           FileOutputStream outFile = new FileOutputStream(path);
           ObjectOutputStream out = new ObjectOutputStream(outFile);
           out.writeObject(survey);
           out.close();
           outFile.close();
           in_out_.putString("Saved successfully.\n\n");
           return false;
        }
    	catch(IOException i)
        {
            in_out_.putString("Error when trying to save. Check file path.\n\n");
            return true;
        }
    }
    
    public static void grade()
    {
        
    }

    public void tabulate(Survey survey)
    {
    	
    }

    public void take(Survey survey)
    {
    	
    }
}
