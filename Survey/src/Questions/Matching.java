package Questions;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import InputOutput.InputOutput;
import InputOutput.ConsoleInputOutput;

import Responses.MatchingRankingResponse;

public class Matching extends Question
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;
	protected ArrayList<String> leftColumn_;
    protected ArrayList<String> rightColumn_;

    //Constructor-----------------------------------
    public Matching()
    {
    	super();
    }
    
    //public methods--------------------------------
    @Override
    public Set<String> getValidResponses()
    {
    	TreeSet<String> valid_strings = new TreeSet<String>();
    	for (int i = 0; i < rightColumn_.size(); i++)
    	{
    		valid_strings.add(String.valueOf(i + 1));
    	}
    	return valid_strings;
    }
    
    @Override
    public void display()
    {
    	super.display();
    	in_out_.putString("\tQuestion column:\n");
        displayColumn(leftColumn_);
        in_out_.putString("\tAnswer column:\n");
        displayColumn(rightColumn_);
    }

    @Override
    public void defineQuestion()
    {
    	super.defineQuestion();
    	defineLeftColumn();
    	defineRightColumn();
    	setMaxResponses();
    }

    @Override
    public boolean modifyQuestion()
    {
    	super.modifyQuestion();
    	boolean retVal = modifyLeftColumn();    	
    	modifyRightColumn();
    	return retVal;
    }
    
    //protected methods-----------------------------
    @Override
    protected void addNewTaker()
    {
    	responses_.add(new MatchingRankingResponse(leftColumn_.size(), in_out_));
    }
    
    @Override
    protected void allocateResources()
    {
    	super.allocateResources();
    	leftColumn_ = new ArrayList<String>();
    	rightColumn_ = new ArrayList<String>();
    }
    
    protected void defineColumn(ArrayList<String> column, String descriptor)
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("How many items would you like in the " + descriptor + " column?\n");
    	int number = info_getter.getIntGreaterThanEqualTo(1);
    	loopColumn(column, 0, number, descriptor);
    }
    
    protected void defineLeftColumn()
    {
    	defineColumn(leftColumn_, "question");
    }
    
    protected void defineRightColumn()
    {
    	defineColumn(rightColumn_, "answer");
    }
    
    protected void displayColumn(ArrayList<String> column)
    {
        for (int i = 0; i < column.size(); i++)
        {
        	in_out_.putString("\t\t" + (i + 1) + ".) " + column.get(i) + "\n");
        }
    }
    
    protected void loopColumn(ArrayList<String> column, int start, int num_to_add, String descriptor)
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	for (int i = start; i < start + num_to_add; i++)
    	{
    		info_getter.putString("What would you like " + descriptor + " number " + (i + 1) + " to be?\n");
    		String input = info_getter.getString();
    		column.add(input);
    	}
    }
    
    protected boolean modifyColumn(ArrayList<String> column)
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("Would you like to modify the choices? Input 1 for yes, 0 for no.\n");
    	int input = info_getter.getIntInRange(0, 1);
    	while (input == 1)
    	{
    		info_getter.putString("Which choice would you like to change? (Between 1 and " + column.size() + ".)\n");
    		int choice_number = info_getter.getIntInRange(1, column.size()) - 1;
    		info_getter.putString("What would you like the new  choice to be?\n");
    		String new_choice = info_getter.getString();
    		column.set(choice_number, new_choice);
    		info_getter.putString("Would you like to modify another choice? Input 1 for yes, 0 for no.\n");
    		input = info_getter.getIntInRange(0, 1);
    	}
    	
    	info_getter.putString("Would you like to add more choices? Input 1 for yes, 0 for no.\n");
    	input = info_getter.getIntInRange(0, 1);
    	if (input == 1)
    	{
    		info_getter.putString("How many more would you like to add?\n");
    		int num_to_add = info_getter.getIntGreaterThanEqualTo(1);
    		loopColumn(column, column.size() - 1, num_to_add, "");
    		if (column == leftColumn_)
    		{
    			setMaxResponses();
    			return true;
    		}
    	}
    	return false;
    }
    
    protected boolean modifyLeftColumn()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("Would you like to modify the question column? Input 1 for yes, 0 for no.\n");
    	int input = info_getter.getIntInRange(0, 1);
    	if (input == 1)
    	{
    		return modifyColumn(leftColumn_);
    	}
    	return false;
    }
    
    protected boolean modifyRightColumn()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("Would you like to modify the answers column? Input 1 for yes, 0 for no.\n");
    	int input = info_getter.getIntInRange(0, 1);
    	if (input == 1)
    	{
    		return modifyColumn(rightColumn_);
    	}
    	return false;
    }
    
    @Override
    protected void setMaxResponses()
    {
    	//this method/attribute used slightly differently in this hierarchy.
    	//Instead of multiple responses, it indicates how many rows there
    	//are in the "question" column
    	maxResponses_ = leftColumn_.size();
    }
}