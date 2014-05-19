package Responses;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import InputOutput.InputOutput;


public class MultipleChoiceTrueFalseResponse extends Response
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;

	//Constructor-----------------------------------
    public MultipleChoiceTrueFalseResponse(int max, InputOutput in_out)
	{
    	super(max, in_out);
    }
    
	//public methods--------------------------------    
    @Override
    public void getResponseFromUser(Set<String> valid_responses)
    {
    	Set<String> working_set = new TreeSet<String>(valid_responses);
    	for (int i = 0; i < choices_.length; i++)
    	{
    		choices_[i] = in_out_.getStringInSet(working_set);
    		//don't let the user pick the same answer more than once
    		working_set.remove(choices_[i]);
    	}
    	Arrays.sort(choices_);
    }
}
