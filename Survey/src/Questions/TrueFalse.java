package Questions;

/**
 * 
 */
public class TrueFalse extends MultipleChoice
{
    /**
     * 
     */
	public TrueFalse()
	{
    
    }

    /**
     * 
     */
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

    /**
     * 
     */
    public void modifyQuestion()
	{
        // implement here...
    }
}
