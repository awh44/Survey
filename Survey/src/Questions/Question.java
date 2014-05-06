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
    abstract public Set<String> getValidResponses();
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
        return responses_.get(taker);
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
    protected void allocateResources()
    {
    	responses_ = new ArrayList<Response>();
    	in_out_ = new ConsoleInputOutput();	
    }
}
