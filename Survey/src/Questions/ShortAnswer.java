package Questions;

import InputOutput.*;

/**
 * 
 */
public class ShortAnswer extends Essay
{
	protected int maxLength_;
    /**
     * 
     */
    public void defineQuestion()
	{
        super.defineQuestion();
        InputOutput info_getter = new ConsoleInputOutput();
        info_getter.putString("What would you like the max possible length for the answer to be? (Must be less than 10,000 characters.)\n");
        maxLength_ = info_getter.getIntInRange(0, 10000);
    }

    /**
     * 
     */
    public void modifyQuestion()
	{
        // implement here...
    }
}
