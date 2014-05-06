package Questions;

import InputOutput.InputOutput;
import InputOutput.ConsoleInputOutput;

public class ShortAnswer extends Essay
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;
	protected int maxLength_;
	
	//Constructor-----------------------------------
	public ShortAnswer()
	{
		super();
	}

	//public methods--------------------------------
	@Override
    public void defineQuestion()
	{
        super.defineQuestion();
        InputOutput info_getter = new ConsoleInputOutput();
        info_getter.putString("What would you like the max possible length for each answer to be?\n");
        maxLength_ = info_getter.getIntGreaterThanEqualTo(1);
    }

    public void modifyQuestion()
	{
    	
    }
    
    public int getMaxLength()
    {
    	return maxLength_;
    }
    
    //protected methods-----------------------------
    @Override
    protected void setMaxResponses()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("How many responses would you like to allow?\n");
    	maxResponses_ = info_getter.getIntGreaterThanEqualTo(1);
    }
}
