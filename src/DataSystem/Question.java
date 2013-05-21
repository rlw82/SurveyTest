package DataSystem;

import java.util.Scanner;

public class Question implements java.io.Serializable
{

	private static final long serialVersionUID = 8843589270194213785L;
	protected Prompt prompt;

	public void setPrompt(Prompt value)
	{
		this.prompt = value;
	}

	//All questions will at least take a prompt
	public void create()
	{
		System.out.println("Enter a prompt('Q' to cancel):");
		Scanner scan = new Scanner(System.in);
		String temp = scan.next();
		if (temp.toLowerCase().equals("q"))
			prompt = null;
		else
			prompt = new Prompt(temp);
		scan.close();
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

}
