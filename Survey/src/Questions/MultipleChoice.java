package Questions;

import java.util.TreeMap;

import InputOutput.*;

public class MultipleChoice extends Question
{
    protected TreeMap<String, String> choices_;

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
        info_getter.putString("How many choices would you like for your question?\n");
        int num_choices = info_getter.getInt();
        int iter_num = -1;
        char letter = 'A';
        for (int i = 0; i < num_choices; i++)
        {
        	if (i % 26 == 0)
        	{
        		iter_num++;
        		letter = 'A';
        	}
        	String display_letter;
        	if (iter_num == 0)
        	{
        		display_letter = String.valueOf(letter);
        	}
        	else
        	{
        		display_letter = String.valueOf(letter) + iter_num;
        	}
        	info_getter.putString("What would you like choice " + display_letter + " to be?\n");
        	String choice = info_getter.getString();
        	addChoice(display_letter, choice);
        	letter++;
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
