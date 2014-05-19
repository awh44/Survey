package Questions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import InputOutput.InputOutput;
import InputOutput.ConsoleInputOutput;

import Responses.MultipleChoiceTrueFalseResponse;

public class MultipleChoice extends Question
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;
	protected Map<String, String> choices_;

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
    public boolean modifyQuestion()
	{
    	super.modifyQuestion();
    	return modifyChoices();
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
        int num_choices = info_getter.getIntGreaterThanEqualTo(1);
        loopChoices('A', num_choices, 0);
    }
    
    @Override
    protected void addNewTaker()
    {
    	responses_.add(new MultipleChoiceTrueFalseResponse(maxResponses_, in_out_));
    }
    
    @Override
    protected void allocateResources()
    {
    	super.allocateResources();
    	choices_ = new LinkedHashMap<String, String>();
    }
    
    private void loopChoices(char start_letter, int num_to_add, int iteration)
    {
    	InputOutput info_getter = new ConsoleInputOutput();
        //cycle through the letters. If there are more than 26 choices,
        //on those 27 and above, append the iteration (the number of times the alphabet's
        //been cycled through) to the letter
    	for (int i = 0; i < num_to_add; i++)
    	{
    		String display_letter;
    		if (iteration == 0)
    		{
    			display_letter = String.valueOf(start_letter);
    		}
    		else
    		{
    			display_letter = String.valueOf(start_letter) + iteration;
    		}
    		
        	info_getter.putString("What would you like choice " + display_letter + " to be?\n");
        	String choice = info_getter.getString();
        	addChoice(display_letter, choice);
        	start_letter++;
        	
        	if (start_letter > 'Z')
        	{
        		iteration++;
        		start_letter = 'A';
        	}
    	}
    }
    
    protected boolean modifyChoices()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("Would you like to modify the choices? Input 1 for yes, 0 for no.\n");
    	int input = info_getter.getIntInRange(0, 1);
    	while (input == 1)
    	{
	    	info_getter.putString("Which choice would you like to modify?\n");
	    	String choice_letter = info_getter.getStringInSet(choices_.keySet());
	    	info_getter.putString("What would you like the choice to be?\n");
	    	String new_choice = info_getter.getString();
	    	choices_.put(choice_letter, new_choice);
	    	info_getter.putString("Would you like to modify another choice? Input 1 for yes, 0 for no.\n");
	    	input = info_getter.getIntInRange(0, 1);
    	}
    	
    	info_getter.putString("Would you like to add more choices? Input 1 for yes, 0 for no.\n");
    	input = info_getter.getIntInRange(0,  1);
    	if (input == 1)
    	{
    		info_getter.putString("How many would you like to add?\n");
    		int num_to_add = info_getter.getIntGreaterThanEqualTo(1);
    		String last_choice = "A";
    		for (String c: choices_.keySet())
    		{
    			last_choice = c;
    		}
    		
    		int iter_num = 0;
    		char letter = last_choice.charAt(0);
    		letter++;
    		
    		if (last_choice.length() > 1)
    		{
    			iter_num = Integer.parseInt(last_choice.substring(1));
    		}
    		
    		if (letter > 'Z')
    		{
    			iter_num++;
    			letter = 'A';
    		}
    		
    		loopChoices(letter, num_to_add, iter_num);
    	}
    	
    	info_getter.putString("Would you like to change the allowed number of responses? Input 1 for yes, 0 for no.\n");
    	input = info_getter.getIntInRange(0, 1);
    	if (input == 1)
    	{
    		setMaxResponses();
    		return true;
    	}
    	
    	return false;
    }
    
    @Override
    protected void setMaxResponses()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("How many responses would you like to allow? (At least 1 and at most " + choices_.size() + ".)\n");
    	maxResponses_ = info_getter.getIntInRange(1,  choices_.size());
    }
}
