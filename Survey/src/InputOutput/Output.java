package InputOutput;

import java.io.Serializable;

public abstract class Output implements Serializable
{
	private static final long serialVersionUID = 1L;

	abstract public void putString(String output);
	abstract public void close();
}
