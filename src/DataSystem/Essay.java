package DataSystem;

public class Essay extends Question
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9216347102043281617L;

	public void display(InputOutput io)
	{
		super.display(io);
	}

	public Response take()
	{
		this.display(new ConsoleIO());
		return new Response();
	}

	public Prompt getPrompt()
	{
		return this.prompt;
	}

	public void modify()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

	public Essay(Prompt tempPrompt)
	{
		super(tempPrompt);
	}

}
