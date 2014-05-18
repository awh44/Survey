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
    static boolean surveyUnsaved_;
    static String surveyPath_;
    static boolean testUnsaved_;
    static String testPath_;

    public static void main(String[] args)
    {
    	activeSurvey_ = null;
    	surveyUnsaved_ = false;
    	activeTest_ = null;
    	testUnsaved_ = false;
    	in_out_ = new ConsoleInputOutput();
    	displayMenu();
    	while (get_executeChoice())
    	{
    		in_out_.putString("\n");
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
    					  "9.) Modify an existing Survey.\n" +
    					  "10.) Modify an existing Test\n" +
    					  "11.) Take a Survey\n" +
    					  "12.) Take a Test\n" +
    					  "13.) Grade a Test\n" +
    					  "14.) Tabulate a Survey\n" +
    					  "15.) Tabulate a Test\n" +
    					  "16.) Quit\n");
    }
    
    public static boolean get_executeChoice()
    {
    	int choice = in_out_.getIntInRange(1, 16);
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
    			surveyUnsaved_ = save(activeSurvey_, surveyPath_);
    			break;
    		case 8:
    			testUnsaved_ = save(activeTest_, testPath_);
    			break;
    		case 9:
    			modify(activeSurvey_);
    			break;
    		case 10:
    			modify(activeTest_);
    			break;
    		case 11:
    			take(activeSurvey_);
    			save(activeSurvey_, surveyPath_);
    			break;
    		case 12:
    			take(activeTest_);
    			save(activeTest_, testPath_);
    			break;
    		case 13:
    			grade();
    			break;
    		case 14:
    		case 15:
    			return true;    	
    		case 16:
    			quit();
    			return false;
    		default:
    			in_out_.putString("Somehow still got an invalid choice. Good job!\n");
    	}
    	
    	return true;
    }
    
    public static void newSurvey()
    {
    	if (surveyUnsaved_)
    	{
    		in_out_.putString("Would you like to save your active Survey first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			surveyUnsaved_ = save(activeSurvey_, surveyPath_);
    	}
    	activeSurvey_ = new Survey();
    	surveyUnsaved_ = true;
    }
    
    public static void newTest()
    {
    	if (testUnsaved_)
    	{
    		in_out_.putString("Would you like to save your active Test first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			testUnsaved_ = save(activeTest_, testPath_);
    	}
    	activeTest_ = new Test();
    	testUnsaved_ = true;
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
    	if (surveyUnsaved_)
    	{
    		in_out_.putString("Would you like to save your active Survey first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			surveyUnsaved_ = save(activeSurvey_, surveyPath_);
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
           surveyUnsaved_ = false;
           surveyPath_ = path;
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
    	if (testUnsaved_)
    	{
    		in_out_.putString("Would you like to save your active Test first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			testUnsaved_ = save(activeTest_, testPath_);
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
           testUnsaved_ = false;
           testPath_ = path;
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
    public static void modify(Survey survey) 
    {
    	if (survey == null)
    	{
    		in_out_.putString("There is no active one.\n\n");
    		return;
    	}
        survey.modify();
    }

    public static void quit()
    {
    	if (surveyUnsaved_)
    	{
    		in_out_.putString("Would you like to save your active Survey first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    		{
    			surveyUnsaved_ = save(activeSurvey_, surveyPath_);
    		}
    	}
    	
    	if (testUnsaved_)
    	{
    		in_out_.putString("Would you like to save your active Test first? (Input 1 for yes, 0 for no.)\n");
    		int choice = in_out_.getIntInRange(0, 1);
    		if (choice == 1)
    			testUnsaved_ = save(activeTest_, testPath_);
    	}
    }


    public static boolean save(Survey survey, String curr_path)
    {
    	if (survey == null)
    	{
    		in_out_.putString("No active one to save.\n\n");
    		return false;
    	}
    	
    	String path = curr_path;
    	if (curr_path == null)
    	{
    		in_out_.putString("Where and under what name would you like to save it?\n");
    		path = in_out_.getString();
    	}
    	else
    	{
    		in_out_.putString("Would you like to change where your survey or test is saved? Input 1 for yes, 0 for no.\n");
    		if (in_out_.getIntInRange(0, 1) == 1)
    		{
        		in_out_.putString("Where and under what name would you like to save it?\n");
        		path = in_out_.getString();
    		}
    	}
    	
    	try
        {
           FileOutputStream outFile = new FileOutputStream(path);
           ObjectOutputStream out = new ObjectOutputStream(outFile);
           out.writeObject(survey);
           out.close();
           outFile.close();
           in_out_.putString("Saved successfully.\n\n");
           if (curr_path == surveyPath_)
           {
        	   surveyPath_ = path;
           }
           else
           {
        	   testPath_ = path;
           }
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
        if (activeTest_ == null)
        {
        	in_out_.putString("Pleas either load or create a Test first.\n");
        }
        
        activeTest_.grade();
    }

    public static void tabulate(Survey survey)
    {
    	
    }

    public static void take(Survey survey)
    {
    	survey.take();
    }
}
