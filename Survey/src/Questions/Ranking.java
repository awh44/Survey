package Questions;

public class Ranking extends Matching
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;

	//Constructor-----------------------------------
	public Ranking()
	{
        super();
    }
	
	//public methods--------------------------------
	@Override
    public boolean modifyQuestion()
	{
        return false;
    }

	//protected methods-----------------------------
	//overriding this method only allows this class to call super() and continue to access
	//the initial Question's constructor
	@Override
	protected void defineRightColumn()
	{
		for (int i = 0; i < leftColumn_.size(); i++)
		{
			rightColumn_.add("");
		}
	}
	
	@Override
	protected boolean modifyRightColumn()
	{
		for (int i = leftColumn_.size() - rightColumn_.size(); i < leftColumn_.size(); i++)
		{
			rightColumn_.add("");
		}
		return false;
	}
}
