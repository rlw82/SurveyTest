//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

//Choice class for data for Questions
public class Choice implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3404142485157034370L;

	String choice;

	public void setChoice(String choice_)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void display(InputOutput io)
	{
		io.display(this.choice);
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
		this.choice = data_;
	}
}
