package DataSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MultipleChoice extends Question
{
	private static final long serialVersionUID = 7005563851486654225L;

	
	public Response take()
	{
		// TODO implement this operation
		throw new UnsupportedOperationException("not implemented");
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

	public MultipleChoice()
	{
		this.choices = new ArrayList<Choice>();
	}
	
	public MultipleChoice(ArrayList<Choice> choice_,Prompt prompt_)
	{
		this.prompt = prompt_;
		this.choices = choice_;
	}

	public void create() throws IOException
	{
		super.create();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Make a selection\n");
		System.out.println("1) Create another Choice\n2) End Choices");
		String temp = br.readLine();
		int choice;
		try
		{
			choice = Integer.parseInt(temp);

		}
		catch (Exception e)
		{
			System.out
					.println("Invalid selection choose a single digit 1-2\n\n\n\n\n");
			create();
			return;
		}

		if (choice < 1 || choice > 2)
		{
			System.out
					.println("Invalid selection choose a single digit 1-2\n\n\n\n\n");
			create();
			return;
		}
		switch (choice)
		{
		case 1:
			System.out.println("Enter your choice");
			choices.add(new Choice(br.readLine()));
			create();
			return;
		case 2:
			if(choices.size() == 0)
			{
				System.out.println("No choices given cancelling question");
				this.prompt = null;
				return;
			}
			else
			{
				return;
			}
		}
		
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

}
