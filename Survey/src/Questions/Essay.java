package Questions;

import java.util.Set;

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
    
    //protected methods-----------------------------  
    @Override
    protected void addNewTaker()
    {
    	responses_.add(new ShortAnswerResponse(maxResponses_, in_out_, -1));
    }
    
    @Override
    protected void setMaxResponses()
    {
    	maxResponses_ = 1;
    }
}
