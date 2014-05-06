package Questions;

import java.util.ArrayList;

import InputOutput.*;

public class Matching extends Question
{
	private static final long serialVersionUID = 1L;
	protected ArrayList<String> leftColumn_;
    protected ArrayList<String> rightColumn_;

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

    public void defineQuestion()
    {
    	super.defineQuestion();
    	defineLeftColumn();
    	defineRightColumn();
    }
    
    protected void setMaxResponses()
    {
    	maxResponses_ = 1;
    }
    
    protected void defineLeftColumn()
    {
    	defineColumn(leftColumn_, "question");
    }
    
    protected void defineRightColumn()
    {
    	defineColumn(rightColumn_, "answer");
    }
    
    protected void defineColumn(ArrayList<String> column, String descriptor)
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("How many items would you like in the " + descriptor + " column?");
    	int left = info_getter.getInt();
    	for (int i = 0; i < left; i++)
    	{
    		info_getter.putString("What would you like " + descriptor + " number " + (i + 1) + " to be?");
    		String input = info_getter.getString();
    		column.add(input);
    	}
    }

    public void display()
    {
    	super.display();
    	in_out_.putString("Question column:\n");
        displayColumn(leftColumn_);
        in_out_.putString("Answer column:\n");
        displayColumn(rightColumn_);
    }

    protected void displayColumn(ArrayList<String> column)
    {
        for (int i = 0; i < column.size(); i++)
        {
        	in_out_.putString((i + 1) + ".) " + column.get(i) + "\n");
        }
    }

    protected void modifyColumn(ArrayList<String> column)
    {

    }

    public void modifyQuestion()
    {
    	
    }
}
