package Responses;

import java.util.Collections;
import java.util.Set;

import InputOutput.InputOutput;

public class ShortAnswerResponse extends Response
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;
    
    //Constructor-----------------------------------
    public ShortAnswerResponse(int max, InputOutput in_out)
	{
        super(max, in_out);
    }
    
    //public methods--------------------------------
    @Override
    public void getResponseFromUser(Set<String> valid_responses)
	{
    	String max = Collections.min(valid_responses);
    	int max_length = Integer.parseInt(max);
    	if (max_length > 0)
    	{
	    	for (int i = 0; i < choices_.length; i++)
	    	{
	    		choices_[i] = in_out_.getStringShorterThanEqualTo(max_length);
	    	}
    	}
    	else
    	{
    		for (int i = 0; i < choices_.length; i++)
    		{
    			choices_[i] = in_out_.getString();
    		}
    	}
	}
}
