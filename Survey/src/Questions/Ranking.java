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
    public void modifyQuestion()
	{
        // implement here...
    }

	//protected methods-----------------------------
	//overriding this method only allows this class to call super() and continue to access
	//the initial question's constructor
	@Override
	protected void defineRightColumn()
	{
		for (int i = 0; i < leftColumn_.size(); i++)
		{
			rightColumn_.add("");
		}
	}
}
