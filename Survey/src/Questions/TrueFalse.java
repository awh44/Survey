package Questions;

public class TrueFalse extends MultipleChoice
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;

	//Constructor-----------------------------------
	public TrueFalse()
	{
		super();
    }

	//public methods--------------------------------
	@Override
    public void defineQuestion()
	{
    	super.defineQuestion();
    }

    @Override
    protected void modifyChoices()
	{
    	return;
    }
    
    //protected methods-----------------------------
    @Override
    protected void addChoices()
    {
    	addChoice("True", "");
    	addChoice("False", "");
    }
    
    @Override
    protected void setMaxResponses()
    {
    	maxResponses_ = 1;
    }
}
