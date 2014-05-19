package Responses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

import InputOutput.InputOutput;

abstract public class Response implements Serializable
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;
	protected String[] choices_;
	protected InputOutput in_out_;
	
	//abstract methods------------------------------
	abstract public void getResponseFromUser(Set<String> valid_responses);
	
	//Constructor-----------------------------------
	public Response(int max, InputOutput in_out)
	{
    	choices_ = new String[max];
    	in_out_ = in_out;
	}
	
	//public methods--------------------------------
	public void display()
	{
    	for (int i = 0; i < choices_.length; i++)
    	{
    		in_out_.putString(choices_[i] + "; ");
    	}
	}
	
	public void changeMaxAnswers(int max)
	{
		choices_ = new String[max];
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(choices_);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (!Arrays.equals(choices_, other.choices_))
			return false;
		return true;
	}
}