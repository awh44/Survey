package Responses;

import java.util.Set;
import java.util.TreeSet;

import InputOutput.InputOutput;

public class MatchingRankingResponse extends Response
{
	private static final long serialVersionUID = 1L;

	//Constructor-----------------------------------
    public MatchingRankingResponse(int num_choices, InputOutput in_out)
	{
        super(num_choices, in_out);
    }

    //public methods--------------------------------
    @Override
    public void getResponseFromUser(Set<String> valid_responses)
	{
    	Set<String> working_set = new TreeSet<String>(valid_responses);
    	for (int i = 0; i < choices_.length; i++)
    	{
    		in_out_.putString("Input the corresponding Answer number for Question " + (i + 1 )+ ": ");
    		choices_[i] = in_out_.getStringInSet(working_set);
    	}
    }
}
