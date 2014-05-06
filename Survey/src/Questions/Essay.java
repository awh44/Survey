package Questions;

import java.util.Set;

public class Essay extends Question
{
	private static final long serialVersionUID = 1L;

    public Essay()
	{
        super();
    }
    
    public Set<String> getValidResponses()
    {
    	return null;
    }
    
    public void defineQuestion()
    {
    	super.defineQuestion();
    	setMaxResponses();
    }
    
    protected void setMaxResponses()
    {
    	maxResponses_ = 1;
    }
}
