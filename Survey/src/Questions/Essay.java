package Questions;

public class Essay extends Question
{
	private static final long serialVersionUID = 1L;

    public Essay()
	{
        super();
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
