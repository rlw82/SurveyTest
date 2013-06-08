package DataSystem;

import java.io.IOException;
import java.util.ArrayList;

public class Test extends Survey
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8529910696342239131L;

	public void modifyAnswers()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public String getClassType()
	{
		return "Test";
	}

	public double grade()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void create() throws IOException
	{
		super.create();
		if (questions.size() != 0)
		{
			for(int i = 0; i < questions.size(); i++)
			{
				Question tempQues = questions.get(i);
				if(tempQues.getType().equals("Essay") || tempQues.getType().equals("ShortAnswer"))
			}
		}
		else
			return;
	}

	public Test()
	{
		//Just need a default constructor, object is either loaded in through serialization or created from line by line input
	}

	private ArrayList<Response> correctAnswers;

	public void setCorrectAnswers(ArrayList<Response> value)
	{
		this.correctAnswers = value;
	}

	public ArrayList<Response> getCorrectAnswers()
	{
		return this.correctAnswers;
	}

}
