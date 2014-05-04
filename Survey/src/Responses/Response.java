package Responses;

abstract public interface Response
{
	abstract public void display();
	abstract public void getResponseFromUser();
	@Override
	abstract public boolean equals(Object o);
	@Override
	abstract public int hashCode();
}
