package Responses;

import java.util.Set;

import InputOutput.InputOutput;

public class ShortAnswerResponse extends Response
{
	private static final long serialVersionUID = 1L;
    int maxLength_;
    
    public ShortAnswerResponse(int max, InputOutput in_out, int maxLength)
	{
        super(max, in_out);
        maxLength_ = maxLength;
    }
    
    @Override
    public void getResponseFromUser(Set<String> valid_responses)
	{
    	for (int i = 0; i < choices_.length; i++)
    	{
    		choices_[i] = in_out_.getStringShorterThan(maxLength_);
    	}
    }

    @Override
    public boolean equals(Object o)
	{
        return true;
    }

    @Override
    public int hashCode()
	{
        return 1;
    }
}
