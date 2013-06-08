package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MultipleChoice extends Question
{
	private static final long serialVersionUID = 7005563851486654225L;

	public Response take() throws IOException
	{
		this.display(new ConsoleIO());
		System.out.print("Enter a choice");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		try
		{
			ArrayList<String> tempArr = new ArrayList<String>();
			int tempint = Integer.parseInt(temp);
			if(tempint < 1 || tempint > this.choices.size())
			{
				System.out.println("Invalid selection try again");
				return this.take();
			}
			else
			{
				tempArr.add(temp);
				return new Response(this.prompt, tempArr);
			}
		} catch (Exception e) {
			System.out.println("\nInvalid selection");
		}
		return null;
	}

	protected ArrayList<Choice> choices;

	public void setChoices(ArrayList<Choice> value)
	{
		this.choices = value;
	}

	public ArrayList<Choice> getChoices()
	{
		return this.choices;
	}

	public String getType()
	{
		return "MultipleChoice";
	}
	
	public MultipleChoice(Prompt prompt_, ArrayList<Choice> choice_)
	{
		super(prompt_);
		this.choices = choice_;
	}

	public void display(InputOutput io)
	{
		super.display(io);
		for(int i = 0; i < choices.size(); i++)
		{
			io.display(""+(i+1)+") ");
			choices.get(i).display(io);
			io.display("\n");
		}
	}

	public void modify()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
	}
}
