package DataSystem;

import java.io.IOException;

public class TrueFalse extends MultipleChoice
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7298235727155569817L;

	public Response take()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public void create() throws IOException
	{
		super.create();
		if(this.prompt == null)
		{
			return;
		}
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

	public TrueFalse()
	{
	}

	public TrueFalse(Prompt prompt_)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

}
