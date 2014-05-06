package Questions;

import InputOutput.*;

public class ShortAnswer extends Essay
{
	private static final long serialVersionUID = 1L;
	protected int maxLength_;

    public void defineQuestion()
	{
        super.defineQuestion();
        InputOutput info_getter = new ConsoleInputOutput();
        info_getter.putString("What would you like the max possible length for each answer to be?\n");
        maxLength_ = info_getter.getIntGreaterThanEqualTo(1);
    }
    
    protected void setMaxResponses()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("How many responses would you like to allow?");
    	maxResponses_ = info_getter.getIntGreaterThanEqualTo(1);
    }

    public void modifyQuestion()
	{
        // implement here...
    }
    
    public int getMaxLength()
    {
    	return maxLength_;
    }
}
