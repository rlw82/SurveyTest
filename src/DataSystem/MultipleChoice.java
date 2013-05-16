package DataSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MultipleChoice extends Question
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7005563851486654225L;
	/**
	 * <pre>
	 *           0..*     0..*
	 * MultipleChoice ------------------------- Choice
	 *           multipleChoice        &lt;       choice
	 * </pre>
	 */
	private Set<Choice> choice;

	public Set<Choice> getChoice()
	{
		if (this.choice == null)
		{
			this.choice = new HashSet<Choice>();
		}
		return this.choice;
	}

	public Response take()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	private ArrayList<Choice> choices;

	public void setChoices(ArrayList<Choice> value)
	{
		this.choices = value;
	}

	public ArrayList<Choice> getChoices()
	{
		return this.choices;
	}

	public MultipleChoice()
	{

	}

	public MultipleChoice(ArrayList<Choice> answers)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
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

	public void save()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

}
