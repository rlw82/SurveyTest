//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

import java.io.IOException;

//Generic methods which every Questions will use
public abstract class Question implements java.io.Serializable
{

	private static final long serialVersionUID = 8843589270194213785L;
	protected Prompt prompt;

	public abstract String getType();
	
	public Question(Prompt tempPrompt)
	{
		this.prompt = tempPrompt;
	}

	public void setPrompt(Prompt value)
	{
		this.prompt = value;
	}

	public Prompt getPrompt()
	{
		return this.prompt;
	}

	public void display(InputOutput io)
	{
		this.prompt.display(io);
	}

	public abstract Response take() throws IOException;

	public void modify()
	{
		//to do
	}

	public void displayAnswer(InputOutput io, Response response)
	{
		// TODO Auto-generated method stub
		
	}
}
