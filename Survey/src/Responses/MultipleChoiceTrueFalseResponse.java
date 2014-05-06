package Responses;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import InputOutput.InputOutput;


public class MultipleChoiceTrueFalseResponse extends Response
{
	private static final long serialVersionUID = 1L;

    public MultipleChoiceTrueFalseResponse(int max, InputOutput in_out)
	{
    	super(max, in_out);
    }

    @Override
    public void getResponseFromUser(Set<String> valid_responses)
    {
    	Set<String> working_set = new TreeSet<String>(valid_responses);
    	in_out_.putString("choices_.length ==" + choices_.length);
    	for (int i = 0; i < choices_.length; i++)
    	{
    		choices_[i] = in_out_.getStringInSet(working_set);
    		working_set.remove(choices_[i]);
    	}
    	Arrays.sort(choices_);
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
