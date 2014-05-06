package Questions;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Set;

import Responses.*;
import InputOutput.*;

abstract public class Question implements Serializable
{
	private static final long serialVersionUID = 1L;
	String prompt_;
    ArrayList<Response> responses_;
    InputOutput in_out_;
    int maxResponses_;
    
    abstract public Set<String> getValidResponses();
    abstract protected void setMaxResponses();

    public Question()
    {
    	allocateResources();
    	defineQuestion();
    }
    
    public int getMaxResponses()
    {
    	return maxResponses_;
    }
    
    public InputOutput getInOut()
    {
    	return in_out_;
    }
    
    protected void allocateResources()
    {
    	responses_ = new ArrayList<Response>();
    	in_out_ = new ConsoleInputOutput();	
    }

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

    Response getResponseByTaker(int taker)
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
}
