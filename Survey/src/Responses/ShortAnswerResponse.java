package Responses;

import java.util.Set;

import InputOutput.InputOutput;

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
    public ShortAnswerResponse(int max, int maxLength, InputOutput in_out)
	{
        answers_ = new String[max];
        for (int i = 0; i < answers_.length; i++)
        	answers_[i] = null;
        maxLength_ = maxLength;
        in_out_ = in_out;
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
    public void getResponseFromUser(Set<String> valid_responses)
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
