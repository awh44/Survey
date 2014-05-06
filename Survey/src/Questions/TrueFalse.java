package Questions;

public class TrueFalse extends MultipleChoice
{
	private static final long serialVersionUID = 1L;

	public TrueFalse()
	{
		super();
    }

    public void defineQuestion()
	{
    	super.defineQuestion();
    }
    
    @Override
    public void addChoices()
    {
    	addChoice("True", "");
    	addChoice("False", "");
    }
    
    protected void setMaxResponses()
    {
    	maxResponses_ = 1;
    }

    public void modifyQuestion()
	{

    }
}
