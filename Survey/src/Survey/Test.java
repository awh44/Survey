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
	//private data attributes-----------------------
	private ArrayList<Response> correctResponses_;
	private static final long serialVersionUID = 1L;
    
    //Constructor-----------------------------------
    public Test()
    {
    	super();
    }

    //Public methods--------------------------------
    @Override
    public int addQuestion()
    {
        int question_type = super.addQuestion();
        
        if (question_type == 7)
        	return question_type;
        
        Question question = questions_.get(questions_.size() - 1);
        Response new_response;
        InputOutput info_getter = new ConsoleInputOutput();
        switch (question_type)
        {
        	case 1:
        	case 2:
        		info_getter.putString("Please input the correct response(s). (Hit enter after each one.)\n");
        		new_response = new MultipleChoiceTrueFalseResponse(question.getMaxResponses(), question.getInOut());
        		new_response.getResponseFromUser(question.getValidResponses());
        		break;
        	case 3:
        		info_getter.putString("Please input the correct response(s). (Hit enter after each one.)\n");
        		new_response = new ShortAnswerResponse(question.getMaxResponses(), question.getInOut(), ((ShortAnswer) question).getMaxLength());
        		new_response.getResponseFromUser(question.getValidResponses());
        		break;
        	case 4:
        		new_response = null;
        		break;
        	case 5:
        	case 6:
        		info_getter.putString("Please input the correct response(s). (Hit enter after each one.)\n");
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
    
    @Override
    public void display()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	for (int i = 0; i < questions_.size(); i++)
    	{
    		info_getter.putString((i + 1) + ".) ");
    		questions_.get(i).display();
    		if (correctResponses_.get(i) != null)
    		{
    			info_getter.putString("The correct answer(s) are: ");
    			correctResponses_.get(i).display();
    			info_getter.putString("\n");
    		}
    		info_getter.putString("\n");
    	}
    }
    
    @Override
    public boolean modifyQuestion(int question_number)
    {
    	InputOutput info_getter = new ConsoleInputOutput();
        if (super.modifyQuestion(question_number) && correctResponses_.get(question_number - 1) != null)
        {
        	correctResponses_.get(question_number - 1).changeMaxAnswers(questions_.get(question_number - 1).getMaxResponses());
        	info_getter.putString("Please input the correct response(s). (Hit enter after each one.)\n");
        	correctResponses_.get(question_number - 1).getResponseFromUser(questions_.get(question_number - 1).getValidResponses());
        	return true;
        }
        
        if (correctResponses_.get(question_number - 1) != null)
        {
        	info_getter.putString("Would you like to modify the correct responses? Input 1 for yes, 0 for no.\n");
        	int input = info_getter.getIntInRange(0, 1);
        	if (input == 1)
        	{
        		info_getter.putString("Please input the correct response(s). (Hit enter after each one.)\n");
        		correctResponses_.get(question_number - 1).getResponseFromUser(questions_.get(question_number - 1).getValidResponses());
        		return true;
        	}
        }
        
        return false;
    }

    @Override
    public int removeQuestion()
    {
        int question_number = super.removeQuestion();
        correctResponses_.remove(question_number);
        return question_number;
    }

    public void grade()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("Enter the number for the taker you would like to grade. (Between 1 and " + totalTakers_ + ".\n");
    	int taker = info_getter.getIntInRange(1, totalTakers_) - 1;
    	int num_correct = 0;
    	int num_gradable = 0;
        for (int i = 0; i < questions_.size(); i++)
        {
        	if (correctResponses_.get(i) != null)
        	{
        		num_gradable++;
        		if (correctResponses_.get(i).equals(questions_.get(i).getResponseByTaker(taker)));
        		{
        			num_correct++;
        		}
        	}
        }
        
        int num_essay = questions_.size() - num_gradable;
        info_getter = new ConsoleInputOutput();
        info_getter.putString("The score for taker number " + (taker + 1) + " is " + (num_correct * 10) + "/" + (num_gradable * 10) + "\n");
        if (num_essay != 0)
        {
        	info_getter.putString("There remain " + num_essay + " essay questions to be graded.\n");
        }
        
    }
    
    //protected methods---------------------------
    protected void allocateResources()
    {
    	super.allocateResources();
    	correctResponses_ = new ArrayList<Response>();
    }
}
