import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Matching extends Question
{
	/**
	 * <pre>
	 *           0..*     0..*
	 * Matching ------------------------- Choice
	 *           matching        &lt;       choice
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

	public Responce take()
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

	public Matching(String prompt_, ArrayList left_, ArrayList right_)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public Matching()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void display()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	private ArrayList<Choice> left;
	private ArrayList<Choice> right;

}
