package Questions;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import Responses.Response;
import InputOutput.InputOutput;
import InputOutput.ConsoleInputOutput;

abstract public class Question implements Serializable
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;
    protected InputOutput in_out_;
    protected int maxResponses_;
	protected String prompt_;
    protected ArrayList<Response> responses_;
    
    //abstract methods------------------------------
    //used to pass information to the Response class, so it can obtain only valid responses.
    //Is used sort of inconsistently between the various types of Questions, but it's also
    //used to determine what the various allowed Responses should be.
    abstract public Set<String> getValidResponses();
    //implemented by subclasses to add the correct kind of Response subclass to the responses_
    //ArrayList
    abstract protected void addNewTaker();
    //this method becomes very abused in the subclasses to set things the way they should be.
    //In the hierarchies which allow multiple responses at some point, it sets the number of
    //allowable responses. In the other hierarchies (namely, Matching/Ranking), it is set by the
    //number of rows in the "Question" column
    abstract protected void setMaxResponses();
    

    //Constructor-----------------------------------
    public Question()
    {
    	allocateResources();
    	defineQuestion();
    }
    
    //public methods--------------------------------
    //does everything necessary when creating a new question to define it
    public void defineQuestion()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("What would you like the prompt to be?\n");
    	prompt_ = info_getter.getString();	
    }
    
    public void display()
    {
    	String max = "";
    	if (maxResponses_ > 1)
    	{
    		max = " (You must give " + maxResponses_ + " responses.)";
    	}
    	in_out_.putString(prompt_ + max + "\n");
    }
    
    public InputOutput getInOut()
    {
    	return in_out_;
    }
    
    public int getMaxResponses()
    {
    	return maxResponses_;
    }
    
    public Response getResponseByTaker(int taker)
    {
        return responses_.get(taker);
    }
    
    //similar to defineQuestion(), but this time for the modification of the question; handles
    //all to do with modification; returns true if the modifications mean that any previous answers
    //would now be, essentially, invalid (meaning that correct answers have to be updated). Returns false
    //if non-critical changes were made, in essene. (i.e., the number of maxResponses_ wasn't changed, or,
    //in ShortAnswer, maxLength_ wasn't.
    public boolean modifyQuestion()
	{
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("Would you like to modify the prompt? Input 1 for yes, 0 for no.\n");
    	int choice = info_getter.getIntInRange(0, 1);
    	if (choice == 1)
    	{
    		info_getter.putString("What would you like the new prompt to be?\n");
    		prompt_ = info_getter.getString();
    	}
    	return false;
	}
    
    //add a new Response to the maintained ArrayList and have the user answer
    public void answer()
    {
        addNewTaker();
        responses_.get(responses_.size() - 1).getResponseFromUser(getValidResponses());
    }

    //tabulate the answers to this particular Question and output the various permutations
    //and their counts
    public void tabulateAndDisplay()
	{
    	Map<Response, Integer> tabulation = new LinkedHashMap<Response, Integer>();
    	for (int i = 0; i < responses_.size(); i++)
    	{
    		Response curr_response = responses_.get(i);
    		if (tabulation.get(curr_response) == null)
    		{
    			tabulation.put(curr_response, 1);
    		}
    		else
    		{
    			tabulation.put(curr_response,  tabulation.get(curr_response) + 1);
    		}
    	}
    	
    	for (Response response: tabulation.keySet())
    	{
    		response.display();
    		InputOutput info_getter = new ConsoleInputOutput();
    		info_getter.putString("\n\tCount: " + tabulation.get(response) + "\n");
    	}
    }
    
    //protected methods-----------------------------
    //used to initialize variables throughout this and subclasses
    //allows the calling of super() up the chain but with all needed
    //variables initialized first
    protected void allocateResources()
    {
    	responses_ = new ArrayList<Response>();
    	in_out_ = new ConsoleInputOutput();	
    }
}
