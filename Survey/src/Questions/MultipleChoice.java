package Questions;

import java.util.Set;
import java.util.TreeMap;

import InputOutput.InputOutput;
import InputOutput.ConsoleInputOutput;

public class MultipleChoice extends Question
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;
	protected TreeMap<String, String> choices_;

	//Constructor-----------------------------------
    public MultipleChoice()
    {
        super();
    }
    
    //public methods--------------------------------
    @Override
    public void display()
	{
        super.display();
        for (String key: choices_.keySet())
        {
        	in_out_.putString("\t" + key + ".) " + choices_.get(key) + "\n");
        }
    }
    
    @Override
    public Set<String> getValidResponses()
    {
    	//the keySet should be used as the user's possible input choices, so return that
    	return choices_.keySet();
    }

    @Override
    public void defineQuestion()
	{
        super.defineQuestion();
        addChoices();
        setMaxResponses();
    }

    @Override
    public void modifyQuestion()
	{

    }
    
    //protected methods-----------------------------
    protected void addChoice(String key, String answer)
	{	
        choices_.put(key, answer);
    }
    
    protected void addChoices()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
        info_getter.putString("How many choices would you like for your question?\n");
        int num_choices = info_getter.getInt();
        int iter_num = -1;
        char letter = 'A';
        //cycle through the letters. If the user decided to add more than 26 questions,
        //on those 27 and above, append the "iter_num" (the number of times the alphabet's
        //been cycle through) to the letter
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
    
    @Override
    protected void allocateResources()
    {
    	super.allocateResources();
    	choices_ = new TreeMap<String, String>();
    }
    
    @Override
    protected void setMaxResponses()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("How many responses would you like to allow? (At least 1 and at most " + choices_.size() + ".)\n");
    	maxResponses_ = info_getter.getIntInRange(1,  choices_.size());
    }
}
