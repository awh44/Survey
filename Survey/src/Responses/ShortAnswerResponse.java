package Responses;

import java.util.Set;

import InputOutput.InputOutput;

public class ShortAnswerResponse extends Response
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    int maxLength_;

    /**
     * 
     */
    public ShortAnswerResponse(int max, InputOutput in_out, int maxLength)
	{
        super(max, in_out);
        maxLength_ = maxLength;
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
