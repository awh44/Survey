package Responses;


public class MultipleChoiceTrueFalseResponse extends Response
{
	private static final long serialVersionUID = 1L;
	String[] choices_;

    public MultipleChoiceTrueFalseResponse(int max)
	{
    	choices_ = new String[max];
    	for (int i = 0; i < choices_.length; i++)
    	{
    		choices_[i] = null;
    	}
    }

    void addChoice(String choice)
	{
    	
    }

    public void display()
	{
    	
    }

    public boolean equals(Object o)
	{
        return true;
    }

    public void getResponseFromUser()
	{
        
    }

    public int hashCode()
	{
        return 1;
    }
}
