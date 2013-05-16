package DataSystem;

import java.util.HashSet;
import java.util.Set;

public class Choice implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3404142485157034370L;

	private Set<MultipleChoice> multipleChoice;

	public Set<MultipleChoice> getMultipleChoice()
	{
		if (this.multipleChoice == null)
		{
			this.multipleChoice = new HashSet<MultipleChoice>();
		}
		return this.multipleChoice;
	}

	/**
	 * <pre>
	 *           1..10..*
	 * Choice ------------------------>Matching
	 *                   &gt;       matching
	 * </pre>
	 */
	private Set<Matching> matching;

	public Set<Matching> getMatching()
	{
		if (this.matching == null)
		{
			this.matching = new HashSet<Matching>();
		}
		return this.matching;
	}

	public void setChoice(String chage)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void display()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	private String data;

	public void setData(String value)
	{
		this.data = value;
	}

	public String getData()
	{
		return this.data;
	}

	public Choice(String data_)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public Choice()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

}
