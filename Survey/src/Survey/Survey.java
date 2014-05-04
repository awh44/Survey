package Survey;

import java.util.ArrayList;
import Questions.*;
import InputOutput.*;

/**
 * 
 */
public class Survey
{
    ArrayList<Question> questions_;
    InputOutput in_out_;

    /**
     * 
     */
    public Survey()
    {
    	questions_ = new ArrayList<Question>();
        in_out_ = new ConsoleInputOutput();
        in_out_.putString("Would you like to add a question? Please input 1 for yes, 0 for no.");
    	while (in_out_.getIntInRange(0, 1) == 1)
    	{
    		addQuestion();
    		in_out_.putString("Would you like to add another question? Please input 1 for yes, 0 for no.");
    	}
    }

    /**
     * 
     */
    public void addQuestion()
    {
        in_out_.putString("1) Add a new T/F question\n" +
				          "2.) Add a new multiple choice question\n" +
				          "3.) Add a new short answer question\n" +
				          "4.) Add a new essay question\n" +
				          "5.) Add a new ranking question\n" +
				          "6.) Add a new matching question" +
				          "7.) Cancel");
        int question_choice = in_out_.getIntInRange(1, 7);
        Question new_question;
        switch (question_choice)
        {
	        case 1:
	        	new_question = new TrueFalse();
	        	break;
	        case 2:
	        	new_question = new MultipleChoice();
	        	break;
	        case 3:
	        	new_question = new ShortAnswer();
	        	break;
	        case 4:
	        	new_question = new Essay();
	        	break;
	        case 5:
	        	new_question = new Ranking();
	        	break;
	        case 6:
	        	new_question = new Matching();
	        	break;
	        	
	        case 7:
        	default:	//fallthrough
        		return;
        }
        questions_.add(new_question);
    }

    /**
     * 
     */
    public void display()
    {
        for (int i = 0; i < questions_.size(); i++)
        {
        	questions_.get(i).display();
        }
    }

    /**
     * 
     */
    public void gradeTestByTaker(int taker)
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

    /**
     * 
     */
    public void removeQuestion()
    {
        // implement here...
    }

    /**
     * 
     */
    public void save()
    {
        // implement here...
    }

    /**
     * 
     */
    public void tabulateAnswers()
    {
        // implement here...
    }

    /**
     * 
     */
    public void take()
    {
        // implement here...
    }
}
