package Questions;

import java.util.TreeMap;

import InputOutput.*;

public class MultipleChoice extends Question
{

    TreeMap<String, String> choices_;

    public MultipleChoice()
    {
        super();
    }
    
    protected void allocateResources()
    {
    	super.allocateResources();
    	choices_ = new TreeMap<String, String>();
    }

    protected void addChoice(String key, String answer)
	{
    	System.out.println(key + " " + answer);
    	if (choices_ == null)
    	{
    		System.out.println("why's it null");
    		return;
    	}
    	
        choices_.put(key, answer);
    }

    public void defineQuestion()
	{
        super.defineQuestion();
        addChoices();
    }
    
    protected void addChoices()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
        info_getter.putString("How many choices would you like for your question? (At least 1, but less than 27.)\n");
        int num_choices = info_getter.getIntInRange(1, 27);
        for (char letter = 'A'; letter < 'A' + num_choices; letter++)
        {
        	info_getter.putString("What would you like choice " + letter + " to be?\n");
        	String choice = info_getter.getString();
        	//System.out.println("here");
        	addChoice(String.valueOf(letter), choice);
        }
    }

    public void display()
	{
        super.display();
        for (String key: choices_.keySet())
        {
        	in_out_.putString("\t" + key + ".) " + choices_.get(key) + "\n");
        }
    }

    public void modifyQuestion()
	{
        // implement here...
    }
}
