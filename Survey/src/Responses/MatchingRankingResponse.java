package Responses;

import java.util.Set;

import InputOutput.InputOutput;

public class MatchingRankingResponse extends Response
{
	private static final long serialVersionUID = 1L;
	String[] choices_;

    public MatchingRankingResponse(int num_choices, InputOutput in_out)
	{
        choices_ = new String[num_choices];
        in_out_ = in_out;
    }

    public void display()
	{

    }

    public boolean equals(Object o)
	{
        return true;
    }

    public void getResponseFromUser(Set<String> valid_responses)
	{
    	
    }

    public int hashCode()
	{
        return 0;
    }
}
