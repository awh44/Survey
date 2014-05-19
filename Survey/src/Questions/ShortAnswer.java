package Questions;

import InputOutput.InputOutput;
import InputOutput.ConsoleInputOutput;

import Responses.ShortAnswerResponse;

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

	@Override
    public boolean modifyQuestion()
	{
		boolean retVal = super.modifyQuestion();
		
		InputOutput info_getter = new ConsoleInputOutput();
		info_getter.putString("Would you like to modify the maximum length for a response? Input 1 for yes, 0 for no.\n");
		int input = info_getter.getIntInRange(0, 1);
		if (input == 1)
		{
			info_getter.putString("What would you like the new maximum possible length for each answer to be?\n");
			maxLength_ = info_getter.getIntGreaterThanEqualTo(1);
		}
		
		return retVal;
		
    }
    
    public int getMaxLength()
    {
    	return maxLength_;
    }
    
    @Override
    public void tabulateAndDisplay()
    {
    	super.superTabulate();
    }
    
    //protected methods-----------------------------
    @Override
    protected void addNewTaker()
    {
    	responses_.add(new ShortAnswerResponse(maxResponses_, in_out_, maxLength_));
    }
}
