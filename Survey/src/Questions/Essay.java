package Questions;

import java.util.Set;
import java.util.TreeSet;

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
    	Set<String> retSet = new TreeSet<String>();
    	retSet.add("1");
    	return retSet;
    }
    
    @Override
    public boolean modifyQuestion()
    {
    	super.modifyQuestion();
		InputOutput info_getter = new ConsoleInputOutput();
		info_getter.putString("Would you like to change maximum number of responses? Input 1 for yes, 0 for no.\n");
		int input = info_getter.getIntInRange(0, 1);
		if (input == 1)
		{
			setMaxResponses();
			return true;
		}
		
		return false;
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
    	responses_.add(new ShortAnswerResponse(maxResponses_, in_out_));
    }
    
    @Override
    protected void setMaxResponses()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("How many responses would you like to allow? (At least 1.)\n");
    	maxResponses_ = info_getter.getIntGreaterThanEqualTo(1);
    }
    
    protected void superTabulate()
    {
    	super.tabulateAndDisplay();
    }
}
