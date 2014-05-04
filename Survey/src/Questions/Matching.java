package Questions;

import java.util.ArrayList;

import InputOutput.*;

/**
 * 
 */
public class Matching extends Question
{
    ArrayList<String> leftColumn_;
    ArrayList<String> rightColumn_;

    /**
     * 
     */
    public Matching()
    {
    	super();
    }
    
    @Override
    protected void allocateResources()
    {
    	super.allocateResources();
    	leftColumn_ = new ArrayList<String>();
    	rightColumn_ = new ArrayList<String>();
    }

    /**
     * 
     */
    public void defineQuestion()
    {
    	super.defineQuestion();
    	defineColumn(leftColumn_, "question");
    	defineColumn(rightColumn_, "answer");
    }
    
    protected void defineColumn(ArrayList<String> column, String descriptor)
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("How many items would you like in the " + descriptor + " column?");
    	int left = info_getter.getInt();
    	for (int i = 0; i < left; i++)
    	{
    		info_getter.putString("What would you like " + descriptor + " number " + i + " to be?");
    		String input = info_getter.getString();
    		column.add(input);
    	}
    }

    /**
     * 
     */
    public void display()
    {
    	super.display();
    	in_out_.putString("Question column:\n");
        displayColumn(leftColumn_);
        in_out_.putString("Answer column:\n");
        displayColumn(rightColumn_);
    }

    /**
     * 
     */
    protected void displayColumn(ArrayList<String> column)
    {
        for (int i = 0; i < column.size(); i++)
        {
        	in_out_.putString(i + ".) " + column.get(i) + "\n");
        }
    }

    /**
     * 
     */
    protected void modifyColumn(ArrayList<String> column)
    {
        // implement here...
    }

    /**
     * 
     */
    public void modifyQuestion()
    {
        // implement here...
    }
}
