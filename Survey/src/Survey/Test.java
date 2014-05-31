package Survey;

import java.util.ArrayList;

import InputOutput.*;
import Questions.Question;
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
        InputOutput info_getter = new InputOutput(new ConsoleInput(), new AudioOutput());
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
        		new_response = new ShortAnswerResponse(question.getMaxResponses(), question.getInOut());
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
    	InputOutput info_getter = new InputOutput(new ConsoleInput(), new AudioOutput());
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
    	InputOutput info_getter = new InputOutput(new ConsoleInput(), new AudioOutput());
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
    	InputOutput info_getter = new InputOutput(new ConsoleInput(), new AudioOutput());
    	info_getter.putString("Enter the number for the taker you would like to grade. (Between 1 and " + totalTakers_ + ".)\n");
    	int taker = info_getter.getIntInRange(1, totalTakers_) - 1;
    	int num_correct = 0;
    	int num_gradable = 0;
    	ArrayList<Integer> essays = new ArrayList<Integer>();
        for (int i = 0; i < questions_.size(); i++)
        {
        	if (correctResponses_.get(i) != null)
        	{
        		num_gradable++;
        		if (correctResponses_.get(i).equals(questions_.get(i).getResponseByTaker(taker)))
        		{
        			num_correct++;
        		}
        	}
        	else
        	{
        		essays.add(i + 1);
        	}
        }
        
        info_getter = new InputOutput(new ConsoleInput(), new AudioOutput());
        info_getter.putString("The score for taker number " + (taker + 1) + " is " + (num_correct * 10) + "/" + (num_gradable * 10) + "\n");
        if (essays.size() != 0)
        {
        	info_getter.putString("There remain " + essays.size() + " essay questions to be graded. (Numbers " + essays + ".)\n");
        }
        
    }
    
    //protected methods---------------------------
    protected void allocateResources()
    {
    	super.allocateResources();
    	correctResponses_ = new ArrayList<Response>();
    }
}
