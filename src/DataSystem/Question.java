package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question implements java.io.Serializable
{

	private static final long serialVersionUID = 8843589270194213785L;
	protected Prompt prompt;

	public void setPrompt(Prompt value)
	{
		this.prompt = value;
	}

	//All questions will at least take a prompt
	public void create() throws IOException
	{
		System.out.println("Enter a prompt('Q' to cancel)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		if (temp.toLowerCase().equals("q"))
			prompt = null;
		else
			prompt = new Prompt(temp);
		br.close();
	}

	public Prompt getPrompt()
	{
		return this.prompt;
	}

	public void display()
	{
		prompt.display();
	}

	public Response take()
	{
		return new Response();
	}

	public void modify()
	{
		//to do
	}
	public static void main(String [] args) throws IOException
	{
		//test
		Question quest = new Question();
		quest.create();
	}
}
