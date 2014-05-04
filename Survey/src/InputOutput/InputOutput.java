package InputOutput;

abstract public class InputOutput
{
	abstract public String getString();
	abstract public int getIntInRange(int lower, int upper);
	abstract public void putString(String output);
	//abstract public void putInteger(int output);
	abstract public void close();
}
