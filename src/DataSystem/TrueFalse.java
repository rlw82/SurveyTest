package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

	public TrueFalse() throws IOException
	{
		System.out.println("Enter a prompt('Q' to cancel)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		if (temp.toLowerCase().equals("q"))
			prompt = null;
		else
			prompt = new Prompt(temp);
		if(prompt!=null)
		{
			this.choices.add(new Choice("True"));
			this.choices.add(new Choice("False"));
		}
		return;
	}

	public TrueFalse(Prompt prompt_)
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}

}
