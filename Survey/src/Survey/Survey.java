package Survey;

import java.io.Serializable;

import java.util.ArrayList;

import Questions.*;
import InputOutput.*;

/**
 * 
 */
public class Survey implements Serializable
{
	//data attributes-------------------------------
	private static final long serialVersionUID = 1L;
	protected ArrayList<Question> questions_;

	//Constructor-----------------------------------
    public Survey()
    {
    	allocateResources();
        InputOutput info_getter = new ConsoleInputOutput();
        info_getter.putString("Would you like to add a question? Please input 1 for yes, 0 for no.\n");
    	while (info_getter.getIntInRange(0, 1) == 1)
    	{
    		addQuestion();
    		info_getter.putString("\nWould you like to add another question? Please input 1 for yes, 0 for no.\n");
    	}
    	info_getter.putString("\n");
    }
    
    //public methods--------------------------------
    public int addQuestion()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
        info_getter.putString("1.) Add a new T/F question\n" +
				          "2.) Add a new multiple choice question\n" +
				          "3.) Add a new short answer question\n" +
				          "4.) Add a new essay question\n" +
				          "5.) Add a new ranking question\n" +
				          "6.) Add a new matching question\n" +
				          "7.) Cancel\n");
        int question_type = info_getter.getIntInRange(1, 7);
        Question new_question;
        switch (question_type)
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
        		return question_type;
        }
        questions_.add(new_question);
        return question_type;
    }
    
    public void display()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
        for (int i = 0; i < questions_.size(); i++)
        {
        	info_getter.putString((i + 1) + ".) ");
        	questions_.get(i).display();
        	info_getter.putString("\n");
        }
    }
    
    public void modify()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("What is the number of the question you would like to modify?\n");
    	int number = info_getter.getIntInRange(1, questions_.size());
    	modifyQuestion(number);
    }

    public boolean modifyQuestion(int question_number)
    {
    	return questions_.get(question_number - 1).modifyQuestion();
    }

    public void removeQuestion()
    {
 
    }
    
    public void tabulateAnswers()
    {

    }
    
    public void take()
    {

    }
    
    //protected methods-----------------------------
    protected void allocateResources()
    {
    	questions_ = new ArrayList<Question>();
    }
}
