package DataSystem;

import java.util.ArrayList;

public class MultipleChoice extends Question
{
	private static final long serialVersionUID = 7005563851486654225L;

	
	public Response take()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	protected ArrayList<Choice> choices;

	public void setChoices(ArrayList<Choice> value)
	{
		this.choices = value;
	}

	public ArrayList<Choice> getChoices()
	{
		return this.choices;
	}
	
	public MultipleChoice(Prompt prompt_, ArrayList<Choice> choice_)
	{
		super(prompt_);
		this.choices = choice_;
	}

	public void display()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void modify()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}
}
