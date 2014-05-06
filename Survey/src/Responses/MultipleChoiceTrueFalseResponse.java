package Responses;

import java.util.Set;
import java.util.TreeSet;

import InputOutput.InputOutput;


public class MultipleChoiceTrueFalseResponse extends Response
{
	private static final long serialVersionUID = 1L;
	String[] choices_;

    public MultipleChoiceTrueFalseResponse(int max, InputOutput in_out)
	{
    	choices_ = new String[max];
    	for (int i = 0; i < choices_.length; i++)
    	{
    		choices_[i] = null;
    	}
    	in_out_ = in_out;
    }

    void addChoice(String choice)
	{
    	
    }

    public void display()
	{
    	for (int i = 0; i < choices_.length; i++)
    	{
    		in_out_.putString(choices_[i] + "\n");
    	}
    }

    public boolean equals(Object o)
	{
        return true;
    }

    public void getResponseFromUser(Set<String> valid_responses)
    {
    	Set<String> working_set = new TreeSet<String>(valid_responses);
    	
    	for (int i = 0; i < choices_.length; i++)
    	{
    		choices_[i] = in_out_.getStringInSet(working_set);
    		working_set.remove(choices_[i]);
    	}
    }

    public int hashCode()
	{
        return 1;
    }
}
