package Questions;

import java.util.Set;

import InputOutput.ConsoleInputOutput;
import InputOutput.InputOutput;
import Responses.Response;
import Responses.ShortAnswerResponse;

public class Essay extends Question
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;

	//Constructor-----------------------------------
    public Essay()
	{
        super();
    }
    
    //public methods--------------------------------
    @Override
    public void defineQuestion()
    {
    	super.defineQuestion();
    	setMaxResponses();
    }
    
    @Override
    public Set<String> getValidResponses()
    {
    	return null;
    }
    
    @Override
    public void tabulateAndDisplay()
    {
    	for (Response response: responses_)
    	{
    		response.display();
    		InputOutput info_getter = new ConsoleInputOutput();
    		info_getter.putString("\n");
    	}
    }
    
    //protected methods-----------------------------  
    @Override
    protected void addNewTaker()
    {
    	responses_.add(new ShortAnswerResponse(maxResponses_, in_out_, -1));
    }
    
    @Override
    protected void setMaxResponses()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("How many responses would you like to allow?\n");
    	maxResponses_ = info_getter.getIntGreaterThanEqualTo(1);
    }
    
    protected void superTabulate()
    {
    	super.tabulateAndDisplay();
    }
}
