package Responses;

public class MatchingRankingResponse extends Response
{
	private static final long serialVersionUID = 1L;
	String[] choices_;

    public MatchingRankingResponse(int num_choices)
	{
        choices_ = new String[num_choices];
    }

    void addChoice(String choice)
	{
    
    }

    public void display()
	{

    }

    public boolean equals(Object o)
	{
        return true;
    }

    public void getResponseFromUser()
	{
    	
    }

    public int hashCode()
	{
        return 0;
    }
}
