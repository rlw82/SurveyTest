//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

	public boolean modify() throws IOException
	{
		System.out.println("Enter a new Prompt, Q to keep current");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		if(!temp.toLowerCase().equals("q"))
		{
			this.prompt = new Prompt(temp);
			return true;
		}
		return false;
	}

	public void displayAnswer(InputOutput io, Response response)
	{
		// TODO Auto-generated method stub

	}
}
