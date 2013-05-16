package DataSystem;

public class Question implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8843589270194213785L;
	private Prompt prompt;

	public void setPrompt(Prompt value)
	{
		this.prompt = value;
	}

	public Prompt getPrompt()
	{
		return this.prompt;
	}

	public void display()
	{
		//To do
	}

	public Response take()
	{
		return new Response();
	}

	public void modify()
	{

	}

	public void save()
	{

	}
}
