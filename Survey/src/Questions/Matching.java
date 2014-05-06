package Questions;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import InputOutput.InputOutput;
import InputOutput.ConsoleInputOutput;

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
    	for (int i = 0; i < leftColumn_.size(); i++)
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
    public void modifyQuestion()
    {
    	
    }
    
    //protected methods-----------------------------
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
    	int left = info_getter.getInt();
    	for (int i = 0; i < left; i++)
    	{
    		info_getter.putString("What would you like " + descriptor + " number " + (i + 1) + " to be?\n");
    		String input = info_getter.getString();
    		column.add(input);
    	}
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
    
    protected void modifyColumn(ArrayList<String> column)
    {

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
