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
    
    //protected methods-----------------------------
    @Override
    //following two overriden here because TrueFalse needs to be
    //able to call up the chain of define/modifyQuestions, but
    //can't do that if MultipleChoice includes too much specific
    //implementation; therefore, some was "factored out" here
    //to be more easily overridable
    protected void addChoices()
    {
    	addChoice("True", "");
    	addChoice("False", "");
    }
    
    @Override
    protected boolean modifyChoices()
	{
    	return false;
    }
    
    @Override
    //always either True or False
    protected void setMaxResponses()
    {
    	maxResponses_ = 1;
    }
}
