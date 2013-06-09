//Russell Wiley
//CS 350
//Professor Salvage
package DataSystem;

import java.io.IOException;
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
	
	public void modify()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
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
