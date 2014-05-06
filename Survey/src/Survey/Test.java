package Survey;

import java.util.ArrayList;

import InputOutput.ConsoleInputOutput;
import InputOutput.InputOutput;
import Questions.Question;
import Questions.ShortAnswer;
import Responses.MatchingRankingResponse;
import Responses.MultipleChoiceTrueFalseResponse;
import Responses.Response;
import Responses.ShortAnswerResponse;

public class Test extends Survey
{
	private static final long serialVersionUID = 1L;
	ArrayList<Response> correctResponses_;
    int totalTakers_;
    
    public Test()
    {
    	super();
    }
    
    protected void allocateResources()
    {
    	super.allocateResources();
    	correctResponses_ = new ArrayList<Response>();
    	totalTakers_ = 0;
    }

    public int addQuestion()
    {
        int question_type = super.addQuestion();
        
        Question question = questions_.get(questions_.size() - 1);
        Response new_response;
        InputOutput info_getter = new ConsoleInputOutput();
        switch (question_type)
        {
        	case 1:
        	case 2:
        		info_getter.putString("Please input the correct response(s).\n");
        		new_response = new MultipleChoiceTrueFalseResponse(question.getMaxResponses(), question.getInOut());
        		new_response.getResponseFromUser(question.getValidResponses());
        		break;
        	case 3:
        		info_getter.putString("Please input the correct response(s).\n");
        		new_response = new ShortAnswerResponse(question.getMaxResponses(), question.getInOut(), ((ShortAnswer) question).getMaxLength());
        		new_response.getResponseFromUser(question.getValidResponses());
        		break;
        	case 4:
        		new_response = null;
        		break;
        	case 5:
        	case 6:
        		info_getter.putString("Please input the correct response(s).\n");
        		new_response = new MatchingRankingResponse(question.getMaxResponses(), question.getInOut());
        		new_response.getResponseFromUser(question.getValidResponses());
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
