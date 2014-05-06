package Questions;

/**
 * 
 */
public class Ranking extends Matching
{
	private static final long serialVersionUID = 1L;

	public Ranking()
	{
        super();
    }

	@Override
	protected void defineRightColumn()
	{
		for (int i = 0; i < leftColumn_.size(); i++)
		{
			rightColumn_.add("");
		}
	}
	
    public void modifyQuestion()
	{
        // implement here...
    }
}
