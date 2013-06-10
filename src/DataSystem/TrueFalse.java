//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TrueFalse extends MultipleChoice
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7298235727155569817L;

	public Response take() throws IOException
	{
		return super.take();
	}

	public String getType()
	{
		return "TrueFalse";
	}

	public boolean modify()
	{
		System.out.println("Enter a new Prompt, Q to keep current");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		try
		{
			temp = br.readLine();
			if(!temp.toLowerCase().equals("q"))
			{
				this.prompt = new Prompt(temp);
				return true;
			}
			return false;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void displayAnswer(InputOutput io, Response response)
	{
		super.displayAnswer(io, response);
	}

	public TrueFalse(Prompt tempPrompt, ArrayList<Choice> tempChoice)
	{
		super(tempPrompt, tempChoice);
	}

}
