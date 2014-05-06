package Survey;

import java.util.ArrayList;
import Responses.*;

public class Test extends Survey
{
	private static final long serialVersionUID = 1L;
	ArrayList<Response> correctResponses_;
    int totalTakers;
    
    public Test()
    {
    	super();
    }

    public int addQuestion()
    {
        int question_type = super.addQuestion();
        
        Response new_response;
        switch (question_type)
        {
        	case 1:
        	case 2:
        		new_response = new MultipleChoiceTrueFalseResponse();
        		break;
        	case 3:
        		new_response = new ShortAnswerResponse();
        		break;
        	case 4:
        		new_response = null;
        		break;
        	case 5:
        	case 6:
        		new_response = new MatchingRankingResponse();
        		break;
        	case 7:
        	default:
        		return question_type;
        }
        
        correctResponses_.add(new_response);
        
        return question_type;
    }

    public void gradeTestByTaker(int taker)
    {
        
    }

    public void modifyQuestion()
    {
        
    }

    public void removeQuestion()
    {
        
    }

    public void take()
    {
        
    }
}
