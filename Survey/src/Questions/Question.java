package Questions;

import java.util.ArrayList;
import Responses.*;
import InputOutput.*;

abstract public class Question
{
    String prompt_;
    ArrayList<Response> responses_;
    InputOutput in_out_;
    int maxAnswers_;

    public Question()
    {
    	allocateResources();
    	defineQuestion();
    }
    
    protected void allocateResources()
    {
    	responses_ = new ArrayList<Response>();
    	in_out_ = new ConsoleInputOutput();	
    }

    public void defineQuestion()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("What would you like the prompt to be?\n");
    	prompt_ = info_getter.getString();
    }

    public void display()
    {
    	in_out_.putString(prompt_ + "\n");
    }

    Response getResponseByTaker(int taker)
    {
        return responses_.get(taker);
    }

    public void modifyQuestion()
	{

    }

    public void newTaker(Response newResponse)
    {
        responses_.add(newResponse);
    }

    public void tabulateAndDisplay()
	{

    }
}
