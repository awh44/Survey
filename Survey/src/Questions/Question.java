package Questions;

import java.util.ArrayList;
import Responses.*;
import InputOutput.*;

/**
 * 
 */
abstract public class Question
{
    String prompt_;
    ArrayList<Response> responses_;
    InputOutput in_out_;

    public Question()
    {
    	responses_ = new ArrayList<Response>();
    	in_out_ = new ConsoleInputOutput();
    	defineQuestion();
    }

    /**
     * 
     */
    public void defineQuestion()
    {
    	InputOutput info_getter = new ConsoleInputOutput();
    	info_getter.putString("What would you like the prompt to be?");
    	prompt_ = info_getter.getString();
    }

    /**
     * 
     */
    public void display()
    {
    	in_out_.putString(prompt_);
    }

    /**
     * 
     */
    Response getResponseByTaker(int taker)
    {
        return responses_.get(taker);
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
    public void newTaker(Response newResponse)
    {
        responses_.add(newResponse);
    }

    /**
     * 
     */
    public void tabulateAndDisplay()
	{
        // implement here...
    }
}
