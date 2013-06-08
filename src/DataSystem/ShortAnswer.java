package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShortAnswer extends Essay
{
	private static final long serialVersionUID = -4343050404498262554L;

	public Response take()
	{
		this.display(new ConsoleIO());
		System.out.println("Enter your response, press Enter to finish(Must be 240 characters)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> tempArr = new ArrayList<String>();
		try {
			String temp = br.readLine();
			if(temp.length() > 240)
			{
				System.out.println("Response too long, your response was " + temp.length() + " characters, try again");
				return this.take();
			}
			tempArr.add(temp);
		} catch (IOException e) {
			//Should never get here, handle later if it is found possible
			return null;
		}
		return new Response(this.prompt, tempArr);
	}

	public String getType()
	{
		return "ShortAnswer";
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

	public ShortAnswer(Prompt tempPrompt)
	{
		super(tempPrompt);
	}

}
