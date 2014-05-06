package Responses;

import java.io.Serializable;

abstract public class Response implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	abstract public void display();
	abstract public void getResponseFromUser();
	@Override
	abstract public boolean equals(Object o);
	@Override
	abstract public int hashCode();
}
