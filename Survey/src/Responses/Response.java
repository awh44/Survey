package Responses;

import java.io.Serializable;
import java.util.Set;

import InputOutput.InputOutput;

abstract public class Response implements Serializable
{
	private static final long serialVersionUID = 1L;
	protected InputOutput in_out_;
	
	abstract public void display();
	abstract public void getResponseFromUser(Set<String> valid_responses);
	@Override
	abstract public boolean equals(Object o);
	@Override
	abstract public int hashCode();
}
