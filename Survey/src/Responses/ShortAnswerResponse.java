package Responses;

public class ShortAnswerResponse extends Response
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] answers_;
    int maxLength_;

    /**
     * 
     */
    public ShortAnswerResponse(int max)
	{
        answers_ = new String[max];
        for (int i = 0; i < answers_.length; i++)
        	answers_[i] = null;
    }

    void addAnswer(String answer)
	{
        // implement here...
    }

    public void display()
	{
        // implement here...
    }

    /**
     * 
     */
    public boolean equals(Object o)
	{
        return true;
    }

    /**
     * 
     */
    public void getResponseFromUser()
	{
        
    }

    /**
     * 
     */
    public int hashCode()
	{
        return 1;
    }

    /**
     * 
     */
    public void setLength()
	{
        // implement here...
    }
}
