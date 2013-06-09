package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	
	public void displayAnswer(InputOutput io, Response response)
	{
		io.display("No Answers for Essays\n");
	}
	
	public Response take()
	{
		this.display(new ConsoleIO());
		System.out.println("Enter your response, press Enter to finish");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> temp = new ArrayList<String>();
		try {
			temp.add(br.readLine());
		} catch (IOException e) {
			//Should never get here, handle later if it is found possible
		}
		return new Response(this.prompt, temp);
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

	public String getType()
	{
		return "Essay";
	}

}
