package Questions;

import java.io.Serializable;

import java.util.ArrayList;
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
    //used to pass information to the Response class, so it can obtain only valid responses
    abstract public Set<String> getValidResponses();
    //this method becomes very abused in the subclasses to set things the way they should be.
    //In the hierarchies which allow multiple responses at some point, it sets the number of
    //allowable responses. In the other hierarchies (name, Matching/Ranking), it is set by the
    //number of rows in the "Question" column
    abstract protected void setMaxResponses();

    //Constructor-----------------------------------
    public Question()
    {
    	allocateResources();
    	defineQuestion();
    }
    
    //public methods--------------------------------
    public void defineQuestion()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("What would you like the prompt to be?\n");
    	prompt_ = info_getter.getString();	
    }
    
    public void display()
    {
    	in_out_.putString(prompt_ + "\n");
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
        return null;//responses_.get(taker);
    }
    
    public void modifyQuestion()
	{
    	
	}
    
    public void newTaker(Response newResponse)
    {
        responses_.add(newResponse);
    }

    public void tabulateAndDisplay()
	{

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
