package Responses;

import java.io.Serializable;
import java.util.Set;

import InputOutput.InputOutput;

abstract public class Response implements Serializable
{
	private static final long serialVersionUID = 1L;
	protected String[] choices_;
	protected InputOutput in_out_;
	
	public Response(int max, InputOutput in_out)
	{
    	choices_ = new String[max];
    	for (int i = 0; i < choices_.length; i++)
    	{
    		choices_[i] = null;
    	}
    	in_out_ = in_out;
	}
	
	abstract public void display();
	abstract public void getResponseFromUser(Set<String> valid_responses);
	@Override
	abstract public boolean equals(Object o);
	@Override
	abstract public int hashCode();
}
