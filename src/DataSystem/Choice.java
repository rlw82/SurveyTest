package DataSystem;


public class Choice implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3404142485157034370L;

	String choice;
	
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
		this.choice = data_;
	}
	
	public Choice()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

}
