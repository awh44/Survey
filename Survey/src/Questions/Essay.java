package Questions;

import java.util.Set;

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
    protected void setMaxResponses()
    {
    	maxResponses_ = 1;
    }
}
