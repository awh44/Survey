package Responses;

import java.io.Serializable;

import java.util.Set;

import InputOutput.InputOutput;

abstract public class Response implements Serializable
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;
	protected String[] choices_;
	protected InputOutput in_out_;
	
	//abstract methods------------------------------
	@Override
	abstract public boolean equals(Object o);
	abstract public void getResponseFromUser(Set<String> valid_responses);
	@Override
	abstract public int hashCode();
	
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
}
